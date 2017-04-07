package com.demo.jms.queue;

import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QueueSender {

	public static void main(String[] args) throws Exception {

		Context ctx = new InitialContext();
		QueueConnectionFactory qcf = (QueueConnectionFactory) ctx.lookup("queueConnectionFactory");
		Queue queue = (Queue) ctx.lookup("myQueue");

		QueueConnection conn = qcf.createQueueConnection();
		QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

		TextMessage message = session.createTextMessage();

		message.setText("Hi, I am new to JMS.."+System.currentTimeMillis());

		MessageProducer producer = session.createProducer(queue);

		producer.send(message);

		producer.close();
		session.close();
		conn.close();

	}

}
