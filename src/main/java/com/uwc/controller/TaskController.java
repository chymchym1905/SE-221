package com.uwc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uwc.dto.TaskDto;
import com.uwc.service.TaskService;

@Controller
@RequestMapping("Task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("")
	public String index(ModelMap model) {
		//List<TaskDto> list = taskService.findAll();
		return "";
	}
}
