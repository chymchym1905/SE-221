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

import com.uwc.dto.TaskDto;
import com.uwc.service.TaskService;

@RestController
@RequestMapping("api/task")
public class ApiTaskController {
	
	@Autowired
	private TaskService taskService;

	@GetMapping("")
	public Object get() {
		List<TaskDto> tasks = taskService.findAll();
		return new ResponseEntity<Object>(tasks, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			TaskDto task = taskService.findById(id);
			return new ResponseEntity<Object>(task, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("No data found!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	public Object post(@RequestBody TaskDto dto) {
		try {
			taskService.add(dto);
			return new ResponseEntity<String>("Add successfully!", HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Add failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("")
	public Object put(@RequestBody TaskDto dto) {
		try {
			taskService.update(dto);
			return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Update failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			taskService.delete(id);
			return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Delete failed!", HttpStatus.BAD_REQUEST);
		}
	}
}
