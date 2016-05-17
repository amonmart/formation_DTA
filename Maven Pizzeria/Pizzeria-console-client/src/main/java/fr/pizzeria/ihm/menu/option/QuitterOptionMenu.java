package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.model.Client;

public class QuitterOptionMenu extends AbstractOptionMenuClient {

	private static final String QUITTER_LIBELLE_MENU = "Quitter";

	public QuitterOptionMenu() {
		super(QUITTER_LIBELLE_MENU);
	}

	@Override
	public boolean execute() {
		System.out.println("Aurevoir :-(");
		return false;
	}

	@Override
	public boolean execute(Client client) {
		System.out.println("Deconnection");
		return false;
	}

}
