package com.springAop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springAop.dao.AccountDAO;
import com.springAop.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the account
		List<Account> theAccounts = null;
		
		try {
			boolean tripWire = true;
		theAccounts = theAccountDao.findAccounts(tripWire);
		}
		catch(Exception e) {
			System.out.println("\nMain Account...caught Exception "+ e);
		}
		
		//display the account
		System.out.println("\nIn afterThrowingDemo\n");
		System.out.println(theAccounts);
		
		
		//close the context
		context.close();

	}

}
