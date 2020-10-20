package com.springAop.dao;

import org.springframework.stereotype.Component;

import com.springAop.Account;

@Component
public class AccountDAO {

	/*public void addAccount(Account account) {
		System.out.println(getClass() + "Doing my db work: Adding an Account");
	}*/
	
	public String name;
	public String serviceCode;
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + "Doing my db work: Adding an Account");
	}

	public String getName() {
		System.out.println(getClass() + "getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + "setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + "getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + "setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	
}
