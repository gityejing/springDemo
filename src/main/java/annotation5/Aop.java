package annotation5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // ���뵽IoC����
@Aspect // ָ����ǰ��Ϊ������
public class Aop {

	// ָ���������ʽ��������Щ��������Ϊ��Щ�����ɴ������
	// @Pointcut("execution(* com.bie.aop.UserDao.save(..))") ..�������в���
	// @Pointcut("execution(* com.bie.aop.UserDao.*())") ָ�����еķ���
	// @Pointcut("execution(* com.bie.aop.UserDao.save())") ָ��save����
	@Pointcut("execution(* annotation5.TestService.*())")
	public void pointCut() {

	}

	@Before("pointCut()")
	public void begin() {
		System.out.println("ִ�з���ǰ��¼��־");
	}

	@After("pointCut()")
	public void close() {
		System.out.println("����ִ��������");
	}

}