package com.email.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@GetMapping("/index")
	public String welcome() {
		return "Hello";
	}
}
