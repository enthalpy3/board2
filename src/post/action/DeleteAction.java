package post.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDao;
import member.controller.CommandAction;
import post.PostDao;

public class DeleteAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        PostDao data = new PostDao();

        //HttpSession session = request.getSession();
        String pk = (String)request.getParameter("pk");
        
        String text = null;

        if (pk != null) {
            if (data.removePost(pk) != 0) {
                text = "삭제하였습니다.";
                
            } else {
                text = "삭제하지 못했습니다.";
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/DS/post_info2.do");
            return null;
        }

        request.setAttribute("message", text);

        return "post_delete.jsp";
    }

}
