package web.ch14.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 문자열로 url 정보를 입력
@WebServlet("/main") // annotation 방식
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLASSNAME = MainServlet.class.getName(); // 클래스 위치와 이름 참조
       
    public MainServlet() {
    	System.out.println(CLASSNAME + " MainServlet");
    }
    
    // init() : 해당 Servlet이 실행될 때 한번만 호출.
    @Override
    public void init() throws ServletException {
    	System.out.println(CLASSNAME + " init()");
    }
    
    // service() : HTTP 요청이 발생될 때마다 호출.
    // doGet()과 doPost()로 대체 가능 => service()는 doGet(),doPost()을 포함하는 구조이다.
    // throws는 try/catch 예외처리를 메서드화 시켜서 사용한다.
	/*
	 * @Override protected void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { System.out.println(CLASSNAME +
	 * " service()"); }
	 */
    
    // doGet() : HTTP GET 요청이 발생될 때마다 호출
    // 웹 브라우저에서 URL을 입력하여 웹페이지를 불러올때 GET 방식을 사용하여 불러온다.
    // 클라이언트에서 서버로 데이터를 줄때 사용한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " doGet()");
	}

	// doPost() : HTTP POST 요청이 발생될 때마다 호출
	// 서버에서 클라이언트로 데이터를 전송할때 사용한다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(CLASSNAME + " doPost()");
	}
	
	// destroy() : 서버가 종료될 때 호출.
	@Override
	public void destroy() {
		System.out.println(CLASSNAME + " destroy()");
	}

}
