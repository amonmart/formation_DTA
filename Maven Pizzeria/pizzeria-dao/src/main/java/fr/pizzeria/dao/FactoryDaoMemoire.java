package fr.pizzeria.dao;

import org.springframework.stereotype.Component;

import fr.pizzeria.dao.client.ClientDaoImpl;
import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoMemoire;

@Component
public class FactoryDaoMemoire implements IFactoryDao {
	
	public FactoryDaoMemoire() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPizzaDao getPizzaDao() {
		return new PizzaDaoMemoire();
	}

	@Override
	public IClientDao getClientDao() {
		return new ClientDaoImpl();
	}

}
