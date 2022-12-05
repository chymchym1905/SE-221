package com.uwc.dto;

import com.uwc.util.StringUtils;

public class ChatMessage {
    private String from;
    private String text;
    private String recipient;
    private String time;

	public ChatMessage() {}

    public ChatMessage(String from, String text, String recipient) {
        this.from = from;
        this.text = text;
        this.recipient = recipient;
        this.time = StringUtils.getCurrentTimeStamp();
    }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFrom() {
		return from;
	}
	
	 public String getRecipient() {
			return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
