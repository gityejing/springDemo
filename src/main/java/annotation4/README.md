����л��໷��
1,-Dspring.profile.active=dev�������в���

2,ʹ�ô���ķ�ʽ
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();// �ղ����Ĺ��캯��
context.getEnvironment().setActiveProfiles("dev");// ���û���
context.register(AppConfig.class);// ע����������
context.refresh();// ˢ������

3,д�����ϣ�ֻ�е����ϵ����ú͵�ǰ����һ��ʱ���������õ�����Ż���Ч