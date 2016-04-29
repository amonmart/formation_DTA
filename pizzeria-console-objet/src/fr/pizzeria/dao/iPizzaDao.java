package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public interface iPizzaDao {

	List<Pizza> findAllPizza();
	void savePizza(Pizza newPizza) throws SavePizzaException;
	void updatePizza(String codePizza, Pizza updatePizza) throws UpdatePizzaException;
	void deletePizza(String codePizza) throws DeletePizzaException;
}
