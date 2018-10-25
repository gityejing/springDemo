package annotation5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // 加入到IoC容器
@Aspect // 指定当前类为切面类
public class Aop {

	// 指定切入点表达式，拦截那些方法，即为那些类生成代理对象
	// @Pointcut("execution(* com.bie.aop.UserDao.save(..))") ..代表所有参数
	// @Pointcut("execution(* com.bie.aop.UserDao.*())") 指定所有的方法
	// @Pointcut("execution(* com.bie.aop.UserDao.save())") 指定save方法
	@Pointcut("execution(* annotation5.TestService.*())")
	public void pointCut() {

	}

	@Before("pointCut()")
	public void begin() {
		System.out.println("执行方法前记录日志");
	}

	@After("pointCut()")
	public void close() {
		System.out.println("方法执行完后调用");
	}

}