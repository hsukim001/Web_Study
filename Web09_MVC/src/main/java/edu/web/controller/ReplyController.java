package edu.web.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.web.domain.ReplyVO;
import edu.web.persistence.ReplyDAO;
import edu.web.persistence.ReplyDAOImple;

// spring의 rest api을 최대한 mvc 패턴으로 구현
@WebServlet("/replies/*") // rest api와 최대한 비슷하게 만들기위해 url을 설정함
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyDAO dao;
       
    public ReplyController() {
    	dao = ReplyDAOImple.getInstance();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		
		if(requestURI.contains("add")) {
			System.out.println("add 호출 확인");
			replyAdd(request, response);
		} else if(requestURI.contains("all")){
			System.out.println("all 호출 확인");
			replyList(request, response);
		} else if(requestURI.contains("update")) {
			System.out.println("update 호출 확인");
			replyUpdate(request,response);
		} else if(requestURI.contains("delete")) {
			System.out.println("delete 호출 확인");
			replyDelete(request, response);
		}
	} // end service()

	// ajax 통신으로 댓글 JSON 데이터를 전송받아서
	// REPLY 테이블에 저장하고
	// 저장에 성공하면 success 메시지를 다시 돌려줌
	private void replyAdd(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String obj = request.getParameter("obj");
		System.out.println(obj);
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(obj);
			
			int boardId = Integer.parseInt((String) jsonObject.get("boardId"));
			String memberId = (String) jsonObject.get("memberId");
			String replyContent = (String) jsonObject.get("replyContent");
			
			ReplyVO vo = new ReplyVO(0, boardId, memberId, replyContent, null);
			System.out.println(vo);
			
			int result = dao.insert(vo);
			if(result == 1) {
				response.getWriter().append("success");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	// 전송된 게시글 전호에 맞는 댓글 리스트를 DB에서 조회
	// 조회된 댓글 리스트를 JSON 형태로 변경하여 클라이언트에 전송
	private void replyList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("replyList()");
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		List<ReplyVO> list = dao.select(boardId);
		
		JSONArray jsonArray = new JSONArray();
		for(int i = 0; i < list.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			ReplyVO vo = list.get(i);
			
			jsonObject.put("replyId", vo.getReplyId());
			jsonObject.put("boardId", vo.getBoardId());
			jsonObject.put("memberId", vo.getMemberId());
			jsonObject.put("replyContent", vo.getReplyContent());
			jsonObject.put("replyDateCreated", vo.getReplyDateCreated().toString());
			jsonArray.add(jsonObject);
		}
		
		System.out.println(jsonArray.toString());
		response.getWriter().append(jsonArray.toJSONString());
		// toString() or toJSONString() 둘다 가능
	}

	private void replyUpdate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("replyUpdate()");
		String obj = request.getParameter("obj");
		System.out.println(obj);
		
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(obj);
			
			int replyId = Integer.parseInt((String) jsonObject.get("replyId"));
			String replyContent = (String) jsonObject.get("replyContent");
			
			ReplyVO vo = new ReplyVO(replyId, 0, null, replyContent, null);
			System.out.println(vo);
			int result = dao.update(vo);
			
			if(result == 1) {
				response.getWriter().append("success");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void replyDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("replyDelete()");
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		System.out.println(replyId);
		
		int result = dao.delete(replyId);
		
		if(result == 1) {
			response.getWriter().append("success");
		}
		
	}

}
