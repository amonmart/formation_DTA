package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Component;

import fr.pizzeria.dao.client.ClientDaoJpa;
import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;

@Component
public class FactoryDaoJPA extends abstractFactoryDao implements IFactoryDao {

	private IClientDao clientDao;
	private IPizzaDao pizzaDao;
	
	public FactoryDaoJPA(EntityManagerFactory emf) {
		super(emf);
		this.clientDao = new ClientDaoJpa(emf);
		this.pizzaDao = new PizzaDaoJpa(emf);
	}

	@Override
	public IPizzaDao getPizzaDao() {
		return this.pizzaDao;
	}

	@Override
	public IClientDao getClientDao() {
		return this.clientDao;
		
	}

}
