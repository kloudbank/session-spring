package com.htdp1.sessionspring.session.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htdp1.sessionspring.rest.service.UserinfoService;

@RestController
public class SessionController {
	@Autowired
	private UserinfoService userinfoService;

	@Value("${spring.application.name}")
	public String applicationName;

	@GetMapping("/session/{id}")
	@ResponseBody
	public Map<String, Object> session(@PathVariable String id, HttpSession session) {
		if (session.getAttribute("SESSION_USERINFO") == null) {
			Map<String, Object> userInfo = userinfoService.getUserInfo(id);

			session.setAttribute("SESSION_USERINFO", userInfo);
		}

		Map<String, Object> sessionInfo = new HashMap<String, Object>();
		sessionInfo.put("SESSION_ID", session.getId());
		sessionInfo.put("SESSION_USERINFO", session.getAttribute("SESSION_USERINFO"));

		return sessionInfo;
	}

}
