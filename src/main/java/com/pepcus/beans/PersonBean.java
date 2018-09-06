package com.pepcus.beans;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"id",
		"name",
		"createdOn",
		"createdBy",
		"accountBeans",
		})
@XmlRootElement(name="personBean")
public class PersonBean {
	
	@XmlElement(nillable=false, required=true)
	private Long id;
	 
	@XmlElement(nillable=false, required=true)
	private String name;
	 
	@XmlElement(nillable=false, required=true)
	private Date createdOn;
	 
	@XmlElement(nillable=false, required=true)
	private int createdBy;
	
	@XmlElement(nillable=false, required=true)
	private List<AccountBean> accountBeans;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public List<AccountBean> getAccountBeans() {
		return accountBeans;
	}

	public void setAccountBeans(List<AccountBean> accountBeans) {
		this.accountBeans = accountBeans;
	}

}
