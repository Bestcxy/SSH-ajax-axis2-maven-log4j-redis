package com.bestcxx.mavenstu.mavenssh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@SuppressWarnings("serial")
@Table(name="PERSON")
@Entity(name="PERSON")
public class Person implements Serializable{
	private String userName;
	private String passWord;
	@Id
	@Column(name="USERNAME",unique=true,nullable=false,length=20)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="PASSWORD",length=20)
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "userName="+userName+
				";passWord="+passWord;
	}
	
	
	

}
