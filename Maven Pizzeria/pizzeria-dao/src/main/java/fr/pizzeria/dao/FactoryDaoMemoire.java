package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.client.ClientDaoImpl;
import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;

public class FactoryDaoMemoire implements IFactoryDao {

	public FactoryDaoMemoire() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPizzaDao getPizzaDao() {
		return new PizzaDaoImpl();
	}

	@Override
	public IClientDao getClientDao() {
		return new ClientDaoImpl();
	}

}
