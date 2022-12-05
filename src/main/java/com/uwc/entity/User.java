package com.uwc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	
	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true, length = 20)
	private String password;
	
	
	private int phone_number;
	private Boolean isAvailable;
	private Date birthday;
	private Date regisdate;

	@Column(name = "role_id")
	private int role_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role roles; // done
	
	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private List<User_Announcement> user_announcements; 
	
	@OneToMany(mappedBy = "users",  fetch = FetchType.LAZY)
	private List<MCP> mcp;
	
	@OneToMany(mappedBy = "users",  fetch = FetchType.LAZY)
	private List<Route> route;
	
	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private List<User_Task> user_tasks; // done

	public User() {}
	
	public User(int id, String username, String email, int phone_number, Boolean isAvailable, String password,
			Date birthday, Date regisdate, int role_id) {
		super();
		this.id = id;
		this.username = username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Role getRole() {
		return this.roles;
	}
	
	public void setRole(Role role) {
		this.roles = role;
	}
}
