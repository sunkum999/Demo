package com.pepcus.bo;

import java.util.List;

import com.pepcus.beans.AccountBean;
import com.pepcus.entities.Account;

public interface AccountBO {
	
	public AccountBean create(AccountBean accountBean);
	
	public List<Account> findAllAccount();
	
	public Account findById(Long accountId);
	
	public List<Account> findByUsernameLike(String userNameLike);
	
	public void accCall();
	
	public String deleteAccount(Long accId);

}
