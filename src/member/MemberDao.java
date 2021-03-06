package member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import equipment.EquipInfo;

public class MemberDao extends CommonDao {
    /*
     * 신규 회원정보 삽입
     */
    public int insertMember(MemberInfo member) {
        PreparedStatement pstmt = null;
        String query = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?)";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPass());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getPhone());
            pstmt.setString(5, member.getEmail());
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            pstmt.setTimestamp(7, ts);
            pstmt.setInt(8, member.getNum());
            pstmt.setString(6, member.getRecommender());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    /*
     * 기존 회원정보 삭제
     */
    public int removeMember(String id) {
        PreparedStatement pstmt = null;
        String query1 = "DELETE FROM member WHERE id=?";
        String query2 = "DELETE FROM post WHERE id=?";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query1);
            pstmt.setString(1, id);
            res = pstmt.executeUpdate();
            pstmt = con.prepareStatement(query2);
            pstmt.setString(1, id);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    /*
     * 기존 회원정보 수정
     */
    public int updateMember(MemberInfo member) {
        PreparedStatement pstmt = null;
        String query = "UPDATE member SET pass=?, name=?, phone=?, email=?, recommender=? WHERE id=?";
        int res = 0;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, member.getPass());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getPhone());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getRecommender());
            pstmt.setString(6, member.getId());
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    /*
     * 회원가입 중복확인
     */
    public boolean isMember(String id, String pass) {
        PreparedStatement pstmt = null;
        String query = "SELECT * FROM member WHERE id=? and pass=?";
        boolean res = false;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            res = rs.next();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    /*
     * 비밀번호 확인
     */
    public boolean isMember2(String pass) {
        PreparedStatement pstmt = null;
        String query = "SELECT * FROM member WHERE pass=?";
        boolean res = false;
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, pass);
            ResultSet rs = pstmt.executeQuery();
            res = rs.next();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    /*
     * 기존 회원정보 확인
     */
    public MemberInfo getMember(String id) {
        PreparedStatement pstmt = null;
        MemberInfo member = new MemberInfo();
        String query = "SELECT * FROM member WHERE id=?";
        openConnection();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            member.setId(rs.getString("id"));
            member.setPass(rs.getString("pass"));
            member.setName(rs.getString("name"));
            member.setPhone(rs.getString("phone"));
            member.setEmail(rs.getString("email"));
            member.setReg_date(rs.getTimestamp("reg_date"));
            member.setRecommender(rs.getString("recommender"));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return member;
    }
    
 // 이름을 추가한다?
 	/*public List getMemberList() {
         PreparedStatement pstmt = null;
         List listNum = new ArrayList();
         String query = "SELECT name FROM member";
         openConnection();
         try {
             pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery();
             for(int i=0; rs.next(); i++) {
             	MemberInfo member = new MemberInfo();
             	member.setName(rs.getString("name"));
             	listNum.add(i, member);
             }
             rs.close();
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             closeConnection();
         }
         return listNum;
     }*/

}
