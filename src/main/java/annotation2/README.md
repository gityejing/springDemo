spring bean����������

bean ���������ڣ�����--��ʼ��--���٣����������й���
���ǿ����Զ��巽�������г�ʼ��������
1,ָ����ʼ�������ٷ���

2��InitializingBean��DisposableBean�ӿ�
���Bean����ʵ��org.springframework.beans.factory.InitializingBean�ӿڣ���ִ������afterProPertiesSet()����
�������ر�ʱ�����Bean����ʵ��org.springframework.beans.factory.DisposableBean�ӿڣ���ִ������destroy()������������Ե�ʵ����bean������

3,JSR-250���������ע��@PostConstruct��@PreDestroy
�ڷ����ϼ���ע��@PostConstruct����������ͻ���Bean��ʼ��֮��Spring����ִ�У�ע��Bean��ʼ��������ʵ����Bean����װ��Bean�����ԣ�����ע�룩ʹ��@Autowired��@Resourceע�⣨�Ƽ���@Resource������
�ڷ����ϼ���ע��@PreDestroy����������ͻ���Bean��ʼ��֮��Spring����ִ�С��������ǵ�ǰ��û����Ҫ�õ����ĳ��������ﲻȥ��ʾ�����÷�ͬ@PostConstruct��

4��BeanPostProcessor�ӿ�
�����������Spring���������beanʵ�����������Լ�������ʼ������ǰ��Ҫ���һЩ�Լ��߼�����������Ҫ����һ������BeanPostProcessor�ӿ�ʵ���࣬Ȼ��ע�ᵽSpring IoC������