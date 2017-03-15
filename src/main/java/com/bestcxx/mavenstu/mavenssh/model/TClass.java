package com.bestcxx.mavenstu.mavenssh.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Table(name="TCLASS")
@Entity(name="TCLASS")
public class TClass implements Serializable{
	private String className;
	private Date insertDateTime;
	@Id
	@Column(name="CLASSNAME",unique=true,nullable=false,length=20)
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Column(name="INSERTDATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getInsertDateTime() {
		return insertDateTime;
	}
	public void setInsertDateTime(Date insertDateTime) {
		this.insertDateTime = insertDateTime;
	}
	
	

}
