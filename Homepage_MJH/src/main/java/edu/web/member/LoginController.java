package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * TODO : login.jsp에서 입력받은 아이디, 패스워드를 DB의 데이터와 비교해서
 * 데이터가 일치하면 - 로그인 세션 생성 및 로그인 성공(loginResult.jsp)로 이동
 * (아이디 값에 대한 세션 생성. 세션 만료 시간 60초)
 * 데이터가 일치하지 않으면 - login.jsp로 이동(심심하면 실패 alert 띄우기)  
 * */
@WebServlet("/loginAuth.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
       
    public LoginController() {
    	dao = MemberDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		int loginResult = dao.select(userid, password);
		System.out.println(loginResult);
		
		PrintWriter out = response.getWriter();
		if(loginResult == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			session.setMaxInactiveInterval(60);
			
			out.print("<script>alert('등록 성공! 로그인 해주세요.');</script>");
			out.print("<script>location.href='loginResult.jsp';</script>");
		} else {
			out.print("<script>alert('아이디, 비밀번호를 확인해주세요');</script>");
			out.print("<script>location.href='login.jsp';</script>");
		}
		
	}

}
