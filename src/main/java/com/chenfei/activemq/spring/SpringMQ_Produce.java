package com.chenfei.activemq.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

@Service
public class SpringMQ_Produce {

	@Autowired
	private JmsTemplate jmsTemplate;
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringMQ_Produce produce = (SpringMQ_Produce) context.getBean("springMQ_Produce");

		produce.jmsTemplate.send((session -> {
			TextMessage textMessage = session.createTextMessage("******spring和activemq的整合");
			return textMessage;
		}));
		System.out.println("发送成功");
	}
}
