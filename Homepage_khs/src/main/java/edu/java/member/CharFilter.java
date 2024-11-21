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

@WebFilter("/CharFilter")
public class CharFilter extends HttpFilter implements Filter {
	
	@Override
	public void init() throws ServletException {}
       
    public CharFilter() {
    	System.out.println("CharFilter() 생성자");
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// UTF-8 인코딩
		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

}
