/**
 * 
 */
package com.multi.db.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

/**
 * @author Lejil
 *
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.multi.db.mysql.repository", // Repository package for MySQL
		entityManagerFactoryRef = "mySqlEntityManagerFactory", transactionManagerRef = "mySqlTransactionManager")
public class MySqlConfig {

	@Primary
	@Bean(name = "mySqlDataSource")
	@ConfigurationProperties(prefix = "spring.mysql.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "mySqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("mySqlDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.multi.db.model") // Entity package
				.persistenceUnit("mySqldb").properties(hibernateProperties()).build();
	}

	@Primary
	@Bean(name = "mySqlTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("mySqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	private Map<String, Object> hibernateProperties() {
		Map<String, Object> hibernateProperties = new HashMap<>();
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update"); // Set ddl-auto for PostgreSQL
		return hibernateProperties;
	}
}
