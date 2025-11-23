package com.messagequeue.message_queue.model;

import java.time.LocalDateTime;

public class Message {

	private String id;
	private String body;
	private LocalDateTime createdAt;

	public Message() {

	}

	public Message(String id, String body) {
		this.id = id;
		this.body = body;
		this.createdAt = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public String getBody() {
		return body;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
