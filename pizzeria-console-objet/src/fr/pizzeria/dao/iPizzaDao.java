package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public interface iPizzaDao {

	Pizza[] findAllPizza();
	boolean savePizza(Pizza newPizza);
	boolean updatePizza(String codePizza, Pizza updatePizza);
	boolean deletePizza(String codePizza);
}
