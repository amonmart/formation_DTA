package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImp;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends AbstractOptionMenu {

	private static final String MODIFIEr_PIZZA_OPTION_MENU = "Modifier une pizza";
	private SaisirDonneesPizza saisie = new SaisirDonneesPizza();
	private AbstractOptionMenu listerPizza;
	
	public ModifierPizzaOptionMenu(PizzaDaoImp pizzaDao, Scanner sc)  {
		super(MODIFIEr_PIZZA_OPTION_MENU, pizzaDao, sc);
		this.listerPizza = new ListerPizzaOptionMenu(pizzaDao, sc);
	}

	@Override
	public boolean execute() throws DaoException {
		System.out.println("Menu ajouter une pizza");
		
		listerPizza.execute();
		System.out.println("Saisir le code de la pizza à modifier");
		String codePizza = sc.next();
		Pizza p = saisie.saisirDonneesPizza(sc);

		this.pizzaDao.updatePizza(codePizza,p);

		
		return true;
	}
}
