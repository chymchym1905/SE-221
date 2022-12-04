package com.uwc.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "roles") // ÁNh xạ lớp Role với bảng roles trong db
public class Role {

	@Id // Khai báo đây khóa chính
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Khai báo khóa chính tăng tự động
	private int id;

	private String name;
	
	@OneToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<User> users; // done
	
	
	public Role() {}

	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
