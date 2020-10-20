package com.springAop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springAop.dao.AccountDAO;
import com.springAop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);
		
		//get the bean from spring container
		MembershipDAO theMembershipDao = context.getBean("membershipDAO", MembershipDAO.class);
		
		/*//call the business method
		theAccountDao.addAccount(); */
		
		//call the membership business method
		theMembershipDao.addAccount();
		
		// match with param type
		Account account  = new Account();
		account.setName("Madhu");
		account.setLevel("Platinum");
		theAccountDao.addAccount(account,true);
		
		
		//call accountDao getter/setter
		theAccountDao.setName("silly");
		theAccountDao.setServiceCode("silver");
		
		String name = theAccountDao.getName();
		String code = theAccountDao.getServiceCode();
		
		
		//close the context
		context.close();

	}

}
