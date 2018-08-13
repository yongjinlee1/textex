package org.stu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stu.dao.MemberDao;
import org.stu.dto.MemberDto;


@WebServlet("/reg1")
public class Reg1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String idcheck = request.getParameter("idcheck");
		
		
		System.out.println(idcheck);
		
		
		MemberDao dao = new MemberDao();
		
		
		int result = dao.idcheck(idcheck);
		
		response.getWriter().println(result);
		
		
		
	}

}
