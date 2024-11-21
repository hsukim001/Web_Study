package edu.java.member;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/LoginSessionFilter")
public class LoginSessionFilter extends HttpFilter implements Filter {
	
	@Override
	public void init() throws ServletException {}
       
    public LoginSessionFilter() {
    	System.out.println("LoginSessionFilter()");
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) request;
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		HttpSession session = httpRequest.getSession();
		String userid = (String) session.getAttribute("userid");
		System.out.println("userid : " + userid);
		if(userid == null) {
			System.out.println("로그인 세션 없음");
			httpResponse.sendRedirect("/Homepage_khs/login.jsp");
			return;
		}
		chain.doFilter(request, response);
	}

}
