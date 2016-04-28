package fr.pizzeria.dao;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImp implements iPizzaDao {
	
	private Pizza[] pizzas;
	
	public PizzaDaoImp() {
		pizzas = new Pizza[100];
		pizzas[0] = new Pizza();
		pizzas[0].creer(0,"PEP", "Pépéroni", 12.50 );
		pizzas[1] = new Pizza();
		pizzas[1].creer(1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza();
		pizzas[2].creer(2, "REI", "La Reine", 11.50 );
		pizzas[3] = new Pizza();
		pizzas[3].creer(3, "FRO", "La 4 fromages", 12.00 );
		pizzas[4] = new Pizza();
		pizzas[4].creer(4, "CAN", "La cannibale", 12.50 );
		pizzas[5] = new Pizza();
		pizzas[5].creer(5, "SAV", "La savoyarde", 13.00 );
		pizzas[6] = new Pizza();
		pizzas[6].creer(6, "ORI", "L'orientale", 13.50 );
		pizzas[7] = new Pizza();
		pizzas[7].creer(7, "IND", "L'indienne", 14.00 );
	}

	@Override
	public Pizza[] findAllPizza() {
		Pizza[] resultat = new Pizza[100];
		for (int i = 0; i < pizzas.length; i++) {
			resultat[i] = pizzas[i]; 
		}
		return resultat;
	}

	@Override
	public void savePizza(Pizza newPizza) throws SavePizzaException {
		
		boolean placeTrouve = false;
		int index = 0;
		while (!placeTrouve && index < pizzas.length) {
			placeTrouve = pizzas[index] == null;
			index++;
		}
		
		if (placeTrouve) {
			pizzas[index] = newPizza;
		} else {
			throw new SavePizzaException();
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws UpdatePizzaException {
		Object[] resultatRecherche = rechercherPizza(pizzas, codePizza);
		boolean pizzaTrouve = (boolean) resultatRecherche[0];
		int indexPizzaTrouve = (int) resultatRecherche[1];

		if (pizzaTrouve) {
			pizzas[indexPizzaTrouve] = updatePizza;
		} else {
			throw new UpdatePizzaException();
		}
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		Object[] resultatRecherche = rechercherPizza(pizzas, codePizza);
		boolean pizzaTrouve = (boolean) resultatRecherche[0];
		int indexPizzaTrouve = (int) resultatRecherche[1];
		if (pizzaTrouve) {
			pizzas[indexPizzaTrouve] = new Pizza();
		} else {
			throw new DeletePizzaException();
		}
	}
	
	private static Object[] rechercherPizza(Pizza[] pizzas, String codePizza) {
		boolean pizzaTrouve = false;
		int indexPizzaTrouve = 0;
		while (!pizzaTrouve && indexPizzaTrouve < pizzas.length) {
			if (pizzas[indexPizzaTrouve] != null){
				pizzaTrouve = codePizza.equals(pizzas[indexPizzaTrouve].code);
			}
			if (!pizzaTrouve) {
				indexPizzaTrouve++;
			}
		}
		return new Object[] { pizzaTrouve, indexPizzaTrouve };
	}

}
