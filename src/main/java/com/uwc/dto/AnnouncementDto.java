package com.uwc.dto;

import java.util.Date;

public class AnnouncementDto {

	private int id;
	private Date date_time;
	private String description;
	private int user_id;
	
	public AnnouncementDto() {}

	public AnnouncementDto(int id, Date date_time, String description, int user_id) {
		super();
		this.id = id;
		this.date_time = date_time;
		this.description = description;
		this.user_id = user_id;
	}

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	

}
