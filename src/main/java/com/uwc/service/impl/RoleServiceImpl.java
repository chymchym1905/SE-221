package com.uwc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwc.dto.RoleDto;
import com.uwc.entity.Role;
import com.uwc.repository.RoleRepository;
import com.uwc.service.RoleService;


@Service
@Transactional(rollbackOn = Exception.class)
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<RoleDto> findAll() {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		
		List<Role> roles = roleRepository.findAll();
		
		for (Role Role : roles) {
			dtos.add(new RoleDto(Role.getId(), Role.getName()));
		}
		return dtos;
	}
	
	@Override
	public RoleDto findById(int id) {
		Role Role = roleRepository.findById(id).get();
		return new RoleDto(Role.getId(), Role.getName());
	}

	@Override
	public void add(RoleDto dto) {
		Role Role = new Role();
		Role.setId(dto.getId());
		Role.setName(dto.getName());
		
		roleRepository.save(Role);
	}

	@Override
	public void update(RoleDto dto) {
		Role Role = roleRepository.findById(dto.getId()).get();
		Role.setId(dto.getId());
		Role.setName(dto.getName());
	}

	@Override
	public void delete(int id) {
		roleRepository.deleteById(id);
	}

	@Override
	public List<RoleDto> search(String keyword) {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		List<Role> roles = roleRepository.search(keyword);
		for (Role Role : roles) {
			dtos.add(new RoleDto(Role.getId(), Role.getName()));
		}		
			return dtos;
	}
}
