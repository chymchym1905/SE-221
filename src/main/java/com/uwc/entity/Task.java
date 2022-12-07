package com.uwc.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end_date;
	private Boolean isComplete;
	
	/*
	@OneToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
	private List<User_Task> user_tasks; // done
	*/
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "User_Task", 
			joinColumns = @JoinColumn(name = "task_id"), 
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users;
	
	@OneToOne(mappedBy = "task")
	private Route route;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "task")
	private Vehicle vehicle;
}
