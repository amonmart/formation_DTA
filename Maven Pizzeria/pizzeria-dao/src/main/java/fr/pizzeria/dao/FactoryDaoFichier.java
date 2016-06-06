package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.client.ClientDaoImpl;
import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

@Repository
public class FactoryDaoFichier implements IFactoryDao {
	
	@Autowired @Qualifier("pizzaDaoFichierImpl") private IPizzaDao pizzaDao;

	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

	@Override
	public IClientDao getClientDao() {
		//TODO Mauvaise implémentation de clientDao
		return new ClientDaoImpl();
	}

}
