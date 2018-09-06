package com.pepcus.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder= {
		"id",
	    "uri",
	    "description"
})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="bookmarkBean")
public class BookmarkBean {
	
	@XmlElement(nillable=false, required=true)
	private Long id;
    
	@XmlElement(nillable=false, required=true)
    private String uri;

	@XmlElement(nillable=false, required=true)
    private String description;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
