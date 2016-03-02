package spring.service.aop.test;

import spring.service.aop.Message;
import spring.service.aop.impl.MessageImpl;
import spring.service.aop.proxy.MessageImplProxy;

/*
 * FileName : MessageTestApp.java
 * ::Message / MessageImpl �� ����ϴ� Application
 */
public class MessageTestApp {

	///Main
	public static void  main(String[] args) throws Exception {
		
		Message message = new MessageImpl();
//		Message message = new MessageImplProxy();
		
		System.out.println("==============================");
		message.setMessage("Hello");
		System.out.println("==============================");
		String messageValue = message.getMessage();
		System.out.println("==============================");
	    
		System.out.println("\n���� ���� �޼��� : "+messageValue);
	    
	}
}//end of class

/* 	
 * [����� ����]
 * :: Method ���� �� ���𰡸� �ϰ� �ʹٸ�...
 * :: Method ���� �� ���𰡸� �ϰ� �ʹٸ�...
 */