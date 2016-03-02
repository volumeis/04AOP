package spring.service.aop.test;

import spring.service.aop.Message;
import spring.service.aop.proxy.MessageImplProxy;

/*
 * FileName : MessageTestAppUseProxy.java
 * 
 * ::Proxy ��ü�� �̿��Ͽ� Target Object �޼��带 ȣ��
 * 
 * ::Target Object �޼��� ȣ���ϴ� Proxy Bean ��  Hierarchy   
 *      Manager
 *          L ManagerImpl
 *                   L ManagerImplProxy class 
 *  
 * :: Proxy �� �̿��ϸ� Ÿ�ٰ�ü�� �޼��� ȣ��� ��/�� ó�� ����
 */
public class MessageTestAppUseProxy {
	
	///Main Method
	public static void main(String[] args) throws Exception {
		
		Message message = new MessageImplProxy();
		
		System.out.println("==============================");
		message.setMessage("Hello");
		System.out.println("==============================");
		String messageValue = message.getMessage();
		System.out.println("==============================");
	    
		System.out.println("\n���� ���� �޼��� : "+messageValue);
		
	}
}//end of class