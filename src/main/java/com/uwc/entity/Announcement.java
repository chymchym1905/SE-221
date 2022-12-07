package com.uwc.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Data
@Entity
@Table(name = "announcements")
public class Announcement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_time;
	private String description;
	/* 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", insertable = false, updatable = false)
	private User users; // done
	
	@OneToMany(mappedBy = "announcements", fetch = FetchType.LAZY)
	private List<User_Announcement> user_announcements; // done
	 */
	@ManyToMany(mappedBy = "hasAnnouncements")
	private Set<User> users;

	public Announcement(int id, Date date_time, String description) {
		super();
		this.id = id;
		this.date_time = date_time;
		this.description = description;
	}
}
