package annotation2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotation2.config.AppConfig;

public class AppMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("����������.������");// ��ʵ����bean�������Ĵ�ӡ�����֮ǰ����ʵ����bean���õ�ʱ��Ź���
//		context.getBean(Car.class);
		context.close();// �����رյ�ʱ�򣬾����ǹر�ǰ�������car�����ٷ��������Ƕ�ʵ��״̬�µ�ʱ��,�����رգ�Ҳ��������bean
		System.out.println("�����رա�����");
	}
}
