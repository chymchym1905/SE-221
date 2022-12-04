package com.uwc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwc.service.AnnouncementService;
import com.uwc.repository.AnnouncementRepository;
import com.uwc.entity.Announcement;
import com.uwc.dto.AnnouncementDto;




@Service
@Transactional(rollbackOn = Exception.class)
public class AnnoucementServiceImpl implements AnnouncementService {
	@Autowired
	private AnnouncementRepository AnnouncementRepository;
	
	@Override
	public List<AnnouncementDto> findAll() {
		List<AnnouncementDto> dtos = new ArrayList<AnnouncementDto>();
		
		List<Announcement> announcements = AnnouncementRepository.findAll();
		
		for (Announcement announcement : announcements) {
			dtos.add(new AnnouncementDto(announcement.getId(), announcement.getDate_time(), announcement.getDescription(), announcement.getUser_id() ));
		}
		return dtos;
	}
	
	@Override
	public AnnouncementDto findById(int id) {
		Announcement announcement = AnnouncementRepository.findById(id).get();
		return new AnnouncementDto(announcement.getId(), announcement.getDate_time(), announcement.getDescription(),announcement.getUser_id());
	}

	@Override
	public void add(AnnouncementDto dto) {
		Announcement announcement = new Announcement();
		announcement.setDate_time(dto.getDate_time());
		announcement.setDescription(dto.getDescription());
		announcement.setUser_id(dto.getUser_id());
		
		AnnouncementRepository.save(announcement);
	}

	@Override
	public void update(AnnouncementDto dto) {
		Announcement announcement = AnnouncementRepository.findById(dto.getId()).get();
		announcement.setDate_time(dto.getDate_time());
		announcement.setDescription(dto.getDescription());
		announcement.setUser_id(dto.getUser_id());
	}

	@Override
	public void delete(int id) {
		AnnouncementRepository.deleteById(id);
	}

	@Override
	public List<AnnouncementDto> search(String keyword) {
		List<AnnouncementDto> dtos = new ArrayList<AnnouncementDto>();
		List<Announcement> annoucements = AnnouncementRepository.search(keyword);
		for (Announcement Announcement : annoucements) {
			dtos.add(new AnnouncementDto(Announcement.getId(), Announcement.getDate_time(), Announcement.getDescription(),Announcement.getUser_id()));
		}		
			return dtos;
	}
}
