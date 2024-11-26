package edu.web.member;

public interface MemberDAO {
	int insert(MemberVO vo);

	int select(String userid, String password);

	MemberVO select(String userid);

	int update(MemberVO vo);

	int delete(String userid);
}
