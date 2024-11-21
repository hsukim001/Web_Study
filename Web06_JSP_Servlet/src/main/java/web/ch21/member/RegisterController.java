package web.ch21.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;
       
    public RegisterController() {
    	dao = MemberDAOImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sendRedirect() : 특정 경로로 이동
		// - request는 소멸되기 때문에 데이터를 전송할 수 없음
		
		response.sendRedirect("/Web06_JSP_Servlet/ch21/register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청으로부터 파라미터 추출
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String emailAgree = request.getParameter("emailAgree");
		String[] interest = request.getParameterValues("interest");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		
		MemberVO member = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
		System.out.println(member);
		
		int result = dao.insert(member);
		if(result == 1) {
			System.out.println("성공");
		}
	}

}
