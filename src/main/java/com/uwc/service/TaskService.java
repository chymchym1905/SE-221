package com.uwc.service;

import java.util.List;

import com.uwc.dto.TaskDto;

public interface TaskService {
	List<TaskDto> findAll();
	TaskDto findById(int id);
	void add(TaskDto dto);
	void update(TaskDto dto);
	void delete(int id);
	public List<TaskDto> search(String keyword);
}
