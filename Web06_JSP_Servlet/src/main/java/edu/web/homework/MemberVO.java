package edu.web.homework;

import java.io.Serializable;
import java.util.Arrays;

public class MemberVO implements Serializable{
	// 주의) useBean을 위한 VO를 생성할 경우, parameter name과 변수명이 같아야 한다.
	
	private String userid;
	private String password;
	private String email;
	private String emailAgree;
	private String[] interest;
	private String phone;
	private String introduce;
	
	public MemberVO() {}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailAgree() {
		return emailAgree;
	}

	public void setEmailAgree(String emailAgree) {
		this.emailAgree = emailAgree;
	}

	public String[] getInterest() {
		return interest;
	}
	
	public String getInterestJoin() {
		return (interest == null) ? "없음" : String.join(",", interest);
	}

	public void setInterest(String[] interest) {
		this.interest = interest;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
}
