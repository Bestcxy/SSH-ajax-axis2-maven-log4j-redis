package com.bestcxx.mavenstu.mavenssh.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Table(name="LOGGER")
@Entity(name="LOGGER")
public class LoggerModel implements Serializable{
	private long eventId;//EVENT_ID  日志id
	private Date eventDate;//EVENT_DATE -注意这里必须使用sqlDate
	private String level;//LEVEL       日志的级别
	private String logger;//LOGGER     日志内容
	private String message;//MESSAGE   其他信息
	private String throwable;//THROWABLE   异常抛出
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//主键自增-mysql
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Column(name="EVENT_ID",unique=true,nullable=false)
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	@Column(name="EVENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	@Column(name="LEVEL",nullable=false,length=10)
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Column(name="LOGGER",nullable=true,length=1000)
	public String getLogger() {
		return logger;
	}
	public void setLogger(String logger) {
		this.logger = logger;
	}
	@Column(name="MESSAGE",nullable=true,length=1000)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Column(name="THROWABLE",nullable=true,length=1000)
	public String getThrowable() {
		return throwable;
	}
	public void setThrowable(String throwable) {
		this.throwable = throwable;
	}
	
	
	
	
}
