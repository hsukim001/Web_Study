package edu.web.homework;

import java.util.Date;

// 게시글 번호, 게시글 제목, 사용자 아이디, 게시글 등록일 필드 선언
// 생성자, 매개변수 생성자, getter/setter, toString 생성
public class BoardVO {
	private int boardNum;
	private String boardTitle;
	private String userId;
	private Date boardRegDate;

	public BoardVO() {
	}

	public BoardVO(int boardNum, String boardTitle, String userId, Date boardRegDate) {
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.userId = userId;
		this.boardRegDate = boardRegDate;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getBoardRegDate() {
		return boardRegDate;
	}

	public void setBoardRegDate(Date boardRegDate) {
		this.boardRegDate = boardRegDate;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", userId=" + userId + ", boardRegDate=" + boardRegDate
				+ "]";
	}

}
