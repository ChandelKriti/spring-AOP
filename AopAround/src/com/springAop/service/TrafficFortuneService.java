package com.springAop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;


@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		return "Excpect heavy traffic";
	}

	public String getFortune(boolean tripWire) {

      if(tripWire) {
    	  throw new RuntimeException("MAjor Accident ");
      }
		return getFortune();
	}
}
