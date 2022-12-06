package com.uwc.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDto {

	private int id;
	private Date date_time;
	private String description;
	

	/*
	public AnnouncementDto(int id, Date date_time, String description, int user_id) {
		super();
		this.id = id;
		this.date_time = date_time;
		this.description = description;
		this.user_id = user_id;
	}
	*/

}
