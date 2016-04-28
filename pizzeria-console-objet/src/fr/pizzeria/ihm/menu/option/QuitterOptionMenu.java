package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImp;

public class QuitterOptionMenu extends AbstractOptionMenu {

	private static final String QUITTER_LIBELLE_MENU = "Quitter";

	public QuitterOptionMenu(PizzaDaoImp pizzaDao, Scanner sc) {
		super(QUITTER_LIBELLE_MENU, pizzaDao, sc);
	}

	@Override
	public boolean execute() {
		System.out.println("Aurevoir =)");
		return false;
	}

}
