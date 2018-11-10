package equipment.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import equipment.EquipDao;
import equipment.EquipInfo;
import member.controller.CommandAction;

public class EquipAssignAction2 implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        EquipDao data = new EquipDao();

        HttpSession session = request.getSession();
        String num = (String)request.getParameter("num");
        String id = (String)session.getAttribute("ID");

        if (num != null) {            
            EquipInfo equipment = data.getAssignNum(num);
            session.setAttribute("equip", equipment);
        }
        if (id != null) {
            List username = data.getMember();
            session.setAttribute("username", username);
        }
        return "equip_assign2.jsp";
	}
}
