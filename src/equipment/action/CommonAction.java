package equipment.action;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import equipment.EquipInfo;
import member.MemberInfo;

public class CommonAction {
    // 요청 파라미터를 멤버객체에 담는다.
    public EquipInfo mappingReqEquipment(HttpServletRequest request) throws Throwable {

        EquipInfo equipment = new EquipInfo();
        MemberInfo member = new MemberInfo();
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = (String)parameterNames.nextElement();
            switch(paramName) {
            case "equipname":
                equipment.setEquipname(request.getParameter("equipname"));
                break;
            case "username":
            	equipment.setUsername(request.getParameter("username"));
                break;
            case "model":
            	equipment.setModel(request.getParameter("model"));
                break;
            case "state":
            	equipment.setState(request.getParameter("state"));
                break;
            case "num":
            	equipment.setNum(request.getParameter("num"));
            	break;
            }
        }
        return equipment;
    }
}
