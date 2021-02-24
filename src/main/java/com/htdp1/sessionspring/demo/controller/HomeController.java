package com.htdp1.sessionspring.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Value("${spring.application.name}")
	public String applicationName;

	@GetMapping("/")
	public String index() {
		return "Bonjour, Spring,,,";
	}

	@GetMapping("/session")
	@ResponseBody
	public String index(HttpSession session) {
		session.setAttribute("applicationName", applicationName);
		return session.getId() + "\nHello " + session.getAttribute("applicationName");
	}
}
