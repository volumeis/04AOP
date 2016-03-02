package spring.service.aop.proxy;

import spring.service.aop.impl.MessageImpl;

/*
 * FileName : MessageImplProxy.java
 * ::ManagerImpl.getMesage() ȣ�⸦	�븮�ϴ�  Proxy ��ü 
 */
public class MessageImplProxy extends MessageImpl {
	
	///Field
	
	///Constructor
	public MessageImplProxy() {
	}

	///Method
	public String getMessage() throws Exception {

		System.out.println("\nProxy :: "+getClass()+".getMessage() start... ");

		//==> :: Target Object : ���������� ȣ��Ǵ� Method �� ���� Object
		//==> :: Target Object �� ȣ���� Proxy �� ���� ȣ�� ������ Proxy �� ȣ�� ��,�� ��/��ó�� ����.
		//==> �� ���ܰ� �߻��Ѵٸ� ó��
		//==> �� ���޵Ǵ� ���� ����
		//==> �� return �Ǵ� ���� ���� Proxy ��ü�� ���ؼ� �����ϴ�.
		String result = super.getMessage();
		
		System.out.println("Proxy :: "+getClass()+".getMessage() end...\n ");
		
		return result;
	}

}//end of class