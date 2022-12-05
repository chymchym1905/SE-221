package com.uwc.dto;

import com.uwc.entity.Route;

public class RouteDto {

	private int id;
	private String name;
	private float length;
	private TaskDto task;
	
	public RouteDto() {}

	public RouteDto(int id, String name, float length, int task) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
		this.task.setId(task);
	}

	public RouteDto(int id2, String name2, float length2, Class<? extends Route> class1) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public TaskDto getTask() {
		return task;
	}
	
	public int getTaskId() {
		return task.getId();
	}
	
	public int setTaskId(int id) {
		return task.setId(id);
	}

	public void setTask(TaskDto task) {
		this.task = task;
	}

	public int getId() {
		return id;
	}



}
