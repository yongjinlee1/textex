package org.stu.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.stu.dao.MemberDao;
import org.stu.dto.MemberDto;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/registerform.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
	
		
		MemberDto dto = new MemberDto();

		dto.setName(name);
		dto.setId(id);
		dto.setEmail(email);
		dto.setDob(Date.valueOf(dob));
		
		
		MemberDao dao = new MemberDao();
	
		if (dao.insertMember(dto)) {
			
			response.sendRedirect(request.getContextPath()+"/memberlist");
			
		}else {
			request.setAttribute("error", "오류가 생겼습니다");
			request.getRequestDispatcher("/WEB-INF/views/registerform.jsp").forward(request, response);			
		}

		

	}

}
