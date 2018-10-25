package annotation2.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Dog {

	public Dog() {
		super();
		System.out.println(" create dog");
	}
	
	// ��ʼ��֮�󣬲�����ָ����ע��֮�󣬵����������
	@PostConstruct
	public void init() {
		System.out.println(" init dog ");
	}
	
	// �����رգ������ǹر�ǰ�������������
	@PreDestroy
	public void destory() {
		System.out.println(" destory dog ");
	}
	
}
