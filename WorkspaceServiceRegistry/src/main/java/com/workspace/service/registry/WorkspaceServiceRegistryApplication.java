package com.workspace.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class WorkspaceServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkspaceServiceRegistryApplication.class, args);
	}

}
