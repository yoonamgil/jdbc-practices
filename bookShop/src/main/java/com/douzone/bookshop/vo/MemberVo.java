package com.douzone.bookshop.vo;

public class MemberVo {

	private Long no;
	private String name;
	private String PhoneNumber;
	private String mail; 
	private String password;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "이름 :" + name + ", 전화번호:" + PhoneNumber + ", 이메일:" + mail
				+ ", 비밀번호:" + password;
	} 
	
	
		
}
