package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public abstract class abstractFactoryDao implements IFactoryDao{
	private EntityManagerFactory emf;
	protected IPizzaDao pizzaDao;
	protected IClientDao clientDao;
	
	public abstractFactoryDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

}
