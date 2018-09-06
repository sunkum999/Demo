package com.pepcus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pepcus.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
