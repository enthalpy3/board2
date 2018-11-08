package equipment.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import equipment.EquipDao;
import equipment.EquipInfo;
import member.MemberDao;
import member.MemberInfo;
import member.controller.CommandAction;


public class ListAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        EquipDao data = new EquipDao();

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("ID");

        if (id != null) {
            List list = data.getEquip();
            session.setAttribute("equipment", list);
            List listNum = data.getquan();
            session.setAttribute("equip", listNum);
        }
		return "equip_list.jsp";
	}
}
