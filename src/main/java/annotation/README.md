spring ����ע�⿪��

@Configuration �������ļ����൱��һ��xml�����ļ�
@ComponentScan(value="annotation") �Զ�ɨ��������������������ϣ�
��Ҫɨ������ע���bean��@Component��@Repository��@Service��@Controller
@Bean ���ڷ����ϣ�ע��һ��bean���ŵ�������
@Scope("prototype") �����Ͷ���������
@Lazy ������
@Conditional �������ķ��뵽�����У�����ʵ��Condition�ӿڣ������жϲ���ϵͳ��windows����linux���������������в��� vm ������
@Import(Color.class) ���������������������jar���е�bean��û��Դ�����bean����û��ע�⡣
@Import(MyImportSelector.class) Ҳ���Ե�������������У�MyImportSelector���Զ����ѡ����ʵ����ImportSelector�ӿڣ�����һ������selectImports������ֵ��bean��ȫ�������顣
@Import(MyImportBeanDefinitionRegistrar.class) ����һ���Զ���ע��bean�ķ�����Ҳ��ʵ��һ���ӿ�ImportBeanDefinitionRegistrar
������ͬʱʹ�ò�ͬ�ķ�ʽ������
@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})

ʹ��FactoryBeanҲ�����������������������ַ�ʽ���������������spring�������ϵĳ����¡�
����������Ƕ����Լ���factorybeanʵ��FactoryBean�ӿڣ�Ȼ��ͨ��@Beanע�⽫�Զ����FactoryBean�ŵ������С�

@Autowired ����ע��
@Resource ����ע�룬�Ƽ�ʹ��������������@Autowired
@Qualifier ����bean��id
@PostConstruct bean��ʼ��������ע������
@PreDestroy �������رգ��������������ر�ǰ����

@PropertySource(value = {"jdbc.properties","classpath:common.properties", "classpath:abc.properties"},
encoding="UTF-8",ignoreResourceNotFound=true)
������ȡ�ⲿ�������ļ�

@Value("${destinationLocation}")������ȡ�����ļ��еļ�ֵ

@Autowired ��������ע�룬 
@Resource Ĭ�ϸ�������ע�룬��ΰ�����������
@Autowired @Qualifie("userService") ��������������Ը������ֺ�����ע��
1�����ڲ���λ��
2�����ڷ�����
3�����ڹ�������

@Primary ע���ʵ������������ʵ����ע��

@Transactional ���������ڽӿڡ��ӿڷ��������Լ��෽���ϡ��Ƽ����������ķ����ϡ�







