package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotation.config.AppConfig;
import annotation.domain.Persion;
import annotation.service.HelloService;

public class AppMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloService hs = context.getBean(HelloService.class);
		System.out.println(hs.say());
		
		// ��������ȡ����ʱ�򣬻����persion�Ĺ��죬���ʱ�����Ͷ����Ϳ�ʼ������
//		Persion p = context.getBean(Persion.class);
//		System.out.println(p);
//		
//		p = context.getBean(Persion.class);
//		System.out.println(p);
		
		// ͨ�����������������vm����������   -Dos.name=Linux
		// ����������linuxϵͳ����������ô�ͻ�������ֻ����persion01
		String[] names = context.getBeanNamesForType(Persion.class);
		for (String name : names) {
//			System.out.println(name);
		}
		
		names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		// Ĭ�ϻ�ȡ�����ǹ���bean�����Ķ���
		// �����Ҫ��ȡ����bean������Ҫ��id��һ��ǰ׺��"&blueFactoryBean"
		Object object =  context.getBean("blueFactoryBean");
		System.out.println(object.getClass().getTypeName());
	}
}
