package equipment.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import equipment.EquipDao;
import equipment.EquipInfo;
import member.controller.CommandAction;

public class EquipDetailAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        EquipDao data = new EquipDao();

        HttpSession session = request.getSession();
        String model = (String)request.getParameter("model");

        if (model != null) {
            List list  = data.getDetail(model);
            session.setAttribute("equipment", list);
            
            EquipInfo equipment = data.getEquip(model);
            session.setAttribute("equip", equipment);
            
            List user = data.getUser(model);
            session.setAttribute("username", user);
            
            List assignEquip = data.getAssignEquip(model);
            session.setAttribute("assignEquip", assignEquip);
        }
		return "equip_detail.jsp";
	}
}
