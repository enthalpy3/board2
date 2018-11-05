package post.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import post.PostDao;
import member.MemberDao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class PostListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		PostDao data = new PostDao();
		String rPath = request.getContextPath();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/lteam?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		String user = "root";
		String pw = "zxcv1234";

		try {
			// mysqlbd 주소
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// mariadb 주소
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
		}
		return "/home.do";
	}
}
