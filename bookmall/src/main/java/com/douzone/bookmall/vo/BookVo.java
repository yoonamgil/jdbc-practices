package com.douzone.bookmall.vo;

public class BookVo {
	private Long no;
	private String title; 
	private String state;
	private Long authorNO;
	
	private String authorName;

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", state=" + state + ", authorNO=" + authorNO + ", authorName="
				+ authorName + "]";
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getAuthorNO() {
		return authorNO;
	}

	public void setAuthorNO(Long authorNO) {
		this.authorNO = authorNO;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
}
