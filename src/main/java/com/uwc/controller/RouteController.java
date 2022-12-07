package com.uwc.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uwc.dto.RouteDto;
import com.uwc.dto.TaskDto;
import com.uwc.service.RouteService;
import com.uwc.service.TaskService;

@Controller
@RequestMapping("route")
public class RouteController {
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		//Lấy User list từ db
		List<RouteDto> list = routeService.findAll();
		// Chuyển tiếp List qua Thymeleaf (user-index.html)
		model.addAttribute("routes",list);
		
		return "route/route-index";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("route", new RouteDto());
		
		List<TaskDto> listtask = taskService.findAll();


		model.addAttribute("tasks", listtask);
		return "route/route-add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(ModelMap model, @ModelAttribute("route") RouteDto route, 
			BindingResult errors) {
		// NẾU CÓ LỖI XẢY RA, CHUYỂN TIẾP LẠI VỀ TRANG HIỆN TẠI 
				// ĐỂ SHOW LỖI LÊN CHO NGƯỜI DÙNG THẤY
		if (errors.hasErrors()) {
			return "route/route-add";
		}
		try {
			routeService.add(route);
			return "redirect:/route";
		}
		catch ( Exception e) {
			model.addAttribute("message", "Thêm mới thất bại");
			return "route/route-add";
		}
	}
	
	@RequestMapping(value = "edit/{id}",method = RequestMethod.GET)
	public String edit(ModelMap model, @PathVariable("id") int id) {
		RouteDto route =  routeService.findById(id);
		model.addAttribute("editroute", route);
		return "route/route-edit";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String editPost(ModelMap model,  @PathVariable("id") int id, RouteDto route,
			BindingResult errors) {
		// NẾU CÓ LỖI XẢY RA, CHUYỂN TIẾP LẠI VỀ TRANG HIỆN TẠI 
				// ĐỂ SHOW LỖI LÊN CHO NGƯỜI DÙNG THẤY
		if (errors.hasErrors()) {
			route.setId(id);
			return "route/route-edit";
		}
		try {
			routeService.update(route);
			return "redirect:/route";
		}
		catch ( Exception e) {
			model.addAttribute("message", "Cập nhật thất bại");
			return "route/route-edit";
		}
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		routeService.delete(id);
		return "redirect:/Route";
	}
}
