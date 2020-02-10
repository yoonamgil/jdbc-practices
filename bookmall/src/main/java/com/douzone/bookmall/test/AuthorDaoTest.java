package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.AuthorDao;
import com.douzone.bookmall.vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
	
		insertTest("스테파니메이어"); 
		insertTest("조정래"); 
		insertTest("김동인");
		insertTest("김난도"); 
		insertTest("천상병"); 
		insertTest("원수연"); 

	
		
		selectTest();
	}
	
	public static void insertTest(String name) {
		AuthorVo vo = new AuthorVo();
		vo.setName(name);
		
		
		new AuthorDao().insert(vo);
	}
	
	public static void deleteTest(String name) {
		AuthorVo vo= new AuthorVo();
		vo.setName(name);
		
		new AuthorDao().delete(vo);
	}
	public static void updateTest(String name,String rename) {
		AuthorVo vo= new AuthorVo();
		vo.setName(name);
		
		new AuthorDao().update(vo,rename);
	}
	
	public static void selectTest() {
		List<AuthorVo> list = new AuthorDao().findAll();
		
		for(AuthorVo vo : list) {
			System.out.println(vo);
		}
		
	}

}
