package com.easyapply.ApplicationDetailsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@ImportResource("application-context.xml")
@SpringBootApplication
@EnableTransactionManagement
public class ApplicationDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDetailsServiceApplication.class, args);
	}

}
