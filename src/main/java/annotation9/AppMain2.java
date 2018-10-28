package annotation9;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotation9.config.AppConfig;
import annotation9.service.PersionService;

public class AppMain2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(AppConfig.class);
		PersionService persionService = context.getBean(PersionService.class);
//		persionService.save();
//		persionService.findPersionsLike("���n");
//		persionService.countPersions();
//		persionService.updateNameById(2L, "Һ��");
//		persionService.findPersionsLike("���n");
		persionService.findAllByPage(1, 3);
		context.close();
	}
}
