package com.app.trade.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.trade.bo.User;
import com.app.trade.service.UserLoginService;

@RestController
@RequestMapping("/login")
public class TradeLoginRestController {
	
	@Autowired
	UserLoginService userLoginService;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getUserDetails(@RequestParam("userId") int userId) {
		return "ok";
	}
	
	@RequestMapping(method=RequestMethod.PATCH, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateUserDetails(@RequestBody User user){
		userLoginService.updateUserDetails(user);
		return "ok";
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addUserDetails(@RequestBody User user){
		userLoginService.addUser(user);
		return "ok";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteUserDetails(@RequestBody User user){
		userLoginService.deleteUser(user);
		return "ok";
	}
}

