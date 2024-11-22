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

@WebServlet("/memberUpdate.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;

	public UpdateServlet() {
		dao = MemberDAOImple.getInstance();
		System.out.println("UpdateServlet()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			RequestDispatcher dispatcher = context.getRequestDispatcher("/memberUpdate.jsp");
			dispatcher.forward(request, response);
			
		} else {
			System.out.println("조회 실패");
			response.sendRedirect("/Homepage_khs/login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		if(emailAgree == null) {
			emailAgree = "off";
		}

		MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		
		System.out.println("수정 : " + vo);

		int result = dao.updateMember(vo);
		if (result == 1) {
			System.out.println("회원정보 수정 완료");
			
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("memberResult.jsp");
			dispatcher.forward(request, response);
//			response.sendRedirect("/Homepage_khs/memberResult.jsp");
		} else {
			System.out.println("회원정보 수정 실패");
			response.sendRedirect("/Homepage_khs/memberUpdate.jsp");
		}
	}

}
