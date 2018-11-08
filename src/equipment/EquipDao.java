package equipment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import member.MemberInfo;

public class EquipDao extends CommonDao {
	
	public int insertEquip(EquipInfo equipment) {
        PreparedStatement pstmt = null;
        String query = "INSERT INTO member VALUES(?,?,?,?,?,?,?)";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, equipment.getEquipname());
            pstmt.setString(2, equipment.getUsername());
            pstmt.setString(3, equipment.getModel());
            pstmt.setString(4, equipment.getState());
            pstmt.setInt(5, equipment.getQuantity());
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            pstmt.setTimestamp(6, ts);
            pstmt.setInt(7, equipment.getNum());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
	
	//상세보기 페이지에 사용
	public List getEquip() {
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
            	equipment.setNum(rs.getInt("num"));
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
    }
	
	public List getquan() {
        PreparedStatement pstmt = null;
        List listNum = new ArrayList();
        int modelcount = 0;
        String query = "SELECT model, COUNT(*) as count FROM equipment GROUP BY model";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            for(int i=0; rs.next(); i++) {
            	EquipInfo equipment = new EquipInfo();
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
	
	public List getDetail() {
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
            	equipment.setNum(rs.getInt("num"));
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
    }
}