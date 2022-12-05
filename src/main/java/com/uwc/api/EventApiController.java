package com.uwc.api;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.uwc.dto.EventDto;
import com.uwc.entity.Event;
import com.uwc.repository.EventRepository;
import com.uwc.service.EventService;

@RestController
public class EventApiController {
	 @Autowired
	 private EventService eventService;
	 
	 @GetMapping("/api/events")
	 @JsonSerialize(using = LocalDateTimeSerializer.class)
	 	Iterable<EventDto> events(@RequestParam("start") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime start, @RequestParam("end") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime end) {
		 return eventService.findBetween(start, end);
	 }

	 @PostMapping("/api/events/create")
	 @JsonSerialize(using = LocalDateTimeSerializer.class)
	 @Transactional
	 public Event createEvent(@RequestBody EventCreateParams params) {

		 Event event = new Event();
		 
		 event.setStart(params.start);
		 event.setEnd(params.end);
		 event.setText(params.text);

		 eventService.;
	    return event;
	 }

	 @PostMapping("/api/events/move")
	 @JsonSerialize(using = LocalDateTimeSerializer.class)
	 @Transactional
	 public Event moveEvent(@RequestBody EventMoveParams params) {

		 Event event = eventRepository.findById(params.id).get();
	
		 event.setStart(params.start);
		 event.setEnd(params.end);
	
		 eventRepository.save(event);
	
		 return event;
	 }

	 @PostMapping("/api/events/setColor")
	 @JsonSerialize(using = LocalDateTimeSerializer.class)
	 @Transactional
	 public Event setColor(@RequestBody SetColorParams params) {

		 Event event = eventRepository.findById(params.id).get();
	     event.setColor(params.color);
	     
	     eventRepository.save(event);

	     return event;
	 }

	 public static class EventCreateParams {
	     public LocalDateTime start;
	     public LocalDateTime end;
	     public String text;
	     public Long resource;
	 }

	 public static class EventMoveParams {
	     public Long id;
	     public LocalDateTime start;
	     public LocalDateTime end;
	     public Long resource;
	 }

	 public static class SetColorParams {
	     public Long id;
	     public String color;
	 }
 
}*/
