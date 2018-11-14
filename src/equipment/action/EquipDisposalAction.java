package equipment.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import equipment.EquipDao;
import equipment.EquipInfo;
import member.controller.CommandAction;

public class EquipDisposalAction implements CommandAction  {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

        CommonAction utils = new CommonAction();
        EquipInfo equipment = utils.mappingReqEquipment(request);
        
        EquipDao data = new EquipDao();
        String text = null;

        if (data.equipDisposal(equipment) != 0) {
            text = "비품폐기에 성공하였습니다.";
        } else {
            text = "비품폐기에 실패하였습니다. 잠시 후 다시 시도해 주세요.";
        }

        request.setAttribute("message", text);
        
		return "reg_disposal.jsp";
	}
}

