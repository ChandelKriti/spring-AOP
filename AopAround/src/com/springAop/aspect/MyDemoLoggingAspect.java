package com.springAop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springAop.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	@Around("execution(* com.springAop.service.*.getFortune(..))")
	public Object aroundGetFortune(
		ProceedingJoinPoint theProceedingJoinPoint ) throws Throwable{
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n Executing @Around advice on method " + method);
		
		long begin = System.currentTimeMillis(); 
		
		//Object result = theProceedingJoinPoint.proceed();
		
		Object result =null;
		 
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			
			e.printStackTrace();
			result = "No worry";
		}
		
		long end = System.currentTimeMillis(); 
		
		long duration = end - begin;
		System.out.println("\n Duration " + duration/1000.0 + "sec");
		
		return result;
		
	}
	
	
	
	@After("execution(* com.springAop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		
		//printout which method we are advising on
				String method = theJoinPoint.getSignature().toShortString();
				System.out.println("\n Executing @After (finally) advice on method " + method);
	}
		
	
	@AfterThrowing(
			pointcut="execution(* com.springAop.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		
		//printout which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n Executing @AfterThrowing advice on method " + method);
		
		//log out the exception
		System.out.println("\n the exception is  " + theExc);
	}
		
	
	//add a new advice for afterReturning on the findAccounts method
	
	@AfterReturning(
			pointcut="execution(* com.springAop.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account>result) {
		
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n Executing @AfterReturning advice on method " + method);
		
		//print out the results of the method call
		System.out.println("\n Results" + result);
		
		//post process the data
		
		//convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n Results" + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through the accounts
		for(Account tempAccount : result) {
		
		//get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
		
		//update name on account
			tempAccount.setName(theUpperName);
		}
		
	}

	@Before("com.springAop.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {		
		System.out.println("\n Executing @Before advice on method");		
		
		MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method " + methodSign);
		
		Object args[] =theJoinPoint.getArgs();
		
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account name :" + theAccount.getName());
				System.out.println("Account level :" + theAccount.getLevel());
				
			}
		}
	}
	

	
}
