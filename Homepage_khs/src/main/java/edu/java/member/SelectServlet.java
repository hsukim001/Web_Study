package edu.java.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/memberInfo.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO dao;

	public SelectServlet() {
		dao = MemberDAOImple.getInstance();
		System.out.println("SelectServlet()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/Homepage_khs/loginResult.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("selectMember doPost 시작");
		HttpSession session = request.getSession();
		
		String userid = (String) session.getAttribute("userid");

		MemberVO vo = dao.selectUser(userid);
		
		System.out.println("조회 : " + vo);
		
		if (vo != null) {
			System.out.println("조회 성공");
			
			request.setAttribute("userid", userid);
			request.setAttribute("password", vo.getPassword());
			request.setAttribute("email", vo.getEmail());
			request.setAttribute("emailAgree", vo.getEmailAgree());
			request.setAttribute("interest", vo.getInterest());
			request.setAttribute("phone", vo.getPhone());
			request.setAttribute("introduce", vo.getIntroduce());

			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/memberResult.jsp");
			dispatcher.forward(request, response);
			
		} else {
			System.out.println("조회 실패");
			response.sendRedirect("/Homepage_khs/login.jsp");
		}

	}

}
