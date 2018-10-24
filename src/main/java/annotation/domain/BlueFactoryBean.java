package annotation.domain;

import org.springframework.beans.factory.FactoryBean;

public class BlueFactoryBean implements FactoryBean<Blue> {

	/**
	 * ����һ����������������ӵ�������
	 */
	@Override
	public Blue getObject() throws Exception {
		return new Blue();
	}

	/**
	 * ���ض��������
	 */
	@Override
	public Class<?> getObjectType() {
		return Blue.class;
	}

	/**
	 * ����ģʽ���Ƕ���ģʽ
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
