package kr.ac.kopo.model;

import java.util.Date;

public class Book {
	private int bookId;
	private String subject;
	private String contents;
	private Date regDate;
	private int order;
	private int orderOriginal;
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getOrderOriginal() {
		return orderOriginal;
	}
	public void setOrderOriginal(int orderOriginal) {
		this.orderOriginal = orderOriginal;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
