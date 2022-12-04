package com.uwc.entity;

import java.util.List;

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
@Table(name = "mcps")
public class MCP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float fullness;
	private float latitude;
	private float longtitude;
	private int user_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", insertable = false, updatable = false)
	private User users;
	
	@OneToMany(mappedBy = "mcps", fetch = FetchType.LAZY)
	private List<MCP_Route> mcp_routes; // done
	

	public MCP() {}
	

	public MCP(int id, float fullness, float latitude, float longtitude, int user_id ) {
		super();
		this.id = id;
		this.fullness = fullness;
		this.latitude = latitude;
		this.user_id = user_id;
		this.longtitude = longtitude;
	}


	public float getFullness() {
		return fullness;
	}

	public void setFullness(float fullness) {
		this.fullness = fullness;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}

	public int getId() {
		return id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	

}
