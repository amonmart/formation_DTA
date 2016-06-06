package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

@Component
public class FactoryDaoDataJpa extends abstractFactoryDao {
	
	@Autowired @Qualifier("pizzaDaoDataJpa") private IPizzaDao pizzaDao;
	
	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

	@Override
	public IClientDao getClientDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
