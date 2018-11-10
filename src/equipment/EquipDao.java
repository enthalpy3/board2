package equipment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import member.MemberInfo;

public class EquipDao extends CommonDao {
	//비품등록하기
	public int insertEquip(EquipInfo equipment) {
        PreparedStatement pstmt = null;
        String query = "INSERT INTO equipment VALUES(?,?,?,?,?,?)";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, equipment.getEquipname());
            pstmt.setString(2, equipment.getUsername());
            pstmt.setString(3, equipment.getModel());
            pstmt.setString(4, equipment.getState());
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            pstmt.setTimestamp(5, ts);
            pstmt.setString(6, equipment.getNum());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
	
	//비품 목록 페이지에서 모델의 이름이 같은 수량 세기
	public List getQuan() {
        PreparedStatement pstmt = null;
        List listNum = new ArrayList();
        String query = "SELECT model, equipname, COUNT(*) as count FROM equipment WHERE state='입고' GROUP BY model";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            for(int i=0; rs.next(); i++) {
            	EquipInfo equipment = new EquipInfo();
            	equipment.setEquipname(rs.getString("equipname"));
            	equipment.setModel(rs.getString("model"));
            	equipment.setCount(rs.getInt("count"));
            	
            	listNum.add(i, equipment);            	
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return listNum;
    }
	
	//비품 상세페이지에서 상태,날짜별로 수량세기
	public List getDetail(String model) {
        PreparedStatement pstmt = null;
        List list = new ArrayList();
        String query = "SELECT DATE_FORMAT(reg_date, '%Y-%m-%d') as date, state, COUNT(*) as count FROM equipment Where model=? GROUP BY date, state";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, model);
            ResultSet rs = pstmt.executeQuery();
            for(int i=0; rs.next(); i++) {
            	EquipInfo equipment = new EquipInfo();
                equipment.setDate(rs.getString("date"));
            	equipment.setState(rs.getString("state"));
            	equipment.setCount(rs.getInt("count"));
            	
            	list.add(i, equipment);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

	//상세보기 페이지에 사용
	public EquipInfo getEquip(String model) {
        PreparedStatement pstmt = null;
        EquipInfo equipment = new EquipInfo();
        String query = "SELECT * FROM equipment WHERE model=?";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, model);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            equipment.setEquipname(rs.getString("equipname"));
            equipment.setUsername(rs.getString("username"));
            equipment.setModel(rs.getString("model"));
            equipment.setState(rs.getString("state"));
            equipment.setNum(rs.getString("num"));
            equipment.setReg_date(rs.getTimestamp("reg_date"));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return equipment;
    }
	
	public EquipInfo getAssignNum(String num) {
        PreparedStatement pstmt = null;
        EquipInfo equipment = new EquipInfo();
        String query = "SELECT * FROM equipment WHERE num=?";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, num);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            equipment.setEquipname(rs.getString("equipname"));
            equipment.setUsername(rs.getString("username"));
            equipment.setModel(rs.getString("model"));
            equipment.setState(rs.getString("state"));
            equipment.setNum(rs.getString("num"));
            equipment.setReg_date(rs.getTimestamp("reg_date"));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return equipment;
    }
	
	//비품 배정 유저이름 수정하기
	public int addUsername(EquipInfo equipment) {
		PreparedStatement pstmt = null;
        String query = "UPDATE equipment SET username=? WHERE equipname=? AND num=?";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, equipment.getUsername());
            pstmt.setString(2, equipment.getEquipname());
            pstmt.setString(3, equipment.getNum());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
	}

	//상세페이지에서 사용자 명단 불러오기
	public List getUser(String model) {
        PreparedStatement pstmt = null;

        List user = new ArrayList();
        String query = "SELECT * FROM equipment WHERE model=? AND username != '배정가능'";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, model);
            ResultSet rs = pstmt.executeQuery();
            for(int i=0; rs.next(); i++) {
            	EquipInfo username = new EquipInfo();
            	username.setUsername(rs.getString("username"));
            	username.setNum(rs.getString("num"));
            	username.setState(rs.getString("state"));            
            	username.setReg_date(rs.getTimestamp("reg_date"));

            	user.add(i, username);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }
	
	//username 불러오기
	public List getMember() {
		PreparedStatement pstmt = null;
		List username = new ArrayList();
		String query = "SELECT * FROM member";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			for(int i=0; rs.next(); i++) {
				MemberInfo member = new MemberInfo();
				member.setName(rs.getString("name"));

				username.add(i, member);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return username;
	}
	
	//상세페이지에서 사용자 명단 불러오기
	public List getAssignEquip(String model) {
        PreparedStatement pstmt = null;

        List assignEquip = new ArrayList();
        String query = "SELECT * FROM equipment WHERE model=? AND username = '배정가능'";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, model);
            ResultSet rs = pstmt.executeQuery();
            for(int i=0; rs.next(); i++) {
            	EquipInfo username = new EquipInfo();
            	username.setUsername(rs.getString("username"));
            	username.setNum(rs.getString("num"));
            	username.setState(rs.getString("state"));            
            	username.setReg_date(rs.getTimestamp("reg_date"));

            	assignEquip.add(i, username);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return assignEquip;
    }
	
	//비품 반납 유저이름 수정하기
	public int returnUsername(EquipInfo equipment) {
		PreparedStatement pstmt = null;
        String query = "UPDATE equipment SET username=? WHERE num=?";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, equipment.getUsername());
            pstmt.setString(2, equipment.getNum());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
	}
	
	
	//상세보기페이지 사용
	/*public List getDetail() {
        PreparedStatement pstmt = null;
        List list = new ArrayList();
        String query = "SELECT * FROM equipment ORDER BY reg_date";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            for(int i=0; rs.next(); i++) {
            	EquipInfo equipment = new EquipInfo();
            	equipment.setEquipname(rs.getString("equipname"));
            	equipment.setUsername(rs.getString("username"));
            	equipment.setModel(rs.getString("model"));
            	equipment.setState(rs.getString("state"));
            	equipment.setNum(rs.getString("num"));
            	equipment.setQuantity(rs.getInt("quantity"));
            	equipment.setReg_date(rs.getTimestamp("reg_date"));
            	
            	list.add(i, equipment);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }*/
}