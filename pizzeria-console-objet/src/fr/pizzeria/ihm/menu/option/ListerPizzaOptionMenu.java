package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImp;
import fr.pizzeria.model.Pizza;

public class ListerPizzaOptionMenu extends AbstractOptionMenu {

	private static final String LISTER_PIZZAS_LIBELLE_MENU = "Lister les pizzas";
	
	public ListerPizzaOptionMenu(PizzaDaoImp pizzaDao, Scanner sc) {
		super(LISTER_PIZZAS_LIBELLE_MENU, pizzaDao, sc);
	}

	@Override
	public boolean execute() {
		System.out.println("Lister Pizza Menu");
		Pizza[] pizzas = this.pizzaDao.findAllPizza();
		for ( Pizza p : pizzas ){
			if ((p != null) && (p.code != null)) {
				System.out.println(p.code + " --> " + p.nom + " (" + p.prix + " €)");
			}
		}
		return true;
	}

}
