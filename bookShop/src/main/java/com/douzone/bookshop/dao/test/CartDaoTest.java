package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CartDao;
import com.douzone.bookshop.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		
		insertTest(2L,2L,2L); 
		insertTest(3L,3L,4L); 

		selectTest();
	}

	public static void insertTest(Long bookNo,Long memberNo,Long amount) {
		CartVo vo = new CartVo();
		vo.setBookNo(bookNo);
		vo.setMemberNo(memberNo);
		vo.setAmount(amount);
		
		
		new CartDao().insert(vo);
	}
	
	public static void selectTest() {
		List<CartVo> list = new CartDao().findAll();
		
		for(CartVo vo : list) {
			System.out.println(vo);
		}
		
	}
}
