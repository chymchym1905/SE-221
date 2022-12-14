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

import com.uwc.dto.RoleDto;
import com.uwc.service.RoleService;

@RestController
@RequestMapping("api/role")
public class ApiRoleController {
	
	@Autowired
	private RoleService roleService;

	@GetMapping("")
	public Object get() {
		List<RoleDto> roles = roleService.findAll();
		return new ResponseEntity<Object>(roles, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			RoleDto role = roleService.findById(id);
			return new ResponseEntity<Object>(role, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("No data found!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	public Object post(@RequestBody RoleDto dto) {
		try {
			roleService.add(dto);
			return new ResponseEntity<String>("Add successfully!", HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Add failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("")
	public Object put(@RequestBody RoleDto dto) {
		try {
			roleService.update(dto);
			return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Update failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			roleService.delete(id);
			return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Delete failed!", HttpStatus.BAD_REQUEST);
		}
	}
}
