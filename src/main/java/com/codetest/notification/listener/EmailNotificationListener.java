package com.codetest.notification.listener;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.codetest.notification.model.EmailMessage;
import com.codetest.notification.service.EmailService;

@Component
public class EmailNotificationListener {

	@Autowired
	private EmailService service;

	@JmsListener(destination = "queue.notify")
	public void receiveQueue(Map<String, String> msgMap) {
		EmailMessage msg = EmailMessage.construct(msgMap);
		if (msg != null) {
			service.send(msg);
		}
	}

}
