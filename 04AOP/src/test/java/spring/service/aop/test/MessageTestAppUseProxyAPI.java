package spring.service.aop.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import spring.service.aop.Message;
import spring.service.aop.handler.LoggingHandler;
import spring.service.aop.impl.MessageImpl;

/*
 * FileName : MessageTestAppUseProxyAPI.java
 * :: 	Proxy Bean ��  �����ڰ� ���� ���� �ʰ� 
 * 		java.lang.reflect.Proxy API ��� �����ִ� Proxy instance  ��� 
 * :: 	����� java.lang.reflect.Proxy ������ ����� ���� Proxy::Dynamic Proxy
 * 		�Ʒ��� Hierarchy �� ���´�.  
 *      Message
 *        L MessageImpl
 *            L Dynamic Proxy
 * 
 *	:: ���� ���� Hierarchy �� ���� Dynamic Proxy �� ����� ����..
 *  -  �ϳ� : interface == > Message 
 *  -  �ο� :  TargetObjcet ==>  MessageImpl
 *  -  ���� : ��,�� ó�� ���� ������ ���� InvocationHandler�� ������ Bean
 *     3���� ������ �� �ʿ�
 */
public class MessageTestAppUseProxyAPI {
	
	///Main Method
	public static void main(String[] args) throws Exception {
		
		System.out.println("::LoggingHandler�� ��� Method ȣ�� ��,�ĸ�  log ���");
		
		//==>1. InvocationHandler��ü�� ������ Handler ��ü�� Target Object ����(?) 
		LoggingHandler logHandler = new LoggingHandler(new MessageImpl());
		
		//==>2. Proxy.newProxyInsanc() �� �̿� Dynamic Proxy ���� 
		//==> java.lang.reflect.Proxy API ����
		Message  messageProxy 
			= (Message)Proxy.newProxyInstance	(	MessageImpl.class.getClassLoader(),
																					new Class[]{ Message.class}, 
																					logHandler	);
			   
		//==>3. Dynamic Proxy �� ���� Ÿ�ٰ�ü �޼��� ȣ�� ::  ��� ����� Ȯ��
		messageProxy.setMessage("Hello");
		
		System.out.println("\n���� ���� �޼��� : "+messageProxy.getMessage());
	}
}//end of class