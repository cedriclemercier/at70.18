package com.example.donutondemand.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
	void sendEmail(SimpleMailMessage emailMsg);
}
