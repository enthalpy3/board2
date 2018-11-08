package equipment.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import equipment.EquipDao;
import equipment.EquipInfo;
import member.controller.CommandAction;

public class AssignRegisterAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

        CommonAction utils = new CommonAction();
        EquipInfo equipment = utils.mappingReqEquipment(request);
        
        EquipDao data = new EquipDao();
        String text = null;

        if (data.addUsername(equipment) != 0) {
            text = "비품배정에 성공하였습니다.";
        } else {
            text = "비품배정에 실패하였습니다. 잠시 후 다시 시도해 주세요.";
        }

        request.setAttribute("message", text);
        
		return "reg_assign.jsp";
	}
}
