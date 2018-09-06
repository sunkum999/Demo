package com.pepcus.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder= {
		"id",
	    "uri",
	    "description",
	    "personBean"
})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="bookmarkBean")
public class AccountBean {

	@XmlElement(nillable=false, required=true)
	private Long id;

	@XmlElement(nillable=false, required=true)
    private String username;

	@XmlElement(nillable=false, required=true)
    private String password;

	@XmlElement(nillable=false, required=true)
	private PersonBean personBean;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonBean getPersonBean() {
		return personBean;
	}

	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}

}
