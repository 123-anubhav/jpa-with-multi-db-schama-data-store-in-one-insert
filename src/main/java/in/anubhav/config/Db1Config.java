package in.anubhav.config;

import java.util.Map;

import javax.persistence.EntityManagerFactory;
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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "in.anubhav.jpa.db1",  // ✅ repository package for DB1
		entityManagerFactoryRef = "db1EntityManager",
		transactionManagerRef = "db1TransactionManager"
	)
public class Db1Config {

	@Primary
	@Bean(name = "db1DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.db1")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "db1EntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("db1DataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("in.anubhav.entity") // ✅ your entity package
				.persistenceUnit("db1")
				 .properties(Map.of(
			                "hibernate.hbm2ddl.auto", "update",   // ✅ force schema creation
			                "hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"
			            ))
				 .build();
	}

	@Primary
	@Bean(name = "db1TransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("db1EntityManager") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
