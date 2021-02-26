package com.htdp1.sessionspring.cache.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htdp1.sessionspring.rest.service.UserinfoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CacheController {
	@Autowired
	private UserinfoService userinfoService;

	@Cacheable(value = "userinfo", key = "#id", cacheManager = "cacheManager")
	@GetMapping("/userinfo/{id}")
	@ResponseBody
	public Map<String, Object> getUserinfo(@PathVariable String id) {

		Map<String, Object> userInfo = userinfoService.getUserInfo(id);

		log.info("cache miss");

		return userInfo;
	}

	@CacheEvict(value = "userinfo", key = "#id", cacheManager = "cacheManager")
	@DeleteMapping("/userinfo/{id}")
	public void deleteUserinfo(@PathVariable String id) {

		log.info("deleteUserinfo");
	}
}
