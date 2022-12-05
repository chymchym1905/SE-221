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
@Table(name = "user_announcement")
public class User_Announcement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int user_id;
	private int announcement_id;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User users; //done
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "announcement_id", insertable = false, updatable = false)
	private Announcement announcements; //done
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getAnnouncement_id() {
		return announcement_id;
	}

	public void setAnnouncement_id(int announcement_id) {
		this.announcement_id = announcement_id;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Announcement getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(Announcement announcements) {
		this.announcements = announcements;
	}
}
