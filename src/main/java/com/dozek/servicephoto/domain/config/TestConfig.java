package com.dozek.servicephoto.domain.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dozek.servicephoto.services.DBService;
import com.dozek.servicephoto.services.EmailService;
import com.dozek.servicephoto.services.MockEmailService;

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
