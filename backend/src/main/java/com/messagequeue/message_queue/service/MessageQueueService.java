package com.messagequeue.message_queue.service;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import com.messagequeue.message_queue.model.Message;

@Service
public class MessageQueueService {
	private final Queue<Message> queue = new ConcurrentLinkedQueue<>();

	public void send(String body) {
		Message message = new Message(UUID.randomUUID().toString(), body);
		queue.add(message);
	}

	public Message poll() {
		return queue.poll();
	}

	public Message peek() {
		return queue.peek();
	}

	public int size() {
		return queue.size();
	}
}
