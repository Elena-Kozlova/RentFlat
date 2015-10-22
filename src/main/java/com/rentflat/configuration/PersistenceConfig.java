package com.rentflat.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Persistence configuration
 */
@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

    @Autowired
    private Environment environment;

    /**
     * SessionFactory bean
     *
     * @return SessionFactory
     */
    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("com.rentflat.repository.model").addProperties(getHibernateProperties());
        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.dbcp.initialSize", environment.getProperty("hibernate.dbcp.initialSize"));
        properties.put("hibernate.dbcp.maxActive", environment.getProperty("hibernate.dbcp.maxActive"));
        properties.put("hibernate.dbcp.maxIdle", environment.getProperty("hibernate.dbcp.maxIdle"));
        properties.put("hibernate.dbcp.minIdle", environment.getProperty("hibernate.dbcp.minIdle"));
        properties.put("hibernate.max_fetch_depth", environment.getProperty("hibernate.max_fetch_depth"));
        return properties;
    }

    /**
     * BasicDataSource bean
     *
     * @return BasicDataSource
     */
    @Bean(name = "dataSource")
    public BasicDataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        basicDataSource.setUrl(environment.getProperty("jdbc.url"));
        basicDataSource.setUsername(environment.getProperty("jdbc.username"));
        basicDataSource.setPassword(environment.getProperty("jdbc.password"));
        basicDataSource.setValidationQuery("Select 1");
        return basicDataSource;
    }

    /**
     * Transaction manager bean
     * @return HibernateTransactionManager
     */
    @Bean(name = "transactionManager")
    public HibernateTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory());
    }
}
