package com.demo.jms.topic;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TopicSubscriber1 {

	public static void main(String[] args) throws Exception {
		Context ctx = new InitialContext();
		TopicConnectionFactory tcf = (TopicConnectionFactory) ctx.lookup("topicConnectionFactory");
		Topic topic = (Topic) ctx.lookup("myTopic");

		TopicConnection conn = tcf.createTopicConnection();
		TopicSession session = conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

		TopicSubscriber subscriber=session.createSubscriber(topic);
		conn.start();
		TextMessage message=(TextMessage)subscriber.receive();
		System.out.println(message.getText());
		conn.close();
	}

}
