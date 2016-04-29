package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImp implements iPizzaDao {
	
	private Map<String,Pizza> pizzas = new HashMap<String,Pizza>();
	
	public PizzaDaoImp() {
		pizzas.put("PEP", new Pizza("PEP", "P�p�roni", 12.50));
		pizzas.put("MAR", new Pizza("MAR", "Margherita", 14.00));
		pizzas.put("REI", new Pizza("REI", "La Reine", 11.50));
		pizzas.put("FRO", new Pizza( "FRO", "La 4 fromages", 12.00 ));
		pizzas.put("CAN", new Pizza("CAN", "La cannibale", 12.50));
		pizzas.put("SAV", new Pizza("SAV", "La savoyarde", 13.00));
		pizzas.put("ORI", new Pizza("ORI", "L'orientale", 13.50 ));
		pizzas.put("IND", new Pizza( "IND", "L'indienne", 14.00 ));
	}

	@Override
	public List<Pizza> findAllPizza() {	
		return new ArrayList<Pizza>(pizzas.values()) ;
	}

	@Override
	public void savePizza(Pizza newPizza) throws SavePizzaException {
		if(pizzas.containsKey(newPizza.code)){
			throw new SavePizzaException();
		}else {
			pizzas.put(newPizza.code, newPizza);
		}
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws UpdatePizzaException {
		if(!pizzas.containsKey(codePizza)){
			throw new UpdatePizzaException();
		}
		pizzas.remove(codePizza); 
		pizzas.put(codePizza, updatePizza);
		
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		if(!pizzas.containsKey(codePizza)){
			throw new DeletePizzaException();
		}
		pizzas.remove(codePizza);
	}

}
