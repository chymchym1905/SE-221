package com.uwc.service;

import java.util.List;

import com.uwc.dto.RouteDto;

public interface RouteService {
	List<RouteDto> findAll();
	RouteDto findById(int id);
	void add(RouteDto dto);
	void update(RouteDto dto);
	void delete(int id);
	public List<RouteDto> search(String keyword);
}
