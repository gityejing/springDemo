package annotation5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect // 该注解标示该类为切面类
//@Component // 注入依赖
public class LogAspect {

	// 标注该方法体为后置通知，当目标方法执行成功后执行该方法体
	@AfterReturning("within(com.abchina.irms..*) && @annotation(rl)")
	public void addLogSuccess(JoinPoint jp) {

	}

	// 标注该方法体为异常通知，当目标方法出现异常时，执行该方法体
	@AfterThrowing(pointcut = "within(com.abchina.irms..*) && @annotation(rl)", throwing = "ex")
	public void addLog(JoinPoint jp) {

	}
}