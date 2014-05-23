package com.wata.battleships;

import java.util.LinkedList;
import java.util.Queue;

public class BaseLogic implements Runnable
{
	Thread processor;
	public BaseLogic()
	{
		processor = new Thread(this);
		processor.start();
	}
	
	public void Send(Message message)
	{
		synchronized (messages) {
			messages.add(message);
			messages.notify();
		}
	}

	Queue<Message> messages = new LinkedList<Message>();

	@Override
	public void run() {
		while (true) {
			while (messages.isEmpty()) {
				synchronized (messages) {
					try {
						messages.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			Message message = null;
			synchronized (messages) {
				message = messages.poll();
			}
			Process(message);
			message.Handle();
		}
	}
	
	void Process(Message message)
	{
		
	}
}