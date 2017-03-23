package com.bestcxx.mavenstu.mavenssh.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="FILETXT")
@Entity(name="FILETXT")
public class FileTxtModel implements Serializable {

	private static final long serialVersionUID = 4987430838567875090L;
	
	private long id;//主键，自增
	private String identifier;//编号
	private BigDecimal price;//价格
	private Date dateTime;//时间
	private String name;//名称
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//主键自增-mysql
	@Column(name="ID",unique=true,nullable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="IDENTIFIER",nullable=true,length=50)
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	@Column(name="PRICE",nullable=true,precision = 10, scale = 2)//整数位10，小数位2
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Column(name="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	@Column(name="NAME",nullable=true,length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
