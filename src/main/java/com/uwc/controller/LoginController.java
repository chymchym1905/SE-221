package com.uwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("logon")
public class LoginController {
	@GetMapping("")
	public String LogIn(ModelMap model) {
		return "login";
	}
}

