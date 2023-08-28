package com.monocept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.service.EmailService;

@RestController
@RequestMapping("/mail")
public class EmailRestController {
	
	@Autowired
	private EmailService service;
	
	@PostMapping("/{toemail}/{subject}/{body}")
	public void sendMail(@PathVariable(name = "toemail") String toEmail,@PathVariable(name = "subject") String subject,@PathVariable(name = "body") String body) {
		service.sendEmail(toEmail, subject, body);
	}

}
