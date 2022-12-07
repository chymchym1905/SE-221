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
public class UserDto {

	private int id;
	private String username;

	private String email;
	private int phone_number;
	private Boolean isAvailable;
	private String password;
	private Date birthday;
	private Date regisdate;
	private int role_id;
	
	public UserDto(int id, String username, String email, int phone_number, Boolean isAvailable, String password, int role_id) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone_number = phone_number;
		this.isAvailable = isAvailable;
		this.password = password;
		this.birthday = null;
		this.regisdate = new Date();
		this.role_id = role_id;
	}
	
}
