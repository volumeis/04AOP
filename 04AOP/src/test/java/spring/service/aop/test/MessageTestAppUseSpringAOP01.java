package spring.service.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.aop.Message;

public class MessageTestAppUseSpringAOP01 {
	public static void main(String[] args) throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/messageservice01.xml");
		
		Message message = (Message) context.getBean("message");
		
		message.setMessage("heelo");
		
		System.out.println("���� ���� : "+message.getMessage());
	}
}
