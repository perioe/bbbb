package com.aaaa.bbbb.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class DataSourceConfig {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.datasource-read")
  public DataSource readDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.datasource-write")
  public DataSource writeDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public DataSource routingDataSource() {
    ReplicationRoutingDataSource routingDataSource = new ReplicationRoutingDataSource();
    routingDataSource.setTargetDataSources(targetDataSources());
    routingDataSource.setDefaultTargetDataSource(readDataSource());

    return routingDataSource;
  }

  @Bean
  public DataSource dataSource() {
    return new LazyConnectionDataSourceProxy(routingDataSource());
  }

  private Map<Object, Object> targetDataSources() {
    Map<Object, Object> targetDataSourceMap = new HashMap<>();
    targetDataSourceMap.put(DatabaseType.READ, readDataSource());
    targetDataSourceMap.put(DatabaseType.WRITE, writeDataSource());

    return targetDataSourceMap;
  }
}
