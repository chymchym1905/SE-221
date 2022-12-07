package com.uwc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uwc.dto.VehicleDto;
import com.uwc.service.VehicleService;

@RestController
@RequestMapping("api/vehicle")
public class ApiVehicleController {
	
	@Autowired
	private VehicleService vehicleService;

	@GetMapping("")
	public Object get() {
		List<VehicleDto> vehicles = vehicleService.findAll();
		return new ResponseEntity<Object>(vehicles, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			VehicleDto vehicle = vehicleService.findById(id);
			return new ResponseEntity<Object>(vehicle, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("No data found!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	public Object post(@RequestBody VehicleDto dto) {
		try {
			vehicleService.add(dto);
			return new ResponseEntity<String>("Add successfully!", HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Add failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("")
	public Object put(@RequestBody VehicleDto dto) {
		try {
			vehicleService.update(dto);
			return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Update failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			vehicleService.delete(id);
			return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Delete failed!", HttpStatus.BAD_REQUEST);
		}
	}
}
