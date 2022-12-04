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
@Table(name = "mcp_routes")
public class MCP_Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int mcp_id;
	private int route_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mcp_id", insertable = false, updatable = false)
	private MCP mcps; //done
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "route_id", insertable = false, updatable = false)
	private Route routes; //done
	
	public MCP_Route() {}

	public MCP_Route(int id, int mcp_id, int route_id) {
		super();
		this.id = id;
		this.mcp_id = mcp_id;
		this.route_id = route_id;
	}

	public int getMcp_id() {
		return mcp_id;
	}

	public void setMcp_id(int mcp_id) {
		this.mcp_id = mcp_id;
	}

	public int getRoute_id() {
		return route_id;
	}

	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}

	public int getId() {
		return id;
	}
	
	

	
	
}
