package com.douzone.bookmall.main;

import java.util.List;
import java.util.Scanner;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.test.BookDaoTest;
import com.douzone.bookmall.vo.BookVo;

public class BookMallApp {

	public static void main(String[] args) {
		
		displayBookInfo();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 이름을 입력하세요:");
		String title = scanner.nextLine();
		scanner.close();
		
		rent(title);
		displayBookInfo();
	}

	public static void rent(String title) {
		new BookDaoTest();
		BookDaoTest.updateTest(title);
	}
	private static void displayBookInfo() {

		System.out.println("***********도서정보 출력*************");
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println("[ "+vo.getNo()+"] 책 제목:"+vo.getTitle()+ 
		                     ", 작가: "+ vo.getAuthorName()+
					", 대여유무:" + vo.getState());
			
		}
		
	}
}
