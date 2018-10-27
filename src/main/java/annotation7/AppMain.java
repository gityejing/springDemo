package annotation7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotation7.conf.AppConfig;
import annotation7.service.PersionService;

public class AppMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(AppConfig.class);
		
		PersionService persionService = context.getBean(PersionService.class);
		persionService.clear();
		persionService.insert();
		
	}
}
