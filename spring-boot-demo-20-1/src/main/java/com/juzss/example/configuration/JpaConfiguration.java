package com.juzss.example.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * JPA配置类
 *
 * @author lemon
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.juzss.example.repository")
@EntityScan(basePackages = "com.juzss.example.domain")
public class JpaConfiguration {
	    @Value("${spring.datasource.driverClassName}")
	    private String driverClassName;
	    @Value("${spring.datasource.url}")
	    private String url;
	    @Value("${spring.datasource.username}")
	    private String username;
	    @Value("${spring.datasource.password}")
	    private String password;
	    @Value("${spring.jpa.properties.hibernate.dialect}")
	    private String dialect;
	    @Value("${spring.jpa.show-sql}")
	    private String showSql;
	    @Value("${spring.jpa.hibernate.use_sql_comments}")
	    private String useSqlComments;
	    @Value("${spring.jpa.hibernate.format_sql}")
	    private String formatSql;
	    @Value("${spring.jpa.hibernate.hbm2ddl_auto}")
	    private String hbm2ddlAuto;
	    @Value("${spring.jpa.hibernate.generate_statistics}")
	    private String generateStatistics;
	    @Value("${spring.jpa.hibernate.validation_mode}")
	    private String validationMode;
	    @Value("${spring.jpa.hibernate.store_data_at_delete}")
	    private String storeDataAtDelete;
	    @Value("${spring.jpa.hibernate.global_with_modified_flag}")
	    private String globalWithModifiedFlag;

	    @Bean
	    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
	        return new PersistenceExceptionTranslationPostProcessor();
	    }

	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(driverClassName);
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);
	        return dataSource;
	    }

	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	        entityManagerFactoryBean.setDataSource(dataSource());
	        entityManagerFactoryBean.setPackagesToScan("com.juzss.example.domain");
	        entityManagerFactoryBean.setJpaProperties(buildHibernateProperties());
	        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter() {{
	            setDatabase(Database.MYSQL);
	        }});
	        return entityManagerFactoryBean;
	    }

	    protected Properties buildHibernateProperties() {
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.dialect", dialect);
	        hibernateProperties.setProperty("hibernate.show_sql", showSql);
	        hibernateProperties.setProperty("hibernate.use_sql_comments", useSqlComments);
	        hibernateProperties.setProperty("hibernate.format_sql", formatSql);
	        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
	        hibernateProperties.setProperty("hibernate.generate_statistics", generateStatistics);
	        hibernateProperties.setProperty("javax.persistence.validation.mode", validationMode);

	        //Audit History flags
	        hibernateProperties.setProperty("org.hibernate.envers.store_data_at_delete", storeDataAtDelete);
	        hibernateProperties.setProperty("org.hibernate.envers.global_with_modified_flag", globalWithModifiedFlag);

	        return hibernateProperties;
	    }

	    @Bean
	    public PlatformTransactionManager transactionManager() {
	        return new JpaTransactionManager();
	    }

	    @Bean
	    public TransactionTemplate transactionTemplate() {
	        return new TransactionTemplate(transactionManager());
	    }
}
