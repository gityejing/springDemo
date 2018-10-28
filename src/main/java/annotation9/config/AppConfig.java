package annotation9.config;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement // ��������ע������������
@EnableJpaRepositories(basePackages = "{annotation9.dao}", repositoryImplementationPostfix = "Impl", transactionManagerRef = "transactionManager", entityManagerFactoryRef = "entityManagerFactory")
@ComponentScan("annotation9")
public class AppConfig {

	@Bean("dataSource")
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("881213");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	/**
	 * ������������������о�����������
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		String rootPath = getClass().getResource("/").getPath();
		File file = new File(rootPath + "/hibernate.cfg.properties");
		Properties hbtProperties = new Properties();
		try {
			hbtProperties.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan("annotation9.domain");
		localSessionFactoryBean.setHibernateProperties(hbtProperties);
		return localSessionFactoryBean;
	}

	@Bean
	SessionFactory sessionFactory() {
		return localSessionFactoryBean().getObject();
	}

	// jpa �������
	@Bean
	public HibernatePersistenceProvider hibernatePersistenceProvider() {
		HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
		return hibernatePersistenceProvider;
	}

	@Bean("entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPersistenceProvider(hibernatePersistenceProvider());
		bean.setPackagesToScan(new String[] { "annotation9.domain" });
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
		bean.setJpaVendorAdapter(hibernateJpaVendorAdapter);

		Map<String, Object> jpaProperties = new HashMap<String, Object>();
		jpaProperties.put("hibernate.query.substitutions", "true 1, false 0");
		jpaProperties.put("hibernate.default_batch_fetch_size", 16);
		jpaProperties.put("hibernate.max_fetch_depth", 2);
		jpaProperties.put("hibernate.generate_statistics", false);
		jpaProperties.put("hibernate.bytecode.use_reflection_optimizer", true);
		jpaProperties.put("hibernate.cache.use_query_cache", false);
		jpaProperties.put("hibernate.cache.use_second_level_cache", false);
		jpaProperties.put("hibernate.enable_lazy_load_no_trans", true);

		jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		bean.setJpaPropertyMap(jpaProperties);
		return bean;
	}

	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(localSessionFactoryBean().getObject());
		return hibernateTemplate;
	}

	@Bean("transactionManager")
	public JpaTransactionManager jpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager
				.setEntityManagerFactory(localContainerEntityManagerFactoryBean().getNativeEntityManagerFactory());
		return transactionManager;
	}
}
