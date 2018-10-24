package annotation2.config;

import org.springframework.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import annotation2.domain.Bus;
import annotation2.domain.Car;
import annotation2.domain.Cat;
import annotation2.domain.Dog;

@Configuration
@ComponentScan(value="annotation2")
@Import({Bus.class,Dog.class,Cat.class})
public class AppConfig {

	@Bean(initMethod="init",destroyMethod="destory")
	@Scope("prototype") // �ڴ�����ȡ����ʱ�򣬽��д����ͳ�ʼ�����������رյ�ʱ�򣬾����ǹر�ǰ�����������������ٷ���������һ������֮��
	public Car car() {
		return new Car();
	}
	
	@Bean
	public CatBeanPostProcessor catBeanPostProcessor() {
		return new CatBeanPostProcessor();
	}
	
	
}
