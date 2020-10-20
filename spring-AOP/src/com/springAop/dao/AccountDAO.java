package com.springAop.dao;

import org.springframework.stereotype.Component;

import com.springAop.Account;

@Component
public class AccountDAO {

	/*public void addAccount(Account account) {
		System.out.println(getClass() + "Doing my db work: Adding an Account");
	}*/
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + "Doing my db work: Adding an Account");
	}
}
