package com.uwc.dto;

import java.util.Set;

import com.uwc.entity.MCP;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto {

	private int id;
	private String name;
	private float length;
	private int task_id; 
	private Set<String> hasMCPs;
	
	public RouteDto(int id, String name, float length, int task_id) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
		this.task_id = task_id;
	}
	
}
