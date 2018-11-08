package post.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;

import post.PostDao;
import post.PostInfo;

public class PostDetailAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        
        PostDao data = new PostDao();

        HttpSession session = request.getSession();
        String pk = (String)request.getParameter("pk");

        if (pk != null) {
            PostInfo post = data.getPost(pk);
            session.setAttribute("post", post);
           
        }        

        return "post_detail.jsp";
    }

}
