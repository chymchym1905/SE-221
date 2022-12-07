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

import com.uwc.dto.RoleDto;
import com.uwc.dto.UserDto;
import com.uwc.service.RoleService;
import com.uwc.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		//Lấy User list từ db
		List<UserDto> list = userService.findAll();
		// Chuyển tiếp List qua Thymeleaf (user-index.html)
		model.addAttribute("users",list);
		
		//UserDto dto = new UserDto(5,"chuong", "chuong@gmail.com", 901, true, "123", 1);
		//userService.add(dto);
		return "user/user-index";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("user", new UserDto());
		
		List<RoleDto> list = roleService.findAll();
		model.addAttribute("roles", list);
		return "user/user-add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(ModelMap model, @ModelAttribute("user") UserDto user, 
			BindingResult errors) {
		// NẾU CÓ LỖI XẢY RA, CHUYỂN TIẾP LẠI VỀ TRANG HIỆN TẠI 
				// ĐỂ SHOW LỖI LÊN CHO NGƯỜI DÙNG THẤY
		
		
		if (errors.hasErrors()) {
			return "user/user-add";
		}
		try {
			userService.add(user);
			return "redirect:/user";
		}
		catch ( Exception e) {
			model.addAttribute("message", "Thêm mới thất bại");
			return "user/user-add";
		}
	}
	
	@RequestMapping(value = "edit/{id}",method = RequestMethod.GET)
	public String edit(ModelMap model, @PathVariable("id") int id) {
		UserDto user =  userService.findById(id);
		model.addAttribute("edituser", user);
		List<RoleDto> list = roleService.findAll();
		model.addAttribute("roles", list);
		return "user/user-edit";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String editPost(ModelMap model,  @PathVariable("id") int id, UserDto user,
			BindingResult errors) {
		// NẾU CÓ LỖI XẢY RA, CHUYỂN TIẾP LẠI VỀ TRANG HIỆN TẠI 
				// ĐỂ SHOW LỖI LÊN CHO NGƯỜI DÙNG THẤY
		if (errors.hasErrors()) {
			user.setId(id);
			return "user/user-edit";
		}
		try {
			userService.update(user);
			return "redirect:/user";
		}
		catch ( Exception e) {
			model.addAttribute("message", "Cập nhật thất bại");
			return "user/user-edit";
		}
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		userService.delete(id);
		return "redirect:/user";
	}
}
