package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JMSProducer {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"amq-spring-jms.xml");
		JmsTemplate jms = (JmsTemplate) ctx.getBean("jmsTemplate");
		jms.send("myQueue",new MessageCreator() {
			
			public Message createMessage(Session arg0) throws JMSException {
				TextMessage tm=arg0.createTextMessage();
				tm.setText("From Spring app");
				return tm;
			}
		});

		System.out.println("Message sent..");
	
	}

}
