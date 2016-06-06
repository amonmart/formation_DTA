package fr.pizzeria.spring.web.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import fr.pizzeria.dao.FactoryDaoJPASpring;
import fr.pizzeria.dao.IFactoryDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoMemoire;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableJpaRepositories("fr.pizzeria.dao.repository")
@ComponentScan({"fr.pizzeria.spring.web.controller", "fr.pizzeria.performance"})
public class PizzeriaSpringConfig {
	@Bean
	IFactoryDao factoryDao(){
		return new FactoryDaoJPASpring();
	}
	
	@Bean
	IPizzaDao pizzaDao(){
		return new PizzaDaoMemoire();
	}
	
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
	public LocalEntityManagerFactoryBean localEntityManagerFactoryBean(){
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("pizzeria-console");
		return emf;
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver; 
	}
}
