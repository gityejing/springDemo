spring 基于注解开发

@Configuration 主配置文件，相当于一个xml配置文件
@ComponentScan(value="annotation") 自动扫描基包，放在主配置类上，主要扫描如下注解的bean，@Component、@Repository、@Service、@Controller

@Bean 放在方法上，注解一个bean并放到容器中
@Scope("prototype") 单例和多例的配置
@Lazy 懒加载
@Conditional 有条件的放入到容器中，条件实现Condition接口，例如判断操作系统是windows还是linux，可以在配置运行参数 vm 参数。
@Import(Color.class) 导入组件到容器，适用于jar包中的bean或没有源代码的bean并且没有注解。
@Import(MyImportSelector.class) 也可以导入组件到容器中，MyImportSelector是自定义的选择器实现了ImportSelector接口，其有一个方法selectImports，返回值是bean的全类名数组。



