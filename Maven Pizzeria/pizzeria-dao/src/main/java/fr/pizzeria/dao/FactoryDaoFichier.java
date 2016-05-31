package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.client.ClientDaoImpl;
import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;

@Repository
public class FactoryDaoFichier implements IFactoryDao {
	
	public FactoryDaoFichier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPizzaDao getPizzaDao() {
		return new PizzaDaoFichierImpl();
	}

	@Override
	public IClientDao getClientDao() {
		//TODO Mauvaise implémentation de clientDao
		return new ClientDaoImpl();
	}

}
