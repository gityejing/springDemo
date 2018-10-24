package annotation2.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

import annotation2.domain.Cat;

public class CatBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("annotation2.domain.Cat")) {
			Cat cat = (Cat) bean;
			cat.setName("tom");
			System.out.println(cat);
			return cat;
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("annotation2.domain.Cat")) {
			bean = null;
			System.out.println(" destory cat ");
		}
		return bean;
	}

}
