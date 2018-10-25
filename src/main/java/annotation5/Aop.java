package annotation5;

import org.aspectj.lang.annotation.After;
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

	@After("pointcut()")
	public void close() {
		System.out.println("����ִ��������");
	}

}