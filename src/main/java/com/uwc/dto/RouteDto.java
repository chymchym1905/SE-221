package com.uwc.dto;

public class RouteDto {

	private int id;
	private String name;
	private float length;

	public RouteDto() {}

	public RouteDto(int id, String name, float length) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
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

	public int getId() {
		return id;
	}

}
