package com.codetest.notification.model;

import java.io.Serializable;
import java.util.Map;

public class EmailMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1866295200727947703L;

	private String content;

	private String email;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static EmailMessage construct(Map<String, String> msgMap) {
		EmailMessage msg = null;
		if (msgMap != null && msgMap.containsKey("email")) {
			msg = new EmailMessage();
			msg.setContent(msgMap.get("content"));
			msg.setEmail(msgMap.get("email"));
		}
		return msg;
	}

}
