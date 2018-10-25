package annotation5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // 加入到IoC容器
@Aspect // 指定当前类为切面类
public class Aop {

	@Pointcut("execution(public int annotation5.TestService.*(..) )")
	public void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void begin() {
		System.out.println("执行方法前记录日志");
	}

	@After("pointcut()")
	public void close() {
		System.out.println("方法执行完后调用");
	}

}