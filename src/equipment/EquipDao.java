package equipment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import member.MemberInfo;

public class EquipDao extends CommonDao {
	
	//비품등록하기
	//수량을 입력 받아서 Integer로 변환 후 적용
	public int insertEquip(EquipInfo equipment) {
        PreparedStatement pstmt = null;
        int quantity = Integer.parseInt(equipment.getQuantity());
        String query = "INSERT INTO equipment VALUES(?,?,?,?,?,?,?)";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            for(int i=0; i < quantity; i++) {
            	pstmt.setString(1, equipment.getEquipname());
            	pstmt.setString(2, equipment.getUsername());
            	pstmt.setString(3, equipment.getModel());
            	pstmt.setString(4, equipment.getState());
            	Timestamp ts = new Timestamp(System.currentTimeMillis());
            	pstmt.setTimestamp(5, ts);
            	pstmt.setString(6, equipment.getReg_date2());
            	pstmt.setString(7, equipment.getNum());
            	res = pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
	
	//비품 목록 페이지에서 모델의 이름이 같은것 끼리의 수량
	public List getQuan(int page2) {
        PreparedStatement pstmt = null;
        List listNum = new ArrayList();
//        String query = "SELECT TB.model, TB.equipname, TB.count FROM (SELECT model, equipname, COUNT(*) as count, ROW_NUMBER() OVER() as ROWNO FROM equipment WHERE state='입고' GROUP BY model) as TB WHERE TB.ROWNO >= 1 AND TB.ROWNO <= 2";
        String query = "SELECT model, equipname, COUNT(*) as count FROM equipment WHERE state='입고' GROUP BY model limit ?, 5";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, page2);
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
	
	//그룹으로 묶은 게시글수의 개수를 가져오기 위한 쿼리
    public List getRowNum() {
    	PreparedStatement pstmt = null;
        List rowNum = new ArrayList();
        String query = "SELECT model, COUNT(*) as count FROM equipment WHERE state='입고' GROUP BY model";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            for(int i=0; rs.next(); i++) {
            	EquipInfo equipment = new EquipInfo();
            	equipment.setCount(rs.getInt("count"));
            	
            	rowNum.add(i, equipment);            	
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rowNum;
    }

	
	//비품 상세페이지에서 상태,날짜별로 수량
	public List getDetail(String model) {
        PreparedStatement pstmt = null;
        List list = new ArrayList();
        String query = "SELECT DATE_FORMAT(reg_date, '%Y-%m-%d') as date, DATE_FORMAT(reg_date2, '%Y-%m-%d') as reg_date3, state, COUNT(*) as count FROM equipment Where model=? GROUP BY date, reg_date3, state";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, model);
            ResultSet rs = pstmt.executeQuery();
            for(int i=0; rs.next(); i++) {
            	EquipInfo equipment = new EquipInfo();
                equipment.setDate(rs.getString("date"));
                equipment.setReg_date3(rs.getString("reg_date3"));
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
	
	//상세보기에서 배정할시 고유번호가 자동으로 들어감
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
            equipment.setNum(rs.getString("num"));
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
	
	
	//상세페이지에서 배정가능 비품 불러오기
	public List getAssignEquip(String model) {
        PreparedStatement pstmt = null;

        List assignEquip = new ArrayList();
        String query = "SELECT * FROM equipment WHERE model=? AND username = '배정가능' AND state = '입고'";
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
	
	//폐기
	public int equipDisposal(EquipInfo equipment) {
		PreparedStatement pstmt = null;
        String query = "UPDATE equipment SET state='폐기', reg_date2=? WHERE num=?";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            pstmt.setTimestamp(1, ts);
            pstmt.setString(2, equipment.getNum());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
	}
	
	public int deleteUsername(String username) {
		PreparedStatement pstmt = null;
        String query = "UPDATE equipment SET username='배정가능' WHERE username=?";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
	}
}