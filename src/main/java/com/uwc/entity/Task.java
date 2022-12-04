package com.uwc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Date start_date;
	private Date end_date;
	private Boolean isComplete;
	
	
	@OneToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
	private List<User_Task> user_tasks; // done
	
	@OneToOne(mappedBy = "task")
	private Route route;
	
	@OneToOne(mappedBy = "task")
	private Vehicle vehicle;
	
	
	public Task() {}

	public Task(int id, Date start_date, Date end_date, Boolean isComplete) {
		super();
		this.id = id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.isComplete = isComplete;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	public int getId() {
		return id;
	}
	
}
