package com.uwc.service;

import java.util.List;

import com.uwc.dto.VehicleDto;

public interface VehicleService {
	List<VehicleDto> findAll();
	VehicleDto findById(int id);
	void add(VehicleDto dto);
	void update(VehicleDto dto);
	void delete(int id);
	public List<VehicleDto> search(String keyword);
}
