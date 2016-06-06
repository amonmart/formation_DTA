package fr.pizzeria.dao;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJDBC;
import fr.pizzeria.dao.pizza.PizzaDaoJDBCTemplate;
import fr.pizzeria.exception.DaoException;

@Component
public class FactoryDaoJDBCTemplate extends abstractFactoryDao implements IFactoryDao {
	
	@Inject DataSource dataSource;
	@Inject PlatformTransactionManager txManager;
	
	public FactoryDaoJDBCTemplate() {
		
	}

	@Override
	public IPizzaDao getPizzaDao() {
		PizzaDaoJDBCTemplate pizzaDao = new PizzaDaoJDBCTemplate(dataSource, txManager);
		return pizzaDao;
	}

	@Override
	public IClientDao getClientDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
