package com.uwc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uwc.dto.TaskDto;
import com.uwc.dto.UserDto;
import com.uwc.service.TaskService;
import com.uwc.service.UserService;
import com.uwc.dto.RoleDto;
import com.uwc.dto.RouteDto;
import com.uwc.service.RouteService;
import com.uwc.dto.VehicleDto;
import com.uwc.service.VehicleService;

@Controller
@RequestMapping("task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<TaskDto> list = taskService.findAll();

		List<UserDto> listuser = userService.findAll();
		List<VehicleDto> listvehicle = vehicleService.findAll();
		model.addAttribute("tasks", list);

		model.addAttribute("users", listuser);
		model.addAttribute("vehicles", listvehicle);
		return "task/task-index";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("task", new TaskDto());
		//Dùng để browse và select task/route/vehicle trong 1 task
		List<UserDto> listuser = userService.findAll();
		List<VehicleDto> listvehicle = vehicleService.findAll();
		model.addAttribute("users", listuser);
		model.addAttribute("vehicles", listvehicle);
		return "task/task-add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(ModelMap model, @ModelAttribute("task") TaskDto task, 
			//Thay đổi giá trị taskID tương ứng cho route, task và vehicle
			@ModelAttribute("route") RouteDto route, 
			@ModelAttribute("user") UserDto user, 
			@ModelAttribute("vehicle") VehicleDto vehicle, 
			BindingResult errors) 
	{
		if (errors.hasErrors()) {
			return "task/task-add";
		}
		try {
			taskService.add(task);
			userService.add(user);
			vehicleService.add(vehicle);
			return "redirect:/task";
		}
		catch (Exception e) {
			model.addAttribute("message", "Thêm mới thất bại");
			return "task/task-add";
		}
	}
	
	@RequestMapping(value = "edit/{id}",method = RequestMethod.GET)
	public String edit(ModelMap model, @PathVariable("id") int id) {
		TaskDto task =  taskService.findById(id);
		model.addAttribute("edittask", task);
		List<VehicleDto> listvehicle = vehicleService.findAll();
		model.addAttribute("vehicles", listvehicle);
		List<UserDto> listuser= userService.findAll();
		model.addAttribute("users", listuser);

		return "task/task-edit";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String editPost(ModelMap model,  @PathVariable("id") int id, TaskDto task,
			BindingResult errors) {
		// NẾU CÓ LỖI XẢY RA, CHUYỂN TIẾP LẠI VỀ TRANG HIỆN TẠI 
				// ĐỂ SHOW LỖI LÊN CHO NGƯỜI DÙNG THẤY
		if (errors.hasErrors()) {
			task.setId(id);
			return "task/task-edit";
		}
		try {
			taskService.update(task);
			return "redirect:/task";
		}
		catch ( Exception e) {
			model.addAttribute("message", "Cập nhật thất bại");
			return "task/task-edit";
		}
	}
	
	@RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		taskService.delete(id);
		return "redirect:/task";
	}
}
