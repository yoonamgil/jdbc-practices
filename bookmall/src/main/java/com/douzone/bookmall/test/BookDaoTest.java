package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {

		insertTest("트와일라잇","스테파니메이어");

//		insertTest("뉴문","스테파니메이어");
//		insertTest("이클립스","스테파니메이어");
//		insertTest("브레이킹던","스테파니메이어");
//		insertTest("아리랑","조정래");
//		insertTest("젊은그들","김동인");
//		insertTest("아프니까 청춘이다","김난도");
//		insertTest("귀천","천상병");
//		insertTest("태백산맥","조정래");
//		insertTest("풀하우스","원수연");
		
//		updateTest("트와일라잇");
//		deleteTest("풀하우스");
//		updateTest("풀하우스","바뀌니?");
		selectTest();
	}
	
	public static void insertTest(String title,String author) {
		BookVo vo = new BookVo();
		vo.setTitle(title);

		new BookDao().insert(vo,author);
	}
	
	public static void deleteTest(String name) {
		BookVo vo= new BookVo();
		vo.setTitle(name);
		
		new BookDao().delete(vo);
	}
	public static void updateTest(String name,String rename) {
		BookVo vo= new BookVo();
		vo.setTitle(name);
		
		new BookDao().update(vo,rename);
	}
	public static void updateTest(String title) {
		BookVo vo= new BookVo();
		vo.setTitle(title);
		
		new BookDao().update(vo);
	}
	
	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		
		for(BookVo vo : list) {
			System.out.println(vo);
		}
		
	}

}
