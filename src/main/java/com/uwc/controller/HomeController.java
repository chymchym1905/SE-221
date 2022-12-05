package com.uwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("welcome")
public class HomeController {
	@GetMapping("")
	public String index(ModelMap model) {
		return "dashboard/welcome";
	}
}
