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

import com.uwc.dto.VehicleDto;
import com.uwc.service.VehicleService;

@Controller
@RequestMapping("vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<VehicleDto> listvehicle = vehicleService.findAll();
		model.addAttribute("vehicles", listvehicle);
		return "vehicle/vehicle-index";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("vehicle", new VehicleDto());
		return "vehicle/vehicle-add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(ModelMap model, @ModelAttribute("vehicle") VehicleDto vehicle, 
			BindingResult errors) {
		// NẾU CÓ LỖI XẢY RA, CHUYỂN TIẾP LẠI VỀ TRANG HIỆN TẠI 
				// ĐỂ SHOW LỖI LÊN CHO NGƯỜI DÙNG THẤY
		if (errors.hasErrors()) {
			return "vehicle/vehicle-add";
		}
		try {
			vehicleService.add(vehicle);
			return "redirect:/vehicle";
		}
		catch ( Exception e) {
			model.addAttribute("message", "Thêm mới thất bại");
			return "vehicle/vehicle-add";
		}
	}
	
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		vehicleService.delete(id);
		return "redirect:/vehicle";
	}
}
