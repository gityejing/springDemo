package annotation5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//�����Զ�������Ҫ��һ�������û���ע������湦�ܣ�û����һ�����ã�������������ȶ��޷������á�
@EnableAspectJAutoProxy 
@Configuration
@ComponentScan("annotation5")
public class AppConfig {
	
}
