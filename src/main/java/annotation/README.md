spring 基于注解开发

@Configuration 主配置文件，相当于一个xml配置文件
@ComponentScan(value="annotation") 自动扫描基包，放在主配置类上，
主要扫描如下注解的bean，@Component、@Repository、@Service、@Controller
@Bean 放在方法上，注解一个bean并放到容器中
@Scope("prototype") 单例和多例的配置
@Lazy 懒加载
@Conditional 有条件的放入到容器中，条件实现Condition接口，例如判断操作系统是windows还是linux，可以在配置运行参数 vm 参数。
@Import(Color.class) 导入组件到容器，适用于jar包中的bean或没有源代码的bean并且没有注解。
@Import(MyImportSelector.class) 也可以导入组件到容器中，MyImportSelector是自定义的选择器实现了ImportSelector接口，其有一个方法selectImports，返回值是bean的全类名数组。
@Import(MyImportBeanDefinitionRegistrar.class) 又是一种自定义注入bean的方法，也是实现一个接口ImportBeanDefinitionRegistrar
还可以同时使用不同的方式，如下
@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})

使用FactoryBean也可以像容器中添加组件，这种方式常用在其他框架于spring进行整合的场景下。
具体的做法是定义自己的factorybean实现FactoryBean接口，然后通过@Bean注解将自定义的FactoryBean放到容器中。

@Autowired 依赖注入
@Resource 依赖注入，推荐使用这个代替上面的@Autowired
@Qualifier 定义bean的id
@PostConstruct bean初始化和依赖注入后调用
@PreDestroy 在容器关闭，并且是在容器关闭前调用

@






