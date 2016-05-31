package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJDBC;

@Component
public class FactoryDaoJDBC extends abstractFactoryDao implements IFactoryDao {
	
	public FactoryDaoJDBC() {
		this.pizzaDao = new PizzaDaoJDBC();
	}

	@Override
	public IPizzaDao getPizzaDao() {
		return new PizzaDaoJDBC();
	}

	@Override
	public IClientDao getClientDao() {
		return this.clientDao;
		
	}

}
