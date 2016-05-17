package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public interface IFactoryDao {
	public IPizzaDao getPizzaDao();
	public IClientDao getClientDao();
}
