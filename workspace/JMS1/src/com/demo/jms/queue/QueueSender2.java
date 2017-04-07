package com.demo.jms.queue;

import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QueueSender2 {

	public static void main(String[] args) throws Exception {

		Context ctx = new InitialContext();
		QueueConnectionFactory qcf = (QueueConnectionFactory) ctx.lookup("queueConnectionFactory");
		Queue queue = (Queue) ctx.lookup("myQueue");

		QueueConnection conn = qcf.createQueueConnection();
		QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

		EmpBean emp= new EmpBean();
		emp.setEmpId("100");
		emp.setName("Tarak");
		emp.setSalary("50000");
		
		ObjectMessage message=session.createObjectMessage(emp);
		MessageProducer producer = session.createProducer(queue);

		producer.send(message);

		producer.close();
		session.close();
		conn.close();

	}

}
