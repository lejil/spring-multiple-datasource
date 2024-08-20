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
@EnableJpaRepositories(basePackages = "com.multi.db.postgresql.repository", // Repository package for PostgreSQL
		entityManagerFactoryRef = "postgreSqlEntityManagerFactory", transactionManagerRef = "postgreSqlTransactionManager")
public class PostgreSqlConfig {

	@Bean(name = "postgreSqlDataSource")
	@ConfigurationProperties(prefix = "spring.postgresql.datasource")
	DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "postgreSqlEntityManagerFactory")
	LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("postgreSqlDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.multi.db.model") // Entity package
				.persistenceUnit("postgreSqldb").properties(hibernateProperties()).build();
	}

	@Bean(name = "postgreSqlTransactionManager")
	PlatformTransactionManager transactionManager(
			@Qualifier("postgreSqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	private Map<String, Object> hibernateProperties() {
		Map<String, Object> hibernateProperties = new HashMap<>();
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update"); // Set ddl-auto for PostgreSQL
		return hibernateProperties;
	}
}
