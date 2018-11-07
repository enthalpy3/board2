package post.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDao;
import member.MemberInfo;
import member.controller.CommandAction;
import post.PostDao;
import post.PostInfo;

public class PostInfoAction2 implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        
        PostDao data = new PostDao();

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("ID");

        if (id != null) {
            PostInfo post = data.getPost(id);
            session.setAttribute("post", post);
        }        

        return "post_info2.jsp";
    }

}
