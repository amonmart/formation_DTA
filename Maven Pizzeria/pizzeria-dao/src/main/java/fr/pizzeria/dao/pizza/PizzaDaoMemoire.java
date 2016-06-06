package fr.pizzeria.dao.pizza;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Repository
@Transactional
public class PizzaDaoMemoire implements IPizzaDao {
	
	private Map<String, Pizza> pizzas = new HashMap<String, Pizza>();
	
	
	public PizzaDaoMemoire() {
		
		pizzas.put("PEP", new Pizza("PEP", "Pépéroni", new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.put("MAR", new Pizza("MAR", "Margherita", new BigDecimal("14"),  CategoriePizza.SANS_VIANDE));
		pizzas.put("REI", new Pizza("REI", "La Reine", new BigDecimal("13"), CategoriePizza.VIANDE));
		pizzas.put("FRO", new Pizza("FRO", "La 4 fromages", new BigDecimal("12"),  CategoriePizza.SANS_VIANDE));
		pizzas.put("CAN", new Pizza("CAN", "La cannibale", new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.put("SAV", new Pizza("SAV", "La savoyarde", new BigDecimal("13"), CategoriePizza.VIANDE));
		pizzas.put("ORI", new Pizza("ORI", "L'orientale", new BigDecimal("13.50"), CategoriePizza.VIANDE));
		pizzas.put("IND", new Pizza("IND", "L'indienne", new BigDecimal("14"), CategoriePizza.VIANDE));
		pizzas.put("SAU", new Pizza("SAU", "La Saumonéta", new BigDecimal("14"), CategoriePizza.POISSON));
	}
	
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		return new ArrayList<Pizza>(pizzas.values());
	}
	
	@Override
	public Pizza findPizza(String codePizza) {
		List<Pizza> pizzas = findAllPizzas();
		Pizza retour = new Pizza();
		for (Pizza p : pizzas){
			if (p.getCode().equals(codePizza)){
				retour = p;
			}
		}
		return retour;
	}
	
	@Override
	public void savePizza(Pizza newPizza) throws DaoException {
		if(pizzas.containsKey(newPizza.getCode())) {
			throw new SavePizzaException("code pizza déjà présent");
		}
		pizzas.put(newPizza.getCode(), newPizza);
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		if(!pizzas.containsKey(codePizza)) {
			throw new UpdatePizzaException("code pizza non trouvé");
		}
		pizzas.put(codePizza, updatePizza);
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		if(!pizzas.containsKey(codePizza)) {
			throw new DeletePizzaException("code pizza non trouvé");
		}
		pizzas.remove(codePizza);
	}

	@Override
	public void importPizza(List<Pizza> pizzas) throws DaoException {
		Boolean test;
		List<List<Pizza>> listPart = ListUtils.partition(pizzas, 3);
		for(List<Pizza> list : listPart){
			for(Pizza p  : list){
				test = false;
				if( this.findPizza(p.getCode()).getCode() != null){
					test = true;
				}
				if(test){
					throw new DaoException();
				}
			}
			for (Pizza p : list){
				savePizza(p);
			}
		}
	}

}
