package com.codetest.notification.service;

import com.codetest.notification.model.EmailMessage;

public interface EmailService {
	
	public void send(EmailMessage message);

}
