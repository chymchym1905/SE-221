package com.uwc.service;

import java.util.List;

import com.uwc.dto.EventDto;

public interface EventService {
	List<EventDto> findAll();
	EventDto findById(int id);
	void add(EventDto dto);
	void update(EventDto dto);
	void delete(int id);
	public List<EventDto> search(String keyword);
}
