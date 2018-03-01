package com.wapp.server.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wapp.server.models.User;


@RestController
@RequestMapping("/api")
public class AuthorizationController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "/usercreation", method=RequestMethod.POST)
	public String signUp(@RequestBody User user) {
		logger.debug("User Creation started!");
		System.out.println(user.getUserName());
		logger.debug("User Creation Succeeded!");
		return "OK";
	}
}
