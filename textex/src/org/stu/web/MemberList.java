package org.stu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stu.dao.MemberDao;
import org.stu.dto.MemberDto;


@WebServlet("/memberlist")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao dao = new MemberDao();
		MemberDto[] dto = dao.memberlist();
		

		
		 
	
			request.setAttribute("member", dto);
			request.getRequestDispatcher("/WEB-INF/views/memberlist.jsp").forward(request, response);
	}

}
