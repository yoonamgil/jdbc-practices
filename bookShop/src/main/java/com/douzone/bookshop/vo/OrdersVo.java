package com.douzone.bookshop.vo;

public class OrdersVo {
	
	 private Long no;
	 private Long price; 
	 private String address;
	 private String orderNo;
	 private Long memberNo;
	 private String memberName;	
	 private String memberMail;
	 public String getMemberMail() {
		return memberMail;
	}
	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}


	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return "주문 번호:" + orderNo +",메일:"+memberMail+", 주문자:" + memberName+
				", 결제금액:" + price + ", 배송지:" + address;
	}
	
	 
	

 
 
	
}
