package com.uwc.entity;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

	@Column(nullable = false)
	private String password;
	
	private int phone_number;
	private Boolean isAvailable;
	private Date birthday;
	private Date regisdate;

	@Column(name = "role_id")
	private int role_id;
	
	/* // old 
	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private List<User_Announcement> user_announcements; 
	
	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private Set<User_Task> user_tasks; // done
	
	@OneToMany(mappedBy = "users",  fetch = FetchType.LAZY)
	private Set<Route> route;
	*/
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "name", insertable = false, updatable = false)
	private Role roles; // done
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "User_Task", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "task_id"))
	private Set<Task> hasTasks;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "User_Announcement", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "announcement_id"))
	private Set<Announcement> hasAnnouncements;

	
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

}
