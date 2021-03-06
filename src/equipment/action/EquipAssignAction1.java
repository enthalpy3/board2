package equipment.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import equipment.EquipDao;
import equipment.EquipInfo;
import member.MemberDao;
import member.controller.CommandAction;

public class EquipAssignAction1 implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        EquipDao data = new EquipDao();

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("ID");

        if (id != null) {
            List username = data.getMember();
            session.setAttribute("username", username);
        }
		return "equip_assign1.jsp";
	}
}
