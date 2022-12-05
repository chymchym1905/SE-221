package com.uwc.dto;


public class User_TaskDto {

	private int id;

    private int user_id;
    private int task_id;


    public User_TaskDto() {}


	public User_TaskDto(int id, int user_id, int task_id) {
		super();
		this.id = id;
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


	public int getId() {
		return id;
	}

    
}
