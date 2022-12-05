package com.uwc.dto;

import com.uwc.entity.Route;

public class RouteDto {

	private int id;
	private String name;
	private float length;
	private int task_id; //Dùng để lưu task id cho việc giao tiếp với controller
	
	public RouteDto() {}

	public RouteDto(int id, String name, float length, int task) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
		this.task_id=task;
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

	
	public int getTask_id() {
		return this.task_id;
	}
	
	public void setTas_id(int id) {
		this.task_id=id;
	}


	public int getId() {
		return id;
	}



}
