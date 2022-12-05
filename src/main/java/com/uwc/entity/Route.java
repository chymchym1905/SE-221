package com.uwc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "routes")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float length;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User users;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="task_id")
	private Task task;
	
	@OneToMany(mappedBy = "routes", fetch = FetchType.LAZY)	
	private List<MCP_Route> mcp_routes; // done

	public Route() {}

	public Route(int id, String name, float length) {
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
	
	public Task getTask() {
		return task;
	}
	
	public int getTaskId() {
		return task.getId();
	}
	
	public int setTaskId(int id) {
		return task.setId(id);
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
}
