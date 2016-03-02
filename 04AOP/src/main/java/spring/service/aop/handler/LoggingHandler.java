package spring.service.aop.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * FileName : LoggingHandler.java
 *  :: �� / �� ó���� �߻�ȭ�� InvocationHandler �� ������ Bean
 *  :: InvocationHandler.invoke() O/R �Ͽ� ��/�� ó�� ����
 *  :: Proxy ��ü�� Target Object Method �� ȣ�� ��/��  Handler �� �̿� ��/�� ó��
 */
public class LoggingHandler implements InvocationHandler {
	
	///Field
	//==> Ÿ�ٰ�ü ���� 
	private Object targetObject;
	
	///Constructor
	public LoggingHandler(){
	}
	public LoggingHandler(Object tagetObject) {
		this.targetObject = tagetObject;
	}
	
	// :: invoke() Method O/R  : Target Object �޼��� ȣ�� ��/��ó�� �� ���� ���� (API Ȯ��)
	public Object invoke(Object proxy, Method method, Object[] args) 
																								throws Throwable {
		System.out.println("\n=====================================");
		System.out.println("[LOG] "+getClass()+".invoke() start.....");
		System.out.println("[LOG] Target Object ȣ�� �� method :"+method);
		if(args != null){
			System.out.println("[LOG] Target Object ȣ�� �� method�� ���޵Ǵ� ���� : "+args[0]);
		}
		
		try {
			//==> Ÿ�� ��ü�� Method �� ȣ�� �ϴ� �κ� 
			return method.invoke(targetObject, args);
		} catch (Exception e) {
			throw e;
		}finally{
			System.out.println("[LOG] "+getClass()+".invoke() end.....");
			System.out.println("=====================================\n");
		}
	}
}//end of class