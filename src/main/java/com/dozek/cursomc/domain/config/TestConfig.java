package com.dozek.cursomc.domain.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dozek.cursomc.services.DBService;
import com.dozek.cursomc.services.EmailService;
import com.dozek.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instatiateDataBase() throws ParseException {
		dbService.instantiateTestDataBase();
				
		return true;
	}
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
