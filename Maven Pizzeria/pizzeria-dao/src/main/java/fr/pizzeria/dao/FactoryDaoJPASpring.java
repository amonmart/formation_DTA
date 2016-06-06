package fr.pizzeria.dao;

import javax.ws.rs.ext.ParamConverter.Lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPASpring;

@Component
@Lazy
public class FactoryDaoJPASpring implements IFactoryDao {
	
	@Autowired @Qualifier("pizzaDaoJPASpring") private IPizzaDao pizzaDao;
	
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
