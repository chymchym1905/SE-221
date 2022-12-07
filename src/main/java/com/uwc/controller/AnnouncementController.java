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

import com.uwc.dto.AnnouncementDto;
import com.uwc.service.AnnouncementService;

@Controller
@RequestMapping("announcement")
public class AnnouncementController {
	@Autowired
	private AnnouncementService announcementService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		//Lấy User list từ db
		List<AnnouncementDto> list = announcementService.findAll();
		// Chuyển tiếp List qua Thymeleaf (user-index.html)
		model.addAttribute("announcements",list);
		
		return "announcement/announcement-index";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("announcement", new AnnouncementDto());
		return "announcement/announcement-add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(ModelMap model, @ModelAttribute("announcement") AnnouncementDto announcement, 
			BindingResult errors) {
		// NẾU CÓ LỖI XẢY RA, CHUYỂN TIẾP LẠI VỀ TRANG HIỆN TẠI 
				// ĐỂ SHOW LỖI LÊN CHO NGƯỜI DÙNG THẤY
		if (errors.hasErrors()) {
			return "announcement/announcement-add";
		}
		try {
			announcementService.add(announcement);
			return "redirect:/announcement";
		}
		catch ( Exception e) {
			model.addAttribute("message", "Thêm mới thất bại");
			return "announcement/announcement-add";
		}
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		announcementService.delete(id);
		return "redirect:/announcement";
	}
}
