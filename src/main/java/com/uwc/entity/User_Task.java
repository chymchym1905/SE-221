package com.uwc.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_task")
public class User_Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private int user_id;
    private int task_id;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User users; //done
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id", insertable = false, updatable = false)
	private Task tasks; //done

    public User_Task() {}

    public User_Task(int user_id, int task_id) {
		super();
		this.user_id = user_id;
		this.task_id = task_id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
}
