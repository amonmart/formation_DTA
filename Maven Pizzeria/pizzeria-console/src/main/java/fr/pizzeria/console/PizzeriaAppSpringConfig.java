package fr.pizzeria.console;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.FactoryDaoDataJpa;
import fr.pizzeria.dao.FactoryDaoJPASpring;
import fr.pizzeria.dao.IFactoryDao;

@Configuration
@ComponentScan("fr.pizzeria")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class PizzeriaAppSpringConfig {
	
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource){
		return new JpaTransactionManager();
	}
	
	@Bean
	public IFactoryDao factoryDao(){
		return new FactoryDaoDataJpa(); 
	}
	
	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
	}
	
	@Bean
	public DataSource dataSource(){
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/pizzeria", "antonin","antonin123");
	}
	
	@Bean
	public LocalEntityManagerFactoryBean localEntityManagerFactoryBean(){
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
	
	/*
	@Bean
	public EntityManagerFactory emf(){
		return Persistence.createEntityManagerFactory("pizzeria-console");
	}
	*/
}
