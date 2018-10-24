package annotation.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportSelector implements ImportSelector{

	/**
	 * 返回值就是要导入到容器中的组件的全类名
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		String[] names = new String[] {"annotation.domain.Red"};
		return names;
	}

}
