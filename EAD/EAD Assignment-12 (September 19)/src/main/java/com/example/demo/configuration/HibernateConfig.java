package com.example.demo.configuration;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@PropertySource(value = { "classpath:application.properties" })
@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	@Autowired
	private Environment env;
	
	@Value("${db.driver}")
	private String driverClass;
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String username;
	
	@Value("${db.password}")
	private String password;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url,username,password);
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}
	
	public Properties hibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
	 @Bean
	   public EntityManagerFactory entityManagerFactory() {

	       HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	       vendorAdapter.setGenerateDdl(true);
	       vendorAdapter.setShowSql(false);
	       vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
	       LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	       factory.setJpaVendorAdapter(vendorAdapter);
	       factory.setJpaProperties(hibernateProperties());
	       factory.setPackagesToScan("com.example.demo");
	       factory.setDataSource(getDataSource());
	       factory.afterPropertiesSet();
	       return factory.getObject();
	   }


	   //JpaTransactionManager Bean
	   @Bean
	   public JpaTransactionManager transactionManager() {
	       JpaTransactionManager txManager = new JpaTransactionManager();
	       txManager.setDataSource(getDataSource());
	       txManager.setEntityManagerFactory(entityManagerFactory());
	       return txManager;
	   }
}