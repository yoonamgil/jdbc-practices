package com.douzone.bookshop.vo;

public class CategoryVo {
	private Long no; 
	private String category; 
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "분류 [ " + category + " ]";
	}
}
