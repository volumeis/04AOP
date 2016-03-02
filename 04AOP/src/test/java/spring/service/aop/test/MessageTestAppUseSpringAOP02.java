package spring.service.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.aop.Message;

/*
 * FileName : MessageTestAppUseSpringAOP02.java
*/
public class MessageTestAppUseSpringAOP02 {
	
	///Main Method
	public static void main(String[] args) throws Exception{

		ApplicationContext context = 
		//		new ClassPathXmlApplicationContext("/config/messageservice02.xml");
		//		new ClassPathXmlApplicationContext("/config/messageservice03.xml");
		//		new ClassPathXmlApplicationContext("/config/messageservice04.xml");
		//		new ClassPathXmlApplicationContext("/config/messageservice05.xml");
		//		new ClassPathXmlApplicationContext("/config/messageservice06.xml");
				new ClassPathXmlApplicationContext("/config/messageservice07.xml");			
		//		new ClassPathXmlApplicationContext("/config/messageservice08.xml");
				
		//==> IoC Container �� ���� Look Up �� �ν��Ͻ��� ProxyFactoryBean ��ü�� �������� 
		//==> Message interface ������ Dynamic Proxy
		Message message = (Message)context.getBean("message");

		//==> ������
		//::1. ���� : String ����
	    message.setMessage("Hello");
	    //::2. ���� : null ���� : ThrowsAdvice ����Ȯ��
		//message.setMessage(null);
	    
	    System.out.println("\n\n+++++++++++++++++++++++++++++++++++++++++++++\n\n");
		
	    System.out.println("\n���� ���� �޼��� : "+message.getMessage());
	}
}//end of class------