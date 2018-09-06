package com.pepcus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepcus.beans.AccountBean;
import com.pepcus.bo.AccountBO;
import com.pepcus.entities.Account;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountBO accountBO;
	
	@PostMapping
	public AccountBean createAccount(@RequestBody AccountBean accountBean) {
		return accountBO.create(accountBean);
	}
	
	@GetMapping
	public List<Account> findAllAccount() {
		return accountBO.findAllAccount();
	}
	
	@GetMapping("/{accId}")
	public Account findById(@PathVariable Long accId) {
		return accountBO.findById(accId);
	}
	
	@GetMapping("/{usernameLike}")
	public List<Account> findByUsernameLike(@PathVariable String usernameLike) {
		return accountBO.findByUsernameLike(usernameLike);
	}
	
	@DeleteMapping("/{accId}")
	public String deleteAccount(@PathVariable Long accId) {
		return accountBO.deleteAccount(accId);
	}
	
}
