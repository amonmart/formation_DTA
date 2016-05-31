package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.client.ClientDaoImpl;
import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoHTTP;

@Component
public class FactoryDaoHTTP implements IFactoryDao {
	
	public FactoryDaoHTTP() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPizzaDao getPizzaDao() {
		return new PizzaDaoHTTP();
	}

	@Override
	public IClientDao getClientDao() {
		//TODO Mauvaise implémentation de clientDao
		return new ClientDaoImpl();
	}

}
