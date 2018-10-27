package annotation7.config;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement // 开启基于注解的事务管理功能
@ComponentScan("annotation7")
public class AppConfig {

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("881213");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		return dataSource;
	}

	/**
	 * 配置事务管理器，进行具体的事务管理
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() throws PropertyVetoException, FileNotFoundException, IOException {
		String rootPath = getClass().getResource("/").getPath();
		File file = new File(rootPath+"/hibernate.cfg.properties");
		Properties hbtProperties = new Properties();
		hbtProperties.load(new FileInputStream(file));
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan("annotation7.domain");
		localSessionFactoryBean.setHibernateProperties(hbtProperties);
		return localSessionFactoryBean;
	}
	
	
	@Bean
	public SessionFactory sessionFactory() throws FileNotFoundException, PropertyVetoException, IOException {
		return localSessionFactoryBean().getObject();
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate() throws FileNotFoundException, PropertyVetoException, IOException {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionFactory());
		return hibernateTemplate;
	}
	
	@Bean
	public PlatformTransactionManager platformTransactionManager() throws FileNotFoundException, PropertyVetoException, IOException {
		PlatformTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory());
		return transactionManager;
	}
}
