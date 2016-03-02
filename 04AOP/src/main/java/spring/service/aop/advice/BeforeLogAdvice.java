package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("=====================");
		System.out.println("[before log]"+getClass()+".before() start...");
		System.out.println("[before log] targetObject call method : "+method);
		if(args.length!=0){
			System.out.println("[before log] targetObject method parameter : "+args[0]);
		}
		System.out.println("[before log]"+target.getClass()+".before() end...");
	}

}
