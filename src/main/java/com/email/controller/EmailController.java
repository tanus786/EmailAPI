package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.email.entities.EmailDetails;
import com.email.entities.EmailResponse;
import com.email.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	@Autowired
	private EmailService emailService;

	@GetMapping("/hello")
	public String hey() {
		return "hello";
	}

	@PostMapping("/sendmail")
	public ResponseEntity<?> sendMail(@RequestBody EmailDetails details) {
		boolean f = emailService.sendMail(details);
		System.out.println(f);
		System.out.println(details);
		if (f)
			return ResponseEntity.ok(new EmailResponse("Email Sent Successfully!!"));
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email Not Sent!!"));
				

	}
}
