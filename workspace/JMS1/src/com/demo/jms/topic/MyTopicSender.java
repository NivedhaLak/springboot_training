package com.demo.jms.topic;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MyTopicSender {

	public static void main(String[] args) throws Exception {
		Context ctx = new InitialContext();
		TopicConnectionFactory tcf = (TopicConnectionFactory) ctx.lookup("topicConnectionFactory");
		Topic topic = (Topic) ctx.lookup("myTopic");

		TopicConnection conn = tcf.createTopicConnection();
		TopicSession session = conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

		TextMessage tm = (TextMessage) session.createTextMessage();
		tm.setText("Hi topic, message2");

		TopicPublisher publisher = session.createPublisher(topic);
		publisher.publish(tm);
		conn.close();
	}

}
