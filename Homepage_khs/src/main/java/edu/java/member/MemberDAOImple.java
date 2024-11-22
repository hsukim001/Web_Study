package edu.java.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class MemberDAOImple implements MemberDAO, DBConnection{
	private static MemberDAOImple instance = null;
	
	private MemberDAOImple() {}
	
	public static MemberDAOImple getInstance() {
		if(instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}

	// 회원 정보 조회(parameter : userid)
	@Override
	public MemberVO selectUser(String userid) {
		MemberVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결");
			
			pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String password = rs.getString(2);
				String email = rs.getString(3);
				String emailAgree = rs.getString(4);
				String interest = rs.getString(5);
				String phone = rs.getString(6);
				String introduce = rs.getString(7);
				
				vo = new MemberVO(id, password, email, emailAgree, phone, introduce);
				
				vo.setInterestJoin(interest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return vo;
	}

	// 회원 등록(parameter : MemberVO)
	@Override
	public int insertMember(MemberVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결");
			
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());
			
			result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println(result + "행 등록");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	// 회원 정보 수정(parameter : MemberVO)
	@Override
	public int updateMember(MemberVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결");
			
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getEmailAgree());
			pstmt.setString(4, vo.getInterestJoin());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getIntroduce());
			pstmt.setString(7, vo.getUserid());
			
			result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println(result + "행 수정");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	// 회원 삭제(parameter : userid)
	@Override
	public int deleteMember(String userid) {
		return 0;
	}
	
}
