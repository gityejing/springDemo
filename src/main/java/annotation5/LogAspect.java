package annotation5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect // ��ע���ʾ����Ϊ������
//@Component // ע������
public class LogAspect {

	// ��ע�÷�����Ϊ����֪ͨ����Ŀ�귽��ִ�гɹ���ִ�и÷�����
	@AfterReturning("within(com.abchina.irms..*) && @annotation(rl)")
	public void addLogSuccess(JoinPoint jp) {

	}

	// ��ע�÷�����Ϊ�쳣֪ͨ����Ŀ�귽�������쳣ʱ��ִ�и÷�����
	@AfterThrowing(pointcut = "within(com.abchina.irms..*) && @annotation(rl)", throwing = "ex")
	public void addLog(JoinPoint jp) {

	}
}