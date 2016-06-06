package fr.pizzeria.console;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.dao.FactoryDaoDataJpa;
import fr.pizzeria.dao.IFactoryDao;

@Configuration
@ComponentScan({"fr.pizzeria.ihm","fr.pizzeria.dao", "fr.pizzeria.performance"})
@EnableJpaRepositories("fr.pizzeria.dao.repository")
@EnableAspectJAutoProxy
public class PizzeriaAppSpringConfigJpaData {

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource){
		return new JpaTransactionManager();
	}
	
	@Bean
	public IFactoryDao factoryDao() {
		return new FactoryDaoDataJpa();
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/pizzeria", "antonin", "antonin123");
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("pizzeria-console");
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
		return new org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor();
	}

	/*
	 * @Bean public EntityManagerFactory emf(){ return
	 * Persistence.createEntityManagerFactory("pizzeria-console"); }
	 */
}
