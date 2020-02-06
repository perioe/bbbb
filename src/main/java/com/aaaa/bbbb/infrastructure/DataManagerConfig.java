package com.aaaa.bbbb.infrastructure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = {"com.aaaa.bbbb.domain.repository"},
    entityManagerFactoryRef = "entityManagerFactory")
public class DataManagerConfig {

  @Primary
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
      @Qualifier("dataSource") DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
        new LocalContainerEntityManagerFactoryBean();
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();

    localContainerEntityManagerFactoryBean.setDataSource(dataSource);
    localContainerEntityManagerFactoryBean.setPackagesToScan("com.aaaa.bbbb.domain.entity");
    localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
    localContainerEntityManagerFactoryBean.setJpaProperties(hibernateProperties());

    return localContainerEntityManagerFactoryBean;
  }

  @Primary
  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

    return jpaTransactionManager;
  }

  @Primary
  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", "none");
    properties.setProperty("hibernate.show_sql", "true");
    properties.setProperty("hibernate.format_sql", "true");
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

    return properties;
  }
}
