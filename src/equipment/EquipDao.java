package equipment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import member.MemberInfo;

public class EquipDao extends CommonDao {
	
	public int insertEquip(EquipInfo equipment) {
        PreparedStatement pstmt = null;
        String query = "INSERT INTO member VALUES(?,?,?,?,?,?)";
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
            pstmt.setInt(6, equipment.getNum());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
	
	public EquipInfo getEquip() {
        PreparedStatement pstmt = null;
        EquipInfo equipment = new EquipInfo();
        String query = "SELECT * FROM equipment ORDER BY reg_date";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	equipment.setEquipname(rs.getString("equipname"));
            	equipment.setUsername(rs.getString("username"));
            	equipment.setModel(rs.getString("model"));
            	equipment.setState(rs.getString("state"));
            	equipment.setNum(rs.getInt("num"));
            	equipment.setReg_date(rs.getTimestamp("reg_date"));
            	rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return equipment;
    }
	
	public EquipInfo getQuantity(String equipname, String model) {
		PreparedStatement pstmt = null;
		EquipInfo equipment = new EquipInfo();
		String query = "SELECT * FROM equipment WHERE equipname=? AND model=?";
		openConnection();
		try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, equipname);
            pstmt.setString(2, model);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            equipment.setEquipname(rs.getString("equipname"));
            equipment.setUsername(rs.getString("username"));
            equipment.setModel(rs.getString("model"));
            equipment.setState(rs.getString("state"));
            equipment.setReg_date(rs.getTimestamp("reg_date"));
            equipment.setNum(rs.getInt("num"));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return equipment;
	}
}