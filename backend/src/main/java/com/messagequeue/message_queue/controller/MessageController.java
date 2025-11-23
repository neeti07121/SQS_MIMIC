package com.messagequeue.message_queue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.messagequeue.message_queue.model.Message;
import com.messagequeue.message_queue.service.MessageQueueService;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "*")
public class MessageController {

	private final MessageQueueService service;

	public MessageController(MessageQueueService service) {
		this.service = service;
	}

	@PostMapping("/send")
	public String send(@RequestBody String body) {
		service.send(body);
		return "Message queued: " + body;
	}

	@GetMapping("/poll")
	public Message poll() {
		Message msg = service.poll();
		if (msg == null)
			return new Message("none", "No messages");
		return msg;
	}

	@GetMapping("/peek")
	public Message peek() {
		Message msg = service.peek();
		if (msg == null)
			return new Message("none", "No messages");
		return msg;
	}

	@GetMapping("/size")
	public int size() {
		return service.size();
	}
}
