package com.uwc.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "mcps")
public class MCP {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float fullness;
	private float latitude;
	private float longtitude;
	
	/*
	@OneToMany(mappedBy = "mcps", fetch = FetchType.LAZY)
	private List<MCP_Route> mcp_routes; // done
	*/
	
	@ManyToMany(mappedBy = "hasMCPs")
	private Set<Route> routes;
}
