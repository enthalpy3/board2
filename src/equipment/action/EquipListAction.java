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
		
		
		EquipDao data = new EquipDao();
		HttpSession session = request.getSession();
		String page1 = (String)request.getParameter("page");
		String id = (String)session.getAttribute("ID");
		StringBuffer pageNum = new StringBuffer();
		int page;
		
		if(page1 == "") {
			page = 1;
		} else {
			page = Integer.parseInt(page1);
		}
		
		//한 페이지에 출력될 게시물 수
		int countList = 5;
		
		//한 화면에 출력될 페이지 수
		int countPage = 10;
		
		//총게시글수
		List rowNum = data.getRowNum();
		int totalCount = rowNum.size();
		
		//필요한 총 페이지수
		int totalPage = totalCount / countList;

		int startCount = (page -1) * countPage + 1;
		
		int endCount = page * countPage;
		
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
			pageNum.append("<a href=\"?page=" + (page - 1)  + "\">이전</a>");
		}

		for (int iCount = startPage; iCount <= endPage; iCount++) {
		    if (iCount == page) {
		    	pageNum.append("<a href=\"?page=" + iCount + "\">" + "<b>" + iCount + "</b>" + "</a>");
		    } else {
		    	pageNum.append("<a href=\"?page=" + iCount + "\">" + " " + iCount + " " + "</a>");
		    }
		}

		if (page < totalPage) {
			pageNum.append("<a href=\"?page=" + (page + 1)  + "\">다음</a>");
		}

		if (endPage < totalPage) {
			pageNum.append("<a href=\"?page=" + totalPage + "\">끝</a>");
		}
		int page2 = (page - 1) * 5;

        if (id != null) {
            List listNum = data.getQuan(page2);
            session.setAttribute("equipment", listNum);
            session.setAttribute("page", pageNum);
        }
		return "equip_list.jsp";
	}
}
