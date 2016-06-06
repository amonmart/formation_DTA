package fr.pizzeria.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.dao.FactoryDaoDataJpa;
import fr.pizzeria.dao.IFactoryDao;

@Configuration
@ComponentScan("{fr.pizzeria.dao, fr.pizzeria.performance}")
@EnableJpaRepositories("fr.pizzeria.dao.repository")
public class PizzaDaoConfigTestDataJpa {

	@Bean
	public DataSource dataSource(){
		return new EmbeddedDatabaseBuilder().
				setType(EmbeddedDatabaseType.H2).
				addScript("db-schema.sql")
				.addScript("db-data.sql")
				.build();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		return new JpaTransactionManager();
	}

	
	@Bean
	public IFactoryDao factoryDaoDataJpa(){
		IFactoryDao factoryDao = new FactoryDaoDataJpa(); 
		return factoryDao;
	}
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory(){
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("pizzeria-console");
		return emf;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
		return new org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor();
	}
}
