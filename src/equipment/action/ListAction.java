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
        List list = new ArrayList();

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("ID");

        if (id != null) {
            EquipInfo equipment = data.getEquip();
            list.add(equipment);
            session.setAttribute("equipment", list);
        }
		return "equipment_list.jsp";
	}
}
