package com.springAop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	//here we add all our related advices for logging
	
	//start with @BeforeAdvice
	
	/* @Before("execution(public void com.springAop.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting @Before Advice on addAccount()");
	} */
	
/*	//add wildcards
	
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting @Before Advice on addAccount()");
	}*/
	
	/* //match with return type
	
		@Before("execution(void add*())")
		public void beforeAddAccountAdvice() {
			System.out.println("\nExecuting @Before Advice on addAccount()");
		}*/
		
	/*	//match with any return type (wildcard)
		
			@Before("execution(* add*())")
			public void beforeAddAccountAdvice() {
				System.out.println("\nExecuting @Before Advice on addAccount()");
			}*/
	
 /*	//match with param type
	 @Before("execution(public void add*(com.springAop.Account, ..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\nExecuting @Before Advice on addAccount()");
	} */
	 
	//match with package type
		 @Before("execution(*com.springAop.dao.*.*(..))")
		public void beforeAddAccountAdvice() {
			System.out.println("\nExecuting @Before Advice on addAccount()");
		} 
}
