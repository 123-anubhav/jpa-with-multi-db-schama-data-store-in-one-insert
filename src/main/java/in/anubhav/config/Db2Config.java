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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "in.anubhav.jpa.db2", // ✅ repository package for DB2
		entityManagerFactoryRef = "db2EntityManager", 
		transactionManagerRef = "db2TransactionManager"
	)
public class Db2Config {

	@Bean(name = "db2DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.db2")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "db2EntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("db2DataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("in.anubhav.entity") // ✅ your entity package
				.persistenceUnit("db2")
				 .properties(Map.of(
			                "hibernate.hbm2ddl.auto", "update",   // ✅ ensure DB2 schema auto-creation
			                "hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"
			            ))
				 .build();
	}

	@Bean(name = "db2TransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("db2EntityManager") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
