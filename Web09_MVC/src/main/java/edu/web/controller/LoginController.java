package edu.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// spring security 구조를 mvc패턴으로 최대한 구현
@WebServlet("*.go")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
    	
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	String requestMethod = request.getMethod();
    	System.out.println("호출 경로 : " + requestURI);
    	System.out.println("호출 메소드 : " + requestMethod);
    	
    	if(request.getRequestURI().contains("login")) {
    		System.out.println("login 호출");
    		if(requestMethod.equals("GET")) {
    			loginGET(request, response);
    		} else if(requestMethod.equals("POST")) {
    			loginPOST(request, response);
    		}
    	} else if(requestURI.contains("logout")) {
    		System.out.println("logout 호출");
    		logout(request, response);
    	}
    }

	private void loginGET(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("loginGET() 호출");
		String targetURL = request.getParameter("targetURL");
		request.setAttribute("targetURL", targetURL);
		request
			.getRequestDispatcher("/WEB-INF/login/login.jsp")
			.forward(request, response);
	}

	private void loginPOST(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("loginPOST() 호출");
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		String targetURL = request.getParameter("targetURL");
		
		System.out.println("memberId : " + memberId);
		System.out.println("password : " + password);
		System.out.println("targetURL : " + targetURL);
		
		// * loginPOST를 수행하는 상황
		// - index.jsp에서 login 버튼 클릭 -> 로그인 페이지 -> 로그인 성공 -> index.jsp 이동
		// - 글 작성 버튼(register.do) 클릭 -> 로그인 페이지 -> 로그인 성공 -> register.do 이동
		if(memberId.equals("test") && password.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberId);
			session.setMaxInactiveInterval(600);
			
			if(!targetURL.equals("") && targetURL != null) {
				response.sendRedirect(targetURL);
			} else {
				response.sendRedirect("index.jsp");				
			}
			
		} else {
			response.sendRedirect("login.go");
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("logout() 호출");
		// HttpSession session = request.getSession();
		if(request.getSession().getAttribute("memberId") != null) {
			request.getSession().removeAttribute("memberId");
			response.sendRedirect("index.jsp");
		}
	}

}
