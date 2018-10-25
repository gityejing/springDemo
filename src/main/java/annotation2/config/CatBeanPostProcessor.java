package annotation2.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import annotation2.domain.Cat;

/**
 * ���ô�����
 * @author 30000133
 *
 */
public class CatBeanPostProcessor implements BeanPostProcessor,Ordered{

	/**
	 * 
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("cat")) {
			Cat cat = (Cat) bean;
			cat.setName("tom");
			System.out.println(cat);
			return cat;
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("cat")) {
			bean = null;
			System.out.println(" destory cat ");
		}
		return bean;
	}

	// Ĭ��ֵΪ0��ֵԽ��ִ��˳��Խ��
	@Override
	public int getOrder() {
		return 2;
	}

}
