package spring.service.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class TestAspectJ01 {

	public TestAspectJ01() {
		System.out.println("테스트어스펙제이 생성자");
	}
	
	@Pointcut("execution(* *.getMessage(..))")
	public void work(){
		System.out.println("work() point call......");
	}
	
	@Before("work()")
	public void before(JoinPoint joinPoint) throws Throwable {
		
		System.out.println("[before LOG]"+getClass()+".before() start......");
		System.out.println("[before LOG] targetObject call Method :"+ joinPoint.getTarget().getClass().getName());
		System.out.println("[before LOG] target Object method : " + joinPoint.getSignature().getName());
		if (joinPoint.getArgs().length != 0) {
			System.out.println("[before LOG] targetObject method 전달 argument :"+joinPoint.getArgs()[0]);
		}
			System.out.println("[before LOG]"+getClass()+".before() end......");
	}

	@AfterReturning(pointcut = "work()", returning="returnValue")
	public void afterReturning(JoinPoint joinPoint, Object returnValue) throws Throwable {
		
		System.out.println("[after LOG]"+getClass()+".afterReturning() start.....");
		System.out.println("[after LOG] targetObject call Method :"+joinPoint.getSignature().getName());
		System.out.println("[after LOG] 타겟 객체의 호출 후 return value :"+returnValue);
		System.out.println("[after LOG]"+getClass()+".afterReturning() end.....");
	}
	
	@Around("work()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("[Around before]"+getClass()+".invoke() start....");
		System.out.println("[before LOG] targetObject call Method :"+ joinPoint.getTarget().getClass().getName());
		System.out.println("[before LOG] target Object method : " + joinPoint.getSignature().getName());
		if (joinPoint.getArgs().length != 0) {
			System.out.println("[Around before] targetObject method 전달 argument: "
								+joinPoint.getArgs()[0]);
		}
		
		//==>targetObject Method call
		Object obj=joinPoint.proceed();
		
		System.out.println("[Around after] 타겟 객체의 호출후 return value :"+obj);
		System.out.println("[Around after]"+getClass()+".invoke() end.....");
		
		return obj;
	}
	
	//==>Target Object Method 호출 Exception 발생 : afterThrowing() Method 구현
	@AfterThrowing(pointcut="work()", throwing="throwable")
	public void afterThrowing(JoinPoint joinPoint, Throwable throwable){
		
		System.out.println("[exception]"+getClass()+".afterThrowing() start....");
		System.out.println("[before LOG] targetObject call Method :"+ joinPoint.getTarget().getClass().getName());
		System.out.println("[before LOG] target Object method : " + joinPoint.getSignature().getName());
		
		System.out.println("[exception] Exception 발생....");
		System.out.println("[exception] Exception Message :"+throwable.getMessage());
		System.out.println("[exception]"+getClass()+".afterThrowing() end....");
	}


}
