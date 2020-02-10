package com.douzone.bookshop.dao.test;

import java.util.List;


import com.douzone.bookshop.dao.OrdersDao;
import com.douzone.bookshop.vo.OrderBookVo;
import com.douzone.bookshop.vo.OrdersVo;

public class OrderDaoTest {

public static void main(String[] args) {
		
		insertTest(30000L,"경기도 파주시 ","20200129-00012",1L); 
	

		selectTest();
	}

	public static void insertTest(Long price,String address,String orderNo,Long memberNo) {
		OrdersVo vo = new OrdersVo();
		vo.setPrice(price);
		vo.setAddress(address);
		vo.setOrderNo(orderNo);
		vo.setMemberNo(memberNo);
		
		
		new OrdersDao().insert(vo);
	}
	public static void insertTest(Long bookNo,Long orderNo,Long amount) {
		OrderBookVo vo = new OrderBookVo();
		vo.setBookNo(bookNo);
		vo.setOrderNo(orderNo);
		vo.setAmount(amount);
		
		
		new OrdersDao().insert(vo);
	}
	public static void selectTest() {
		List<OrdersVo> list = new OrdersDao().findAll();	
		for(OrdersVo vo : list) {
			System.out.println(vo);
			
		}	
		
	}
}
