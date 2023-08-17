package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.entities.EmailDetails;
import com.email.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;

	@GetMapping("/hello")
	public String hey() {
		return "hello";
	}

	@PostMapping("/sendmail")
	public String sendMail(@RequestBody EmailDetails details) {
		boolean f = emailService.sendMail(details);
		System.out.println(f);
		System.out.println(details);
		if (f)
			return "Email Send Successfully";
		else
			return "Something Went Wrong";

	}
}
