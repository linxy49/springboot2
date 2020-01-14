package com.line.delivey.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.line.delivey.infrastructure.psqldb",
    entityManagerFactoryRef = "psqldbEntityManager",
    transactionManagerRef = "psqlTransactionManager")
public class PsqldbConfig {

  /**
   * psql datasource.
   * @return
   */
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.psqldb")
  public DataSourceProperties psqldbProperties() {
    return new DataSourceProperties();
  }

  @Bean
  @Autowired
  public DataSource psqldbDataSource(
      @Qualifier("psqldbProperties") DataSourceProperties properties) {
    return properties.initializeDataSourceBuilder().build();
  }

  /**
   * psql entity.
   * @param builder builer
   * @param dataSource datasource
   * @return
   */
  @Bean
  @Autowired
  public LocalContainerEntityManagerFactoryBean psqldbEntityManager(
      EntityManagerFactoryBuilder builder,
      @Qualifier("psqldbDataSource") DataSource dataSource) {
    return builder.dataSource(dataSource)
        .packages("com.line.delivey.infrastructure.psqldb")
        .persistenceUnit("psql")
        .build();
  }

  /**
   * psql transaction.
   * @param entityManager entityManager
   * @return
   */
  @Bean
  @Autowired
  public JpaTransactionManager psqlTransactionManager(
      @Qualifier("psqldbEntityManager") LocalContainerEntityManagerFactoryBean entityManager) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManager.getObject());
    return transactionManager;
  }
}
