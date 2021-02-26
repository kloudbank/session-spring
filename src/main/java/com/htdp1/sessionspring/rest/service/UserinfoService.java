package com.htdp1.sessionspring.rest.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class UserinfoService {
	@Autowired
	private RestService<Map<String, Object>> restService;

	@Value("${apis.userinfo}")
	private String restApisUserinfo;

	public Map<String, Object> getUserInfo(String id) {

		return restService.get(restApisUserinfo + id, HttpHeaders.EMPTY).getBody();
	}
}
