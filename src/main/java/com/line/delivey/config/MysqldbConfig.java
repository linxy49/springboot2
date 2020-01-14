package com.line.delivey.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.line.delivey.infrastructure.mysqldb",
    entityManagerFactoryRef = "mysqldbEntityManager",
    transactionManagerRef = "mysqlTransactionManager")
public class MysqldbConfig {

  /**
   * primary datasource.
   * @return
   */
  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource.mysqldb")
  public DataSourceProperties mysqldbProperties() {
    return new DataSourceProperties();
  }

  @Bean
  @Primary
  @Autowired
  public DataSource mysqldbDataSource(
      @Qualifier("mysqldbProperties") DataSourceProperties properties) {
    return properties.initializeDataSourceBuilder().build();
  }

  /**
   * mysqldb entity.
   * @param builder builer
   * @param dataSource datasource
   * @return
   */
  @Bean
  @Primary
  @Autowired
  public LocalContainerEntityManagerFactoryBean mysqldbEntityManager(
      EntityManagerFactoryBuilder builder,
      @Qualifier("mysqldbDataSource") DataSource dataSource) {
    return builder.dataSource(dataSource)
        .packages("com.line.delivey.infrastructure.mysqldb")
        .persistenceUnit("mysql")
        .build();
  }

  /**
   * mysql transaction.
   * @param entityManager entityManager
   * @return
   */
  @Bean
  @Primary
  @Autowired
  public JpaTransactionManager mysqlTransactionManager(
      @Qualifier("mysqldbEntityManager") LocalContainerEntityManagerFactoryBean entityManager) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManager.getObject());
    return transactionManager;
  }
}
