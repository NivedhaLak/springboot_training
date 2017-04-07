package com.demo.jms.queue;

import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QueueConsumer {

	public static void main(String[] args) throws Exception {

		Context ctx = new InitialContext();
		QueueConnectionFactory qcf = (QueueConnectionFactory) ctx.lookup("queueConnectionFactory");
		Queue queue = (Queue) ctx.lookup("myQueue");

		QueueConnection conn = qcf.createQueueConnection();
		QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageConsumer consumer = session.createConsumer(queue);
		// consumer.setMessageListener(new MyQueueListener());

		conn.start();
		TextMessage msg = (TextMessage) consumer.receive();
		System.out.println(msg.getText());
		conn.close();

	}

}
