package com.dozek.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.dozek.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
