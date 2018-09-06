package com.pepcus.bo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pepcus.beans.AccountBean;
import com.pepcus.bo.AccountBO;
import com.pepcus.entities.Account;
import com.pepcus.repository.AccountRepository;

@Service
public class AccountBOImpl implements AccountBO {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public AccountBean create(AccountBean accountBean) {
		Account account = null;
		if(accountBean != null) {
			account = new Account();
			BeanUtils.copyProperties(accountBean, account);
			accountRepository.save(account);
			BeanUtils.copyProperties(account, accountBean);
		}
		return accountBean;
	}
	
	
	@PersistenceContext
    private EntityManager _emgr;
	
	public List<Account> findAllAccount() {
		List<Account> findAll = accountRepository.findAll();
		return findAll;
	}
	
	public Account findById(Long accountId) {
		Account account = null;
		account =  accountRepository.findById(accountId).get();
		return account;
	}
	
	@Transactional(readOnly=true)
	public List<Account> findByUsernameLike(String userNameLike) {
		List<Account> list = accountRepository.findByUsernameLike(userNameLike);
		System.out.println(userNameLike+":Size : "+list.size());
		return list;
	}
	
	public List<Account> findByUsernameAndPassword(String userName, String password) {
		List<Account> list = accountRepository.findByUsernameAndPassword(userName, password);
		System.out.println(userName+":Size : "+list.size());
		return list;
	}
	
	@Override
	public void accCall() {
		System.out.println("called");
	}
	
	public String mapFinal(String str) {
		return "val";
	}
	
	public String deleteAccount(Long accId) {
		String status = "Failed";
		Account account = accountRepository.findById(accId).get();
		if(account != null) {
			accountRepository.delete(account);
			status = "Success";
		}
		return status;
	}

	
}
