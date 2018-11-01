package post.action;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import post.PostInfo;

public class CommonAction {
    // 요청 파라미터를 멤버객체에 담는다.
    public PostInfo mappingReqMember(HttpServletRequest request) throws Throwable {

        PostInfo post = new PostInfo();
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = (String)parameterNames.nextElement();
            switch(paramName) {
            case "name":
                post.setName(request.getParameter("name"));
                break;
            case "title":
                post.setTitle(request.getParameter("title"));
                break;
            case "text":
                post.setText(request.getParameter("text"));
                break;          
            }
        }

        return post;
    }
}
