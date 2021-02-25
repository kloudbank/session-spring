package com.htdp1.sessionspring.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htdp1.sessionspring.rest.RestService;

@RestController
public class SessionController {
	@Autowired
	private RestService<Map<String, Object>> restService;

	@Value("${spring.application.name}")
	public String applicationName;

	@Value("${rest.apis.userinfo}")
	private String restApisUserinfo;

	@GetMapping("/session")
	@ResponseBody
	public Map<String, Object> index(HttpSession session) {
		if (session.getAttribute("SESSION_USERINFO") == null) {
			Map<String, Object> userInfo = getUserInfo();

			session.setAttribute("SESSION_USERINFO", userInfo);
		}

		Map<String, Object> sessionInfo = new HashMap<String, Object>();
		sessionInfo.put("SESSION_ID", session.getId());
		sessionInfo.put("SESSION_USERINFO", session.getAttribute("SESSION_USERINFO"));

		return sessionInfo;
	}

	private Map<String, Object> getUserInfo() {

		return restService.get(restApisUserinfo + "/test/10001", HttpHeaders.EMPTY).getBody();
	}
}
