package com.qa.springvegetables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // lets you know this is a SBApplication
public class SpringVegetablesApplication {
//main method putting context into the bean bag, IOC container 
	public static void main(String[] args) {
		SpringApplication.run(SpringVegetablesApplication.class, args);
	}

}
