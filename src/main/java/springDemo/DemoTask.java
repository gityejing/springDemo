package springDemo;

import org.springframework.stereotype.Service;

@Service("demoTask")
public class DemoTask {
	public void myTestWork() {
		System.out.println("����һ����ʱ����");
	}
}
