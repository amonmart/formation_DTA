package fr.pizzeria.admin.metier;

import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoMemoire;

public class Utils {
	@Produces
	public IPizzaDao getPizzaDaoImpl(){
		return IPizzaDao.IMPLEMENTATION;
	}

}
