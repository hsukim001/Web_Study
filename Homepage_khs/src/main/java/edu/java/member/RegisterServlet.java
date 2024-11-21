package edu.java.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
       
    public RegisterServlet() {
    	dao = MemberDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/Homepage_khs/memberRegister.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		
		int result = dao.insertMember(vo);
		if(result == 1) {
			System.out.println("성공");
			response.sendRedirect("/Homepage_khs/login.jsp");
		} else {
			System.out.println("실패");
			response.sendRedirect("/Homepage_khs/memberRegister.jsp");
		}
	}

}
