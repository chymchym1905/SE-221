package com.uwc.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "routes")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float length;
	private int task_id;
	
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User users;
	*/
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="task_id", insertable = false, updatable = false)
	private Task task;
	/*
	@OneToMany(mappedBy = "routes", fetch = FetchType.LAZY)	
	private List<MCP_Route> mcp_routes; // done
	*/
	@ManyToMany
	@JoinTable(
		name = "Route_MCP", 
		joinColumns = @JoinColumn(name = "route_id"), 
		inverseJoinColumns = @JoinColumn(name = "mcp_id"))
	private Set<MCP> hasMCPs;
	
	public Route(int id, String name, float length, int task_id) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
		this.task_id = task_id;
	}

}
