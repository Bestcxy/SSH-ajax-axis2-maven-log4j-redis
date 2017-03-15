package com.bestcxx.mavenstu.mavenssh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@SuppressWarnings("serial")
@Table(name="BOOK")
@Entity(name="BOOK")
public class Book implements Serializable{
	private String bookName;
	
	@Id
	@Column(name="BOOKNAME",unique=true,nullable=false,length=20)
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@Override
	public String toString() {
		return "bookName="+bookName;
	}

	
}


