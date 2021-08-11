/*
 * UC1 : Using GreetingController return JSON for different HTTP Methods. Test using curl
 */
package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingAppApplication.class, args);
		System.out.println("Welcome To Greeting App");
	}
}
