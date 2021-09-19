package com.pkharat.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pkharat.smart.dao.UserRepository;
import com.pkharat.smart.entities.User;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		User user = new User();
		user.setName("purab");
		user.setEmail("test@test.com");
		user.setAbout("dddteee");
		userRepository.save(user);
		
		
		
		return "working";
	}
}
