package com.uwc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwc.dto.VehicleDto;
import com.uwc.entity.Vehicle;
import com.uwc.repository.VehicleRepository;
import com.uwc.service.VehicleService;


@Service
@Transactional(rollbackOn = Exception.class)
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public List<VehicleDto> findAll() {
		List<VehicleDto> dtos = new ArrayList<VehicleDto>();
		
		List<Vehicle> vehicles = vehicleRepository.findAll();
		
		for (Vehicle Vehicle : vehicles) {
			dtos.add(new VehicleDto(Vehicle.getId(), Vehicle.getCurrent_fuel(), Vehicle.getFuel_consump_rate()));
		}
		return dtos;
	}
	
	@Override
	public VehicleDto findById(int id) {
		Vehicle Vehicle = vehicleRepository.findById(id).get();
		return new VehicleDto(Vehicle.getId(), Vehicle.getCurrent_fuel(), Vehicle.getFuel_consump_rate());
	}

	@Override
	public void add(VehicleDto dto) {
		Vehicle Vehicle = new Vehicle();
		Vehicle.setCurrent_fuel(dto.getCurrent_fuel());
		Vehicle.setCurrent_fuel(dto.getFuel_consump_rate());
		vehicleRepository.save(Vehicle);
	}

	@Override
	public void update(VehicleDto dto) {
		Vehicle Vehicle = vehicleRepository.findById(dto.getId()).get();
		Vehicle.setCurrent_fuel(dto.getCurrent_fuel());
		Vehicle.setFuel_consump_rate(dto.getFuel_consump_rate());
		vehicleRepository.save(Vehicle);
	}

	@Override
	public void delete(int id) {
		vehicleRepository.deleteById(id);
	}

	@Override
	public List<VehicleDto> search(String keyword) {
		List<VehicleDto> dtos = new ArrayList<VehicleDto>();
		List<Vehicle> vehicles = vehicleRepository.search(keyword);
		for (Vehicle Vehicle : vehicles) {
			dtos.add(new VehicleDto(Vehicle.getId(), Vehicle.getCurrent_fuel(), Vehicle.getFuel_consump_rate()));
		}		
			return dtos;
	}
}
