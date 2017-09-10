package com.codetest.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.codetest.notification.model.EmailMessage;
import com.codetest.notification.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Value("${login.mail.from}")
	private String mailFrom;

	@Value("${login.mail.subject}")
	private String mailSubject;

	@Override
	public void send(EmailMessage message) {		
		SimpleMailMessage mailMsg = new SimpleMailMessage();
		mailMsg.setTo(message.getEmail());
		mailMsg.setFrom(mailFrom);
		mailMsg.setSubject(mailSubject);
		mailMsg.setText(message.getContent());
		mailSender.send(mailMsg);
	}

}
