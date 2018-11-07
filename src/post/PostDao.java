package post;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


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

	public PostInfo getPost(String title) {
		//PreparedStatement pstmt = null;
		PostInfo post = new PostInfo();
		String query = "select * from post ORDER BY pk DESC";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		//ArrayList<String> postList = new ArrayList<>();
		try {
			// mysqlbd 주소
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// mariadb 주소
			
			openConnection();
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from post WHERE pk=100");
			while (rs.next()) {
				post.setId(rs.getString("id"));
				post.setPk(rs.getString("pk"));
				post.setName(rs.getString("name"));
				post.setTitle(rs.getString("title"));
				post.setText(rs.getString("text"));
				post.setReg_date(rs.getTimestamp("reg_date"));
			
				System.out.println("out.print("+"\"<tr>\""+")");
				System.out.println("out.print("+"\"<td>\"" + rs.getString("pk") + "\"</td>\""+")");
				System.out.println("out.print("+rs.getString("title") + "</td>\""+")");
				System.out.println("out.print("+"\"<td>" + rs.getString("text") + "</td>\""+")");
				System.out.println("out.print("+"\"<td>" + rs.getString("reg_date") + "</td>\""+")");
				System.out.println("out.print("+"\"</tr>\""+")");
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}
	

	public List getPost2( ) {
		// PreparedStatement pstmt = null;
		// PostInfo post = new PostInfo();
		String query = "select * from post ORDER BY pk DESC";
		List list = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		// ArrayList<String> postList = new ArrayList<>();
		try {
			// mysqlbd 주소
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// mariadb 주소

			openConnection();
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from post ORDER BY pk DESC");
			// while (rs.next()) {
			for (int i = 0; rs.next(); i++) {
				PostInfo post = new PostInfo();
				post.setPk(rs.getString("pk"));
				post.setName(rs.getString("name"));
				post.setTitle(rs.getString("title"));
				post.setText(rs.getString("text"));
				post.setReg_date(rs.getTimestamp("reg_date"));
				list.add(i, post);
			}
			rs.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
