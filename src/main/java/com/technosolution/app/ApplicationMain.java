package com.technosolution.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.technosolution.test.MainService;

@Configuration
@SpringBootApplication
public class ApplicationMain {
	
	
	public static void main(String[] args) {
		MainService service = new MainService();
		service.getMaxSatisfaction();
		SpringApplication.run(ApplicationMain.class,args);

	}
	

}
