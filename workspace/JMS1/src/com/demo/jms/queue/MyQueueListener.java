package com.demo.jms.queue;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyQueueListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage tm = (TextMessage) message;
			System.out.println(tm.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
