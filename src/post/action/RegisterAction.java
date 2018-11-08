package post.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDao;
import member.MemberInfo;
import member.controller.CommandAction;
import post.PostDao;
import post.PostInfo;

public class RegisterAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8"); /* request 객체에 form을 통해 넘겨 받은 데이터에 맞는 인코딩을 지정해 한글이 깨지는 것을 방지 */

        CommonAction utils = new CommonAction();
        PostInfo post = utils.mappingReqMember(request);
        
        PostDao data = new PostDao();
        String text = null;

        if (data.isPost(post.getId())) {
            if (data.insertPost(post) != 0) {
                // 1.열려있는 세션을 가져온다.
                HttpSession session = request.getSession(false);
                session.setAttribute("ID", post.getId());
                text = " 성공하였습니다.";
            } else {
                text = " 실패하였습니다. 잠시 후 다시 시도해 주세요.";
            }
        } else {
            text = "다시 작성해 주세요.";
        }

        request.setAttribute("message", text);

        return "post_reg.jsp";
    }
}
