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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	@ManyToMany(mappedBy = "hasTasks")
	private Set<User> users;
	
	@OneToOne(mappedBy = "task")
	private Route route;
	
	@OneToOne(mappedBy = "task")
	private Vehicle vehicle;
	
	public Task(int id, Date start_date, Date end_date, Boolean isComplete) {
		super();
		this.id = id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.isComplete = isComplete;
	}
}
