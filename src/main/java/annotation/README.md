spring ����ע�⿪��

@Configuration �������ļ����൱��һ��xml�����ļ�
@ComponentScan(value="annotation") �Զ�ɨ��������������������ϣ���Ҫɨ������ע���bean��@Component��@Repository��@Service��@Controller

@Bean ���ڷ����ϣ�ע��һ��bean���ŵ�������
@Scope("prototype") �����Ͷ���������
@Lazy ������
@Conditional �������ķ��뵽�����У�����ʵ��Condition�ӿڣ������жϲ���ϵͳ��windows����linux���������������в��� vm ������
@Import(Color.class) ���������������������jar���е�bean��û��Դ�����bean����û��ע�⡣
@Import(MyImportSelector.class) Ҳ���Ե�������������У�MyImportSelector���Զ����ѡ����ʵ����ImportSelector�ӿڣ�����һ������selectImports������ֵ��bean��ȫ�������顣



