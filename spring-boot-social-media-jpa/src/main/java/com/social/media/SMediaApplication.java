package com.social.media;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SMediaApplication {	
	
    private static ApplicationContext applicationContext;


	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SMediaApplication.class, args);
		//displayAllBeans();
	}
	
	 public static void displayAllBeans() {
	        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
	        System.out.println("######################### #############################");
	        for(String beanName : allBeanNames) {
	            System.out.println(beanName);
	        }
	    }
	
	}
