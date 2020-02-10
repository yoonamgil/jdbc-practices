package com.douzone.bookshop.dao.test;

import java.util.List;


import com.douzone.bookshop.dao.CategoryDao;
import com.douzone.bookshop.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		
		insertTest("it"); 
		insertTest("교양"); 
		insertTest("예술"); 

	
		
		selectTest();
	}

	public static void insertTest(String name) {
		CategoryVo vo = new CategoryVo();
		vo.setCategory(name);
		
		
		new CategoryDao().insert(vo);
	}
	
	public static void selectTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
		
	}
}
