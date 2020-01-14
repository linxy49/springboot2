package com.line.delivey.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
    basePackages = "com.line.delivey.infrastructure.mongodb")
public class MongodbConfig {
//
//  /**
//   * mongodb datasource.
//   * @return
//   */
//  @Bean
//  @ConfigurationProperties(prefix = "spring.datasource.mongodb")
//  public DataSourceProperties mongodbProperties() {
//    return new DataSourceProperties();
//  }
//
//  @Bean
//  @Autowired
//  public DataSource mongodbDataSource(
//      @Qualifier("mongodbProperties") DataSourceProperties properties) {
//    return properties.initializeDataSourceBuilder().build();
//  }
//
//  /**
//   * mongodb entity.
//   * @param builder builer
//   * @param dataSource datasource
//   * @return
//   */
//  @Bean
//  @Autowired
//  public LocalContainerEntityManagerFactoryBean mongodbEntityManager(
//      EntityManagerFactoryBuilder builder,
//      @Qualifier("mongodbDataSource") DataSource dataSource) {
//    return builder.dataSource(dataSource)
//        .packages("com.line.delivey.infrastructure.mongodb")
//        .persistenceUnit("mongo")
//        .build();
//  }
//
//  /**
//   * mongodb transaction.
//   * @param entityManager entityManager
//   * @return
//   */
//  @Bean
//  @Autowired
//  public JpaTransactionManager mongoTransactionManager(
//      @Qualifier("mongodbEntityManager") LocalContainerEntityManagerFactoryBean entityManager) {
//    JpaTransactionManager transactionManager = new JpaTransactionManager();
//    transactionManager.setEntityManagerFactory(entityManager.getObject());
//    return transactionManager;
//  }
}
