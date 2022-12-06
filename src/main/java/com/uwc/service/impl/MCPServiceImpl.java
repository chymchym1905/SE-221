package com.uwc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwc.dto.MCPDto;
import com.uwc.entity.MCP;
import com.uwc.repository.McpRepository;
import com.uwc.service.MCPService;

@Service
@Transactional(rollbackOn = Exception.class)
public class MCPServiceImpl implements MCPService{
	@Autowired
	private McpRepository MCPRepository;
	
	@Override
	public List<MCPDto> findAll() {
		List<MCPDto> dtos = new ArrayList<MCPDto>();
		
		List<MCP> MCPs = MCPRepository.findAll();
		
		for (MCP MCP : MCPs) {
			dtos.add(new MCPDto(MCP.getId(), MCP.getFullness(), MCP.getLatitude(), MCP.getLongitude() ));
		}
		return dtos;
	}
	
	@Override
	public MCPDto findById(int id) {
		MCP MCP = MCPRepository.findById(id).get();
		return new MCPDto(MCP.getId(), MCP.getFullness(), MCP.getLatitude(), MCP.getLongitude());
	}

	@Override
	public void add(MCPDto dto) {
		MCP MCP = new MCP();
		MCP.setFullness(dto.getFullness());
		MCP.setLatitude(dto.getLatitude());
		MCP.setLongitude(dto.getLongitude());
		MCPRepository.save(MCP);
	}

	@Override
	public void update(MCPDto dto) {
		MCP MCP = MCPRepository.findById(dto.getId()).get();
		MCP.setFullness(dto.getFullness());
		MCP.setLatitude(dto.getLatitude());
		MCP.setLongitude(dto.getLongitude());
	}

	@Override
	public void delete(int id) {
		MCPRepository.deleteById(id);
	}

	@Override
	public List<MCPDto> search(String keyword) {
		List<MCPDto> dtos = new ArrayList<MCPDto>();
		List<MCP> MCPs = MCPRepository.search(keyword);
		for (MCP MCP : MCPs) {
			dtos.add(new MCPDto(MCP.getId(), MCP.getFullness(), MCP.getLatitude(), MCP.getLongitude()));
		}		
			return dtos;
	}
}

