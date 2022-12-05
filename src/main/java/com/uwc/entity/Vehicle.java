package com.uwc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float current_fuel;
	
	@OneToOne
	@JoinColumn(name="task_id", insertable = false, updatable = false )
	private Task task;

	public Vehicle() {}
	
	public Vehicle(int vehicleID, float current_fuel) {
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
