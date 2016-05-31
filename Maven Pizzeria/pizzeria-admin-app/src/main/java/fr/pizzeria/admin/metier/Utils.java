package fr.pizzeria.admin.metier;

import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;

public class Utils {
	@Produces
	public IPizzaDao getPizzaDaoImpl(){
		return IPizzaDao.IMPLEMENTATION;
	}

}
