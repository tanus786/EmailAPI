package com.email.entities;

public class EmailDetails {
	private String recipient;
	private String msg;
	private String subject;

	public EmailDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailDetails(String recipient, String msg, String subject) {
		super();
		this.recipient = recipient;
		this.msg = msg;
		this.subject = subject;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "EmailDetails [recipient=" + recipient + ", msg=" + msg + ", subject=" + subject + "]";
	}
}
