package fr.pizzeria.config;

import java.util.Scanner;

import javax.inject.Named;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.FactoryDaoJDBCTemplate;
import fr.pizzeria.dao.FactoryDaoJPASpring;
import fr.pizzeria.dao.FactoryDaoMemoire;
import fr.pizzeria.dao.IFactoryDao;
import fr.pizzeria.dao.pizza.PizzaDaoJDBCTemplate;

@Configuration
@ComponentScan("fr.pizzeria.dao")
@EnableTransactionManagement
public class PizzaDaoConfigSpringTestMemoire {

	@Bean
	public DataSource dataSource(){
		return new EmbeddedDatabaseBuilder().
				setType(EmbeddedDatabaseType.H2).
				addScript("db-schema.sql")
				.addScript("db-data.sql")
				.build();
	}
	
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean
	public IFactoryDao factoryDao(){
		IFactoryDao factoryDao = new FactoryDaoMemoire(); 
		return factoryDao;
	}
	
	@Bean PizzaDaoJDBCTemplate pizzaDaoJDBCTemplate(){
		return new PizzaDaoJDBCTemplate(dataSource(), txManager(dataSource()));
	}
	
	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
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
