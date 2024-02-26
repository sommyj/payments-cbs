package com.cbs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PaymentsApplication {
	
	private final Map<String, String> users = new HashMap<>();


	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);
	}
	
	public PaymentsApplication() {
        // Mocked users for basic authentication
        users.put("admin", new BCryptPasswordEncoder().encode("password"));
    }

}
