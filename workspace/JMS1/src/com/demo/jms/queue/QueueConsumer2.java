package com.demo.jms.queue;

import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QueueConsumer2 {

	public static void main(String[] args) throws Exception {

		Context ctx = new InitialContext();
		QueueConnectionFactory qcf = (QueueConnectionFactory) ctx.lookup("queueConnectionFactory");
		Queue queue = (Queue) ctx.lookup("myQueue");

		QueueConnection conn = qcf.createQueueConnection();
		QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageConsumer consumer = session.createConsumer(queue);
		conn.start();
		ObjectMessage message = (ObjectMessage) consumer.receive();
		EmpBean emp = (EmpBean) message.getObject();
		System.out.println(emp.getDetails());
		conn.close();

	}

}
