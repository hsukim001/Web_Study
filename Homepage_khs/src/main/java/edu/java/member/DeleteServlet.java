package edu.java.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/memberDelete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
       
    public DeleteServlet() {
    	dao = MemberDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/Homepage_khs/memberDelete");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userid = request.getParameter("userid");
		
		int result = dao.deleteMember(userid);
		if(result == 1) {
			System.out.println("회원 탈퇴 완료");
			session.invalidate();
			response.sendRedirect("/Homepage_khs/login.jsp");
		} else {
			System.out.println("회원 탈퇴 실패");
			response.sendRedirect("/Homepage_khs/memberResult.jsp");
		}
	}

}
