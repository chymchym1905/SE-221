package com.uwc.dto;

public class VehicleDto {

	private int id;
	private float current_fuel;

	public VehicleDto() {}
	
	

	public VehicleDto(int vehicleID, float current_fuel) {
		super();
		this.id = vehicleID;
		this.current_fuel = current_fuel;
	}



	public float getCurrent_fuel() {
		return current_fuel;
	}



	public void setCurrent_fuel(float current_fuel) {
		this.current_fuel = current_fuel;
	}


	public int getId() {
		return id;
	}



}
