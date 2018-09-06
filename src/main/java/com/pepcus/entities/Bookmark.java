package com.pepcus.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="book")
@Entity
@NamedQuery(name = "Bookmark.findByOk", query = "select b from Bookmark b where b.description = ?1")
public class Bookmark {

    @Id
    @GeneratedValue
    private Long id;
    
    private String uri;

    private String description;

	public Bookmark() { 
    	super();
    } // JPA only

    public Bookmark(final Account account, final String uri, final String description) {
        this.uri = uri;
        this.description = description;
    }

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







/*


if(accountId != null && !accountId.equalsIgnoreCase("")){
	query.append(" b.accountOwnershipId = '"+accountId+"'");
}
if ((startDate != null && !startDate.equalsIgnoreCase(""))
		&& (endDate != null && !endDate.equalsIgnoreCase(""))) {
	query.append(" and  b.asofDate >= (select  min(asofDate) from BalanceView where asofDate >= '"
			+ startDate
			+ "') and b.asofDate <= (select  max(asofDate) from BalanceView where asofDate <= '"
			+ endDate + "') order by asofDate");
}
*/














