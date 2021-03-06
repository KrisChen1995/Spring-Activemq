package com.chenfei.activemq.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Message;

@Service
public class SpringMQ_Consumer {

	@Autowired
	private JmsTemplate jmsTemplate;
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringMQ_Consumer consumer = (SpringMQ_Consumer) context.getBean("springMQ_Consumer");
		String  retVale = (String) consumer.jmsTemplate.receiveAndConvert();
		System.out.println("*******消费者收到的消息："+ retVale);
	}
}
