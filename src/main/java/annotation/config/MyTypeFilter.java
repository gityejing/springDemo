package annotation.config;

import java.io.IOException;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 *  
 * @author 30000133
 *  �Զ���İ�ɨ����Ĺ���
 */
public class MyTypeFilter implements TypeFilter{

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		String name = metadataReader.getClassMetadata().getClassName();
		if (name.contains("er")) {
			return true;
		}
		return false;
	}

}
