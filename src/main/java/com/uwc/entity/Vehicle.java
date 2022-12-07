package com.uwc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float current_fuel;
	private float fuel_consump_rate;
	
	@OneToOne
	@JoinColumn(name="task_id", insertable = false, updatable = false )
	private Task task;

	public Vehicle() {}
	

}
