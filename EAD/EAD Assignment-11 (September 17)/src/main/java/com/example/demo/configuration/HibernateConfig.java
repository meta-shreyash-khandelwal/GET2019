package com.example.demo.configuration;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

/**
*
* @return HibernateTemplate
*/
@Bean
public HibernateTemplate hibernateTemplate() {
return new HibernateTemplate(sessionFactory());
}

/**
*
* @return SessionFactory
*/
@Bean
public SessionFactory sessionFactory() {
LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
lsfb.setDataSource(getDataSource());
lsfb.setPackagesToScan("com.example.demo.model");
lsfb.setHibernateProperties(hibernateProperties());
try {
lsfb.afterPropertiesSet();
} catch (IOException e) {
e.printStackTrace();
}
return lsfb.getObject();
}

/**
*
* @return DataSource
*/
@Bean
public DataSource getDataSource() {
BasicDataSource dataSource = new BasicDataSource();
dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
dataSource.setUrl("jdbc:mysql://localhost:3306/student");
dataSource.setUsername("root");
dataSource.setPassword("root");
return dataSource;
}

/**
*
* @return HibernateTransactionManager
*/
@Bean
public HibernateTransactionManager hibTransMan() {
return new HibernateTransactionManager(sessionFactory());
}


/**
*
* @return Properties
*/
private Properties hibernateProperties() {
Properties properties = new Properties();
properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
properties.put("hibernate.hbm2ddl.auto", "update");
properties.put("hibernate.show_sql", "true");
properties.setProperty("spring.jpa.open-in-view", "false");
return properties;
}
}
