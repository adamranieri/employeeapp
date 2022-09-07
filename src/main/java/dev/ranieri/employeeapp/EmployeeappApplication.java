package dev.ranieri.employeeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "dev.ranieri")
@EnableMongoRepositories(basePackages = "dev.ranieri.repos")
public class EmployeeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeappApplication.class, args);
	}

}
