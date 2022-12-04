package com.uwc.dto;

public class MCPDto {

	private int id;
	private float fullness;
	private float latitude;
	private float longtitude;
	private int user_id;

	public MCPDto() {}

	public MCPDto(int id, float fullness, float latitude, float longtitude, int user_id) {
		super();
		this.id = id;
		this.fullness = fullness;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.user_id = user_id;
	}

	public float getFullness() {
		return fullness;
	}

	public void setFullness(float fullness) {
		this.fullness = fullness;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}
	

	

}
