package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO : memberUpdate.jsp에서 전송된 데이터로 DB 회원 정보 수정
//         회원 정보 수정에 성공하면 memberResult.jsp에 MemberVO 데이터 전송하여 출력
@WebServlet("/update.do")
public class UpdateController extends HttpServlet {
   private static final long serialVersionUID = 1L;
    private static MemberDAO dao;   

    public UpdateController() {
       dao = MemberDAOImple.getInstance();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String userid = request.getParameter("userid");
      String password = request.getParameter("password");
      String email = request.getParameter("email");
      String emailAgree = request.getParameter("emailAgree");
      String[] interest = request.getParameterValues("interest");
      String phone = request.getParameter("phone");
      String introduce = request.getParameter("introduce");
      
      MemberVO vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
      System.out.println(vo);
      
      int result = dao.update(vo);
      System.out.println(result);
      
      if(result == 1) {
         RequestDispatcher dispatcher = 
               request.getRequestDispatcher("memberResult.jsp");
         request.setAttribute("vo", vo);
         dispatcher.forward(request, response);
      }
      
   }

}

