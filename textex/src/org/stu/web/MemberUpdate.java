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


@WebServlet("/memberUpdate")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();
		
		if (id != null) {
			 dto = dao.selectid(id);
				
				
			 
				request.setAttribute("member", dto);
				request.getRequestDispatcher("/WEB-INF/views/memberupdate.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("member", null);
			request.getRequestDispatcher("/WEB-INF/views/memberupdate.jsp").forward(request, response);
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("1111");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		System.out.println("2222");
		
		MemberDto dto = new MemberDto();
		MemberDao dao = new MemberDao();
		dto.setId(id);
		dto.setName(name);
		dto.setDob(Date.valueOf(dob));
		dto.setEmail(email);
		
	
		 if (dao.memberupdate(dto)) {
			
			
			 HttpSession session = request.getSession();
			 session.setAttribute("msg", "클리어");
			 response.sendRedirect(request.getContextPath()+"/memberlist");
		}else {
			
			request.setAttribute("update", "다시 수정해주세요");
			request.getRequestDispatcher("/WEB-INF/views/memberupdate.jsp").forward(request, response);
		}
		
		
		
		
	}

}
