package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import equipment.EquipDao;
import member.MemberDao;
import member.MemberInfo;
import member.controller.CommandAction;

public class DeleteAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        MemberDao data = new MemberDao();
        EquipDao data2 = new EquipDao();

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("ID");
        
        String text = null;

        if (id != null) {
        	MemberInfo member = data.getMember(id);
        	String username = member.getName();
        	data2.deleteUsername(username);
            if (data.removeMember(id) != 0) {
                text = "회원정보 삭제하였습니다.";
                session.invalidate();
            } else {
                text = "회원정보 삭제하지 못했습니다.";
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/home.do");
            return null;
        }

        request.setAttribute("message", text);

        return "delete.jsp";
    }

}
