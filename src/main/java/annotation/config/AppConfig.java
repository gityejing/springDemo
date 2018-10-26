package annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import annotation.domain.BlueFactoryBean;
import annotation.domain.Color;
import annotation.domain.Persion;

@Profile("dev")
@Configuration
@ComponentScan(value="annotation")// 自动扫描bean，适用于我们自己写的bean，并且有注解
//@Import(Color.class) // 适用于导入别人写的或jar包中的bean
@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})// 也可以导入组件到容器中
public class AppConfig {

	@Bean // 适用于导入别人写的或jar包中的bean
	// 默认是单例模式，只会构造一次
	// 如果改成多例模式，会每次都构造一次，这里的构造发生在从容器中取出的时候
	@Scope("prototype")
	@Conditional({WinCondition.class})
	Persion persion() {
		return new Persion("123","TOM");
	}
	
	@Bean
	@Lazy
	@Conditional({LinuxCondition.class})
	Persion persion01() {
		return new Persion("122","bill");
	}
	
	@Bean
	BlueFactoryBean blueFactoryBean() {
		return new BlueFactoryBean();
	}
}
