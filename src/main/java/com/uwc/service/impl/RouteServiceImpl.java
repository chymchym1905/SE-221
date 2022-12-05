package com.uwc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwc.dto.RouteDto;
import com.uwc.entity.Route;
import com.uwc.repository.RouteRepository;
import com.uwc.service.RouteService;

@Service
@Transactional(rollbackOn = Exception.class)
public class RouteServiceImpl implements RouteService {
	@Autowired
	private RouteRepository routeRepository;
	
	@Override
	public List<RouteDto> findAll() {
		List<RouteDto> dtos = new ArrayList<RouteDto>();
		
		List<Route> routes = routeRepository.findAll();
		
		for (Route Route : routes) {
			dtos.add(new RouteDto(Route.getId(), Route.getName(), Route.getLength(), Route.getTaskId())); //Sửa lại constructor (thêm getTaskId)
		}
		return dtos;
	}
	
	@Override
	public RouteDto findById(int id) {
		Route Route = routeRepository.findById(id).get();
		return new RouteDto(Route.getId(), Route.getName(), Route.getLength(), Route.getTaskId()); //Sửa lại constructor (thêm getTaskId)
	}

	@Override
	public void add(RouteDto dto) {
		Route Route = new Route();
		Route.setName(dto.getName());
		Route.setLength(dto.getLength());
		Route.setTaskId(dto.getTask_id());
		
		routeRepository.save(Route);
	}

	@Override
	public void update(RouteDto dto) {
		Route Route = routeRepository.findById(dto.getId()).get();
		Route.setName(dto.getName());
		Route.setLength(dto.getLength());
		Route.setTaskId(dto.getTask_id());
	}

	@Override
	public void delete(int id) {
		routeRepository.deleteById(id);
	}

	@Override
	public List<RouteDto> search(String keyword) {
		List<RouteDto> dtos = new ArrayList<RouteDto>();
		List<Route> routes = routeRepository.search(keyword);
		for (Route Route : routes) {
			dtos.add(new RouteDto(Route.getId(), Route.getName(), Route.getLength(), Route.getTaskId()));  //Sửa lại constructor (thêm getTaskId)
		}		
			return dtos;
	}
}
