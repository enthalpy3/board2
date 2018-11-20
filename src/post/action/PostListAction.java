package post.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import post.PostDao;


public class PostListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		PostDao data = new PostDao();

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");

		
			List postList = data.getList();
			session.setAttribute("post", postList);
		
		return "post_list.jsp";
	}
}
