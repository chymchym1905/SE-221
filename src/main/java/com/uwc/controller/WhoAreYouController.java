package com.uwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("map")
public class WhoAreYouController {
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index() {
		return "dashboard/createroutemanually";
	}
}
