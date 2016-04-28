package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImp;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends AbstractOptionMenu {

	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "Ajouter une nouvelle pizza";
	private SaisirDonneesPizza saisie = new SaisirDonneesPizza();
	
	public NouvellePizzaOptionMenu(PizzaDaoImp pizzaDao, Scanner sc) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, sc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute() throws SavePizzaException {
		System.out.println("Menu ajouter une pizza");
		Pizza p = saisie.saisirDonneesPizza(sc);
		this.pizzaDao.savePizza(p);


		
		
		return true;
	}

}
