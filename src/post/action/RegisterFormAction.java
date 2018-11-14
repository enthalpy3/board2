package post.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDao;
import member.MemberInfo;
import member.controller.CommandAction;
import post.PostDao;
import post.PostInfo;

public class RegisterFormAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    	MemberDao data = new MemberDao();

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("ID");

        if (id != null) {
            MemberInfo member = data.getMember(id);
            session.setAttribute("member", member);
        }    
        return "post_form.jsp";
    }
}
