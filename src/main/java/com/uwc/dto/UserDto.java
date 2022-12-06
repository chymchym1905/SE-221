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
		
}
