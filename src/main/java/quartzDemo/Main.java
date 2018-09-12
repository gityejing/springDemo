package quartzDemo;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("spring-quartz.xml");
		
		try {
			// ����scheduler��������
			Scheduler scheduler = (Scheduler) app.getBean("MyScheduler");

			// ����һ��Trigger:������
			Trigger trigger = newTrigger().withIdentity("trigger1", "group1") // ����name/group
					.startNow()// һ������scheduler��������Ч
					.withSchedule(simpleSchedule() // ʹ��SimpleTrigger
							.withIntervalInSeconds(1) // ÿ��һ��ִ��һ��
							.repeatForever()) // һֱִ�У����ڵ��ϲ�ͣЪ
					.build();

			// ����һ��JobDetail�����������
			JobDetail job = newJob(CancelUnpaidOrderTask.class) // ����Job��ΪHelloQuartz�࣬����������ִ���߼�����
					.withIdentity("job1", "group1") // ����name/group
					.usingJobData("name", "quartz") // ��������
					.build();

			// �����������
			scheduler.scheduleJob(job, trigger);

			// ����֮
			scheduler.start();

			// ����һ��ʱ���ر�
//			Thread.sleep(10000);
//			scheduler.shutdown(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
