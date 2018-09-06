package com.pepcus.bo;

import java.util.List;

import com.pepcus.beans.PersonBean;
import com.pepcus.entities.Person;

public interface PersonBO {
	
	public List<Person> findAllPerson();
	
	public PersonBean createPerson(PersonBean personBean);

	public Person findById(Long accId);
	
	public PersonBean updatePerson(Long accId, PersonBean personBean);
	
	public String deletePerson(Long accId);

}
