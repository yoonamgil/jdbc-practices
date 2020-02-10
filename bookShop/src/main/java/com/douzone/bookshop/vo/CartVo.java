package com.douzone.bookshop.vo;

public class CartVo {

	private Long bookNo;
	private Long memberNo;
	private Long amount; 
	
	private String bookName;
	private Long price; 

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return  "수량:" + amount + ", 도서 제목:" + bookName
				+ ", 가격:" + price;
	}

	
	
	
	
	
}
