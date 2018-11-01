package post.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import post.PostDao;
import post.controller.CommandAction;

public class DeleteAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        PostDao data = new PostDao();

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("ID");
        
        String text = null;

        if (id != null) {
            if (data.removePost(id) != 0) {
                text = "글을삭제 했다.";
                
            } else {
                text = "삭제하지 못했습니다.";
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/home.do");
            return null;
        }

        request.setAttribute("message", text);

        return "post_delete.jsp";
    }

}
