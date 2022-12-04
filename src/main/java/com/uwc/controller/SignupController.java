package com.uwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("signup")
public class SignupController {
	@GetMapping("")
	public String SignUp(ModelMap model) {
		return "signup";
	}
}

