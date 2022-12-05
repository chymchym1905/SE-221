package com.uwc.model;

import java.util.Date;

public class RegisterViewModel {

	private int id;
	
	private String email;

	private String password;
	
	
	private int phone_number;
	private Boolean isAvailable;
	private Date birthday;
	private Date regisdate;

	private int role_id;
	

	public RegisterViewModel() {}
	
	public RegisterViewModel(int id, String email, int phone_number, Boolean isAvailable, String password,
			Date birthday, Date regisdate, int role_id) {
		super();
		this.id = id;
		this.email = email;
		this.phone_number = phone_number;
		this.isAvailable = isAvailable;
		this.password = password;
		this.birthday = birthday;
		this.regisdate = regisdate;
		this.role_id = role_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getRegisdate() {
		return regisdate;
	}

	public void setRegisdate(Date regisdate) {
		this.regisdate = regisdate;
	}

	public int getId() {
		return id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

}
