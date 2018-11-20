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


public class EquipListAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		StringBuffer pageNum = new StringBuffer();
		
		//현재페이지
		int page = 2;
		//한 페이지에 출력될 게시물 수
		int countList = 10;
		//한 화면에 출력될 페이지 수
		int countPage = 10;
		//총게시글수
		int totalCount = 186;
		
		int totalPage = totalCount / countList;

		if (totalCount % countList > 0) {
		    totalPage++;
		}

		if (totalPage < page) {
		    page = totalPage;
		}

		int startPage = ((page - 1) / 10) * 10 + 1;
		int endPage = startPage + countPage - 1;

		if (endPage > totalPage) {
		    endPage = totalPage;
		}

		if (startPage > 1) {
		    pageNum.append("<a href=\"?page=1\">처음</a>");
		}

		if (page > 1) {
			pageNum.append("<a href=\"?pag=" + (page - 1)  + "\">이전</a>");
		}

		for (int iCount = startPage; iCount <= endPage; iCount++) {
		    if (iCount == page) {
		    	pageNum.append(" <b>" + iCount + "</b>");
		    } else {
		    	pageNum.append(" " + iCount + " ");
		    }
		}

		if (page < totalPage) {
			pageNum.append("<a href=\"?page=" + (page + 1)  + "\">다음</a>");
		}

		if (endPage < totalPage) {
			pageNum.append("<a href=\"?page=" + totalPage + "\">끝</a>");
		}
		
		
        EquipDao data = new EquipDao();

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("ID");

        if (id != null) {
            List listNum = data.getQuan();
            session.setAttribute("equipment", listNum);
            session.setAttribute("page", pageNum);
        }
		return "equip_list.jsp";
	}
}
