package com.springAop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + "Doing my work: Adding membership Account");
	}
	
	/* public boolean addAccount() {
		System.out.println(getClass() + "Doing my work: Adding membership Account");
		return true;
	}*/
}
