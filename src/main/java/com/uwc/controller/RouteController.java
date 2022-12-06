package com.uwc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uwc.dto.RouteDto;
import com.uwc.service.RouteService;

@Controller
@RequestMapping("route")
public class RouteController {
	@Autowired
	private RouteService routeService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		//Lấy User list từ db
		List<RouteDto> list = routeService.findAll();
		// Chuyển tiếp List qua Thymeleaf (user-index.html)
		model.addAttribute("routes",list);
		
		return "route/route-index";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		routeService.delete(id);
		return "redirect:/Route";
	}
}
