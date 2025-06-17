package com.mavericks.onboarding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mavericks.onboarding.entity.Register;
import com.mavericks.onboarding.serivce.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@PostMapping ("/user")
	public Register registerUser(@RequestBody Register register) {
		return registerService.registerUser(register);				
	}

}
