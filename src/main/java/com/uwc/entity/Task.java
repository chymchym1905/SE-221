package com.uwc.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Date start_date;
	private Date end_date;
	private Boolean isComplete;
	
	/*
	@OneToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
	private List<User_Task> user_tasks; // done
	*/
	
	@ManyToMany(mappedBy = "hasTasks")
	private Set<User> users;
	
	@OneToOne(mappedBy = "task")
	private Route route;
	
	@OneToOne(mappedBy = "task")
	private Vehicle vehicle;
}
