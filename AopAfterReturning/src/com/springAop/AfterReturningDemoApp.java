package com.springAop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springAop.dao.AccountDAO;
import com.springAop.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find the account
		List<Account> theAccounts = theAccountDao.findAccounts();
		
		//display the account
		System.out.println("\nIn afterReturningDemo\n");
		System.out.println(theAccounts);
		
		
		//close the context
		context.close();

	}

}
