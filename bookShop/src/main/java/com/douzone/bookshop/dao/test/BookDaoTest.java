package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.BookDao;
import com.douzone.bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//			
//			insertTest("이것이자바다",30000L,"it"); 
//			insertTest("글쓰기와 말하기",40000L,"교양"); 
//			insertTest("과학은 예술이다",120000L,"예술"); 
			
		
	
		
			selectTest();
		}
	
		public static void insertTest(String title,Long price,String category) {
			BookVo vo = new BookVo();
			vo.setTitle(title);
			vo.setPrice(price);
			vo.setCategoryName(category);
			
			new BookDao().insert(vo);
		}
		
		public static void selectTest() {
			List<BookVo> list = new BookDao().findAll();
			
			for(BookVo vo : list) {
				System.out.println(vo);
			}
			
		}

}
