package annotation2.util;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * �Ծ�̬��������Spring ApplicationContext, 
 * �����κδ����κεط��κ�ʱ��ȡ��ApplicaitonContext.
 * @author 30000133
 *
 */
@Component
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware,DisposableBean  {
	
	private static ApplicationContext applicationContext = null;
 
	/**
	 * ��ȡ��̬�����е�ApplicationContext.
	 */
	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}
 
	/**
	 * �Ӿ�̬����applicationContext�еõ�Bean, �Զ�ת��Ϊ����ֵ���������.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		assertContextInjected();
		return (T) applicationContext.getBean(name);
	}
 
	/**
	 * �Ӿ�̬����applicationContext�еõ�Bean, �Զ�ת��Ϊ����ֵ���������.
	 */
	public static <T> T getBean(Class<T> requiredType) {
		assertContextInjected();
		return applicationContext.getBean(requiredType);
	}
 
	/**
	 * ���SpringContextHolder�е�ApplicationContextΪNull.
	 */
	public static void clearHolder() {
		applicationContext = null;
	}
 
	/**
	 * ʵ��ApplicationContextAware�ӿ�, ע��Context����̬������.
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;
	}
 
	/**
	 * ���ApplicationContext��Ϊ��.
	 */
	private static void assertContextInjected() {
		Validate.validState(applicationContext != null,
				"applicaitonContext����δע��, ����applicationContext.xml�ж���SpringContextHolder.");
	}

	@Override
	public void destroy() throws Exception {
		SpringContextHolder.clearHolder();
	}
 
}
