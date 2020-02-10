package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.MemberDao;
import com.douzone.bookshop.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		
		insertTest("유남길","010-4108-5713","skaska5@naver.com","유남길!"); 
		insertTest("길남유","010-8539-3234","dbskarlf@hanmail.net","비번"); 
//		insertTest("낭기리","010-4444-2222","skarlf555@naver.com","qlqjsgkdlgkdl"); 

	
		
		selectTest();
	}

	public static void insertTest(String name,String phoneNumber,String mail, String password) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setPhoneNumber(phoneNumber);
		vo.setMail(mail);
		vo.setPassword(password);
		
		
		new MemberDao().insert(vo);
	}
	
	public static void selectTest() {
		List<MemberVo> list = new MemberDao().findAll();
		
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
		
	}

}
