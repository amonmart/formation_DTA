package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImp;
import fr.pizzeria.exception.*;

public class SupprimerPizzaOptionMenu extends AbstractOptionMenu{

	private static final String SUPPRIMER_PIZZA_LABELLE_MENU = "Supprimer une pizza";
	private AbstractOptionMenu listerPizza;
	
	public SupprimerPizzaOptionMenu(PizzaDaoImp pizzaDao, Scanner sc) {
		super(SUPPRIMER_PIZZA_LABELLE_MENU, pizzaDao, sc);
		this.listerPizza = new ListerPizzaOptionMenu(pizzaDao, sc);
	}

	@Override
	public boolean execute() throws DaoException {
		System.out.println("Menu supprimer une pizza");
		listerPizza.execute();
		System.out.println("Saisir le code de la pizza à supprimer");
		String codePizza = sc.next();
		pizzaDao.deletePizza(codePizza);

		return true;
	}

}
