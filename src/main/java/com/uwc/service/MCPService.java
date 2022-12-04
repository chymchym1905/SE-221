package com.uwc.service;

import java.util.List;

import com.uwc.dto.MCPDto;

public interface MCPService {
	List<MCPDto> findAll();
	MCPDto findById(int id);
	void add(MCPDto dto);
	void update(MCPDto dto);
	void delete(int id);
	public List<MCPDto> search(String keyword);
}
