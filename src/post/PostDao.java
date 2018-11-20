package post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import file.FileDTOInfo;

public class PostDao extends CommonDao {
	/*
	 * 신규 글 등록
	 */
	public int insertPost(PostInfo post) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO post VALUES(?,?,?,?,?,?)";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, post.getId());
			pstmt.setString(2, post.getName());
			pstmt.setString(3, post.getTitle());
			pstmt.setString(4, post.getText());
			// pstmt.setString(4, member.getPhone());
			// pstmt.setString(5, member.getEmail());
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(5, ts);
			pstmt.setString(6, post.getPk());
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
	public int removePost(String pk) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM post WHERE pk=?";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, pk);
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
		String query = "UPDATE post SET title=?, text=?, name=? WHERE pk=?";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getText());
			// pstmt.setString(3, post.getPhone());
			pstmt.setString(3, post.getName());
			pstmt.setString(4, post.getPk());

			res = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return res;
	}

	/*
	 * 글확인
	 */

	public boolean isPost(String id) {
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM post WHERE id=?";
		boolean res = false;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
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
	 * 게시글 전체보기 세션으로 포스트 정보를 불러올수있다.
	 */

	public PostInfo getPost(String pk) {
		// PreparedStatement pstmt = null;
		PostInfo post = new PostInfo();
		// String query = "select * from post ORDER BY pk DESC";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			openConnection();
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from post WHERE pk=" + pk + "");
			while (rs.next()) {
				post.setId(rs.getString("id"));
				post.setPk(rs.getString("pk"));
				post.setName(rs.getString("name"));
				post.setTitle(rs.getString("title"));
				post.setText(rs.getString("text"));
				post.setReg_date(rs.getTimestamp("reg_date"));
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}

	// 업로드된 파일 리스트 형식으로 만든다.
	public ArrayList<PostInfo> getList() {
		String query = "SELECT * FROM post";
		ArrayList<PostInfo> list = new ArrayList<PostInfo>();
		PreparedStatement pstmt = null;
		int res = 0;
		openConnection();
		;
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			res = pstmt.executeUpdate();
			while (rs.next()) {
				PostInfo postList = new PostInfo();
				postList.setId(rs.getString("id"));
				postList.setName(rs.getString("name"));
				postList.setTitle(rs.getString("title"));
				postList.setText(rs.getString("text"));
				postList.setReg_date(rs.getTimestamp("reg_date"));
				postList.setPk(rs.getString("pk"));
				list.add(postList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
