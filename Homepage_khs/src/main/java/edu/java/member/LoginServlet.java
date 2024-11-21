package edu.java.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
       
    public LoginServlet() {
    	dao = MemberDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/Homepage_khs/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		MemberVO vo = dao.selectUser(userid);
		
		if(userid.equals(vo.getUserid()) && password.equals(vo.getPassword())) {
			System.out.println("사용자 조회 성공");
			session.setAttribute("userid", userid);
			session.setMaxInactiveInterval(60);
			response.sendRedirect("/Homepage_khs/memberResult.jsp");
		} else {
			response.sendRedirect("/Homepage_khs/login.jsp");
		}
	}

}
