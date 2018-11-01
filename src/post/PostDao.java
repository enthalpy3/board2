package post;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class PostDao extends CommonDao {
	/*
	 * 신규 글 등록
	 */
	public int insertPost(PostInfo member) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO post VALUES(?,?,?,?)";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getTitle());
			pstmt.setString(3, member.getText());
			// pstmt.setString(4, member.getPhone());
			// pstmt.setString(5, member.getEmail());
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(4, ts);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	/*
	 * 게시글 삭제
	 */
	public int removePost(String title) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM post WHERE title=?";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	/*
	 * 게시글 수정
	 */
	public int updatePost(PostInfo post) {
		PreparedStatement pstmt = null;
		String query = "UPDATE post SET title=?, text=? WHERE name=?";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getText());
			// pstmt.setString(3, post.getPhone());
			// pstmt.setString(4, member.getEmail());
			pstmt.setString(3, post.getName());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	/*
	 * 회원가입 여부 확인
	 */
	
	public boolean isPost(String name, String title) {
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM post WHERE name=? and title=?";
		boolean res = false;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
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
	 * 게시글 상세 보기
	 */
	public PostInfo getPost(String title) {
		PreparedStatement pstmt = null;
		PostInfo post = new PostInfo();
		String query = "SELECT * FROM post WHERE title=?";
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			post.setName(rs.getString("name"));
			post.setTitle(rs.getString("title"));
			post.setText(rs.getString("text"));
			//member.setPhone(rs.getString("phone"));
			//member.setEmail(rs.getString("email"));
			post.setReg_date(rs.getTimestamp("reg_date"));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return post;
	}
}
