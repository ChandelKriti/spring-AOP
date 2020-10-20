package com.springAop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springAop.dao.AccountDAO;
import com.springAop.dao.MembershipDAO;
import com.springAop.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		
		System.out.println("AroundDemoApp");
		
		System.out.println("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("My fortune is " + data);
		
		System.out.println("finished");
		
		//close the context
		context.close();

	}

}
