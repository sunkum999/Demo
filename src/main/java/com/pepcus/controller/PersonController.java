package com.pepcus.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepcus.beans.PersonBean;
import com.pepcus.bo.PersonBO;
import com.pepcus.entities.Person;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonBO personBO;
	
	@PostMapping
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public PersonBean createPerson(@RequestBody PersonBean personBean) {
		System.out.println("CameTrueInController");
		PersonBean personBean2=null;
		try {
			personBean2 = personBO.createPerson(personBean);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return personBean2;
	}
	
	@GetMapping
	public List<Person> findAllPerson() {
		return personBO.findAllPerson();
	}
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable Long accId) {
		return personBO.findById(accId);
	}
	
	@PutMapping("/{id}")
	public PersonBean updatePerson(@PathVariable Long accId, @RequestBody PersonBean personBean) {
		try {
			personBean = personBO.updatePerson(accId, personBean);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return personBean;
	}
	
	@DeleteMapping("/{id}")
	public String deletePerson(@PathVariable Long id) {
		String status = null;
		try {
			status = personBO.deletePerson(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

}
