package edu.java.member;

public interface MemberDAO {
	
	// 회원 정보 상세 조회
	MemberVO selectUser(String userid);
	
	// 회원 등록
	int insertMember(MemberVO vo);
	
	// 회원 정보 수정
	int updateMember(MemberVO vo);
	
	// 회원 삭제
	int deleteMember(String userid);
}
