package com.douzone.bookshop.dao.test;

public class Main {

	public static void main(String[] args) {
		System.out.println("***********************회원 정보*************************");
		MemberDaoTest.insertTest("유남길","010-4108-5713","skaska5@naver.com","1234"); 
		MemberDaoTest.insertTest("김철수","010-8539-3234","dbskarlf@hanmail.net","123456"); 
		
		MemberDaoTest.selectTest();
		
		CategoryDaoTest.insertTest("it"); 
		CategoryDaoTest.insertTest("교양"); 
		CategoryDaoTest.insertTest("예술"); 
		System.out.println("***********************분류 정보*************************");
		CategoryDaoTest.selectTest();
		
		BookDaoTest.insertTest("이것이자바다",30000L,"it"); 
		BookDaoTest.insertTest("글쓰기와 말하기",40000L,"교양"); 
		BookDaoTest.insertTest("과학은 예술이다",50000L,"예술"); 
		System.out.println("***********************서적 정보*************************");
		BookDaoTest.selectTest();
		
		CartDaoTest.insertTest(1L,1L,2L); 
		CartDaoTest.insertTest(2L,2L,4L); 
		System.out.println("***********************카트 정보*************************");
		CartDaoTest.selectTest();
		
		System.out.println("***********************주문 정보*************************");
		
		OrderDaoTest.insertTest(110000L,"경기도 파주시 조리읍 내산길 ","20200129-00001",1L); 
		OrderDaoTest.insertTest(1L,1L,2L); 
		OrderDaoTest.insertTest(3L,1L,1L); 
		
		OrderDaoTest.selectTest();
	}

}
