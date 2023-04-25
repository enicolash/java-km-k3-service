package com.km.connection;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	@Bean(name = "datasourcepostgre")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource postgreDataSource() {
		return DataSourceBuilder.create().build();
	}
}
