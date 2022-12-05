package com.uwc.dto;

import java.time.LocalDateTime;

public class EventDto {
	
	private Long id;
	private String text;
	private LocalDateTime start;
	private LocalDateTime end;
	private String color;
	
	public EventDto() {}
	
	public EventDto(String text, LocalDateTime start, LocalDateTime end, String color) {
		super();
		this.text = text;
		this.start = start;
		this.end = end;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public String getColor() { return color; }

	public void setColor(String color) { this.color = color; }
}
