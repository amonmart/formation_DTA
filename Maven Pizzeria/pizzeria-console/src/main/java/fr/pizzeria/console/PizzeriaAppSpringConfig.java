package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.FactoryDaoFichier;
import fr.pizzeria.dao.IFactoryDao;
import fr.pizzeria.ihm.menu.Menu;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfig {
	
	@Bean
	public IFactoryDao factoryDao(){
		IFactoryDao factoryDao = new FactoryDaoFichier(); 
		return factoryDao;
	}
	
	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
	}
}
