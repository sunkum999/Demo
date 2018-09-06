package com.pepcus.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepcus.beans.AccountBean;
import com.pepcus.beans.PersonBean;
import com.pepcus.bo.PersonBO;
import com.pepcus.entities.Account;
import com.pepcus.entities.Person;
import com.pepcus.repository.PersonRepository;

@Service
public class PersonBOImpl implements PersonBO {
	
	@Autowired
	private PersonRepository personRepository;
	
	//@PersistenceContext
    //private EntityManager _emgr;

	@Override
	public PersonBean createPerson(PersonBean personBean) {
		System.out.println("CameTrueInBO");
		Person person = null;
		if(personBean != null) {
			person = new Person();
			BeanUtils.copyProperties(personBean, person);
			person.setCreatedOn(new Date());
			
			if(personBean.getAccountBeans() != null) {
				List<Account> accountList = new ArrayList<>();
				List<AccountBean> accountBeans = personBean.getAccountBeans();
				for(AccountBean accountBean : accountBeans) {//.forEach(accountBean ->{
					Account account = new Account();
					BeanUtils.copyProperties(accountBean, account);
					account.setPerson(person);
					accountList.add(account);
				}//);
				person.setAccounts(accountList);
			}
			person = personRepository.save(person);
		}
		return personBean;
	}
	
	@Override
	public List<Person> findAllPerson() {
		return personRepository.findAll();
	}
		
	@Override
	public Person findById(Long accId) {
		Object val = null;//_emgr.createQuery("SELECT date_trunc('month', t.createdOn) FROM PERSON P WHERE P.ID =:ID")
		//.setParameter("ID", accId)
		//.getSingleResult();
		System.out.println("Val :"+val);
		return null;
	}

	@Override
	public PersonBean updatePerson(Long accId, PersonBean personBean) {
		if(personBean != null && accId != null) {
			Person person = personRepository.findById(accId).get();
			if(person != null) {
				BeanUtils.copyProperties(personBean, person);
				person = personRepository.save(person);
				BeanUtils.copyProperties(person, personBean);
			}
		}
		return personBean;
	}

	@Override
	public String deletePerson(Long accId) {
		String status = "Failed";
		if(accId != null) {
			Person person = personRepository.findById(accId).get();
			if(person != null) {
				//person.setAccounts(null);
				/*List<Account> accounts = person.getAccounts();
				if(accounts != null) {
					System.out.println("Person have Acccounts data");
					for(Account account : accounts) {
						account.setPerson(null);
					}
				}*/
				personRepository.delete(person);
				status = "Success";
			}
		}
		return status;
	}

}
