package annotation.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportSelector implements ImportSelector{

	/**
	 * ����ֵ����Ҫ���뵽�����е������ȫ����
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		String[] names = new String[] {"annotation.domain.Red"};
		return names;
	}

}
