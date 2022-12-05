package com.uwc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
}
