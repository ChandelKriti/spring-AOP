package com.springAop.aspect;

import org.aspectj.lang.JoinPoint;
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
