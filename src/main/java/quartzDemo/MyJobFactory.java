package quartzDemo;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;

public class MyJobFactory extends AdaptableJobFactory{
	//�������Spring��������Զ�ע�����,Ҳ����Spring��������.
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;
    
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //���ø���ķ���
        Object jobInstance = super.createJobInstance(bundle);
        //����ע��,������Spring�ļ���,������Ŀ��Բ鿴Spring��API.
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
