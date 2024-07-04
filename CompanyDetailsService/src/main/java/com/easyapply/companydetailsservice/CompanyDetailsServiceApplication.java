package com.easyapply.companydetailsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ImportResource("application-context.xml")
public class CompanyDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyDetailsServiceApplication.class, args);
	}

}
