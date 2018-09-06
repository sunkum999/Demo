package com.pepcus.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pepcus.entities.Account;
import com.pepcus.entities.Bookmark;

//public interface AccountRepository extends JpaRepository<Account, Long> {
public interface AccountRepository extends CrudRepository<Account, Long>, JpaSpecificationExecutor<Bookmark> {
	
	public List<Account> findAll();
    
	public Optional<Account> findByUsername(String username);

	public List<Account> findByUsernameLike(String userNameLike);
	
	public List<Account> findByUsernameAndPassword(String userName, String password);
}
