package com.springAop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springAop.Account;

@Component
public class AccountDAO {

	/*public void addAccount(Account account) {
		System.out.println(getClass() + "Doing my db work: Adding an Account");
	}*/
	
	public String name;
	public String serviceCode;
	
	//add a new method findAccounts
	public List<Account> findAccounts(boolean tripWire){
		
		if(tripWire) {
			throw new RuntimeException("the Exception caught");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("John","Silver");
		Account temp2 = new Account("Madhu","Platinum");
		Account temp3 = new Account("Luca","Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
		
	}
	
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
