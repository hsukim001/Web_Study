package edu.java.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectMember.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO dao;

	public SelectServlet() {
		dao = MemberDAOImple.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/Homepage_khs/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");

		MemberVO vo = dao.selectUser(userid);

		if (vo != null) {
			System.out.println("조회 성공");
			
			request.setAttribute("userid", userid);
			request.setAttribute("password", vo.getPassword());
			request.setAttribute("email", vo.getEmail());
			request.setAttribute("emailAgree", vo.getEmailAgree());
			request.setAttribute("interest", vo.getInterest());
			request.setAttribute("phone", vo.getPhone());
			request.setAttribute("introduce", vo.getIntroduce());

			response.sendRedirect("/Homepage_khs/memberResult.jsp");
		} else {
			System.out.println("조회 실패");
			response.sendRedirect("/Homepage_khs/login.jsp");
		}

	}

}
