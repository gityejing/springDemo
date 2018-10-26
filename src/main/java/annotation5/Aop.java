package annotation5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // ���뵽IoC����
@Aspect // ָ����ǰ��Ϊ������
public class Aop {

	@Pointcut("execution(public int annotation5.TestService.*(..) )")
	public void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void begin() {
		System.out.println("ִ�з���ǰ��¼��־");
	}

	@After(value="pointcut()")
	public void divAfter() {
		System.out.println("����ִ��������");
	}
	
	@AfterReturning(value="pointcut()",returning="result")
	public void divReturn(Object result) {
		System.out.println("����ִ��������:"+result);
	}

	@AfterThrowing(value="pointcut()",throwing="exception")
	public void divAfterThrowing(Exception exception) {
		System.out.println("�׳��쳣��"+exception.getMessage());
	}
}