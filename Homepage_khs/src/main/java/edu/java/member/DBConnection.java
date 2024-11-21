package edu.java.member;

public interface DBConnection {
	// DB 접속에 필요한 상수 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "TEST_MEMBER";
	public static final String COL_USERID = "USERID";
	public static final String COL_PASSWORD = "PASSWORD";
	public static final String COL_EMAIL = "EMAIL";
	public static final String COL_EMAIL_AGREE = "EMAIL_AGREE";
	public static final String COL_INTEREST = "INTEREST";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_INTRODUCE = "INTRODUCE";

	// 회원 정보 조회(userid) 쿼리
	public static final String SQL_SELECT_BY_USERID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_USERID + " = ?";
	
	// 회원 등록 쿼리
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	// 회원 정보 수정
	public static final String SQL_UPDATE = "UPDATE " + TABLE_NAME + " SET " + 
			COL_PASSWORD + " = ?, " + COL_EMAIL + " = ?, " + COL_EMAIL_AGREE + " = ?, " + COL_INTEREST + " = ?, " + COL_PHONE + " = ?, " + COL_INTRODUCE + 
			" = ? WHERE " + COL_USERID + " = ?";
	
	// 회원 정보 삭제
	public static final String SQL_DELETE = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_USERID + " = ?";
}
