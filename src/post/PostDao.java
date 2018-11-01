package post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class PostDao extends CommonDao {
	/*
	 * 신규 글 등록
	 */
	public int insertPost(PostInfo post) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO post VALUES(?,?,?,?,?)";
		int res = 0;
		openConnection();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, post.getName());
			pstmt.setString(2, post.getTitle());
			pstmt.setString(3, post.getText());
			// pstmt.setString(4, member.getPhone());
			// pstmt.setString(5, member.getEmail());
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(4, ts);
			pstmt.setInt(5, post.getPk());
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
	 * 글확인
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
	/*
	 * 게시글 전체보기
	 */
	public PostInfo getPost2(String title) {
		
		String rPath = request.getContextPath();
	
		PostInfo post = new PostInfo();
		String query = "select * from post ORDER BY pk DESC";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/my_site?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		String user = "root";
		String pw = "zxcv1234";

		try {
			// mysqlbd 주소
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// mariadb 주소
			openConnection();
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from post ORDER BY pk DESC");
			while (rs.next()) {
				System.out.println("out.print("+"\"<tr>\""+")");
				System.out.println("out.print("+"\"<td>\"" + rs.getString("pk") + "\"</td>\""+")");
				System.out.println("out.print("+"\"<td>\"" + "<h3><a href=\"" + rPath + "/DS/post_info.jsp\"" + ">\""+")");
				System.out.println("out.print("+rs.getString("title") + "</a></h3>" + "</td>\""+")");
				// out.print("<td>" + rs.getString("title") + "</td>");
				System.out.println("out.print("+"\"<td>" + rs.getString("text") + "</td>\""+")");
				System.out.println("out.print("+"\"<td>" + rs.getString("reg_date") + "</td>\""+")");
				System.out.println("out.print("+"\"</tr>\""+")");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rs.close();
		}
	
		
		return post;
	}
}
