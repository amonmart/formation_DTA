package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import fr.pizzeria.dao.IFactoryDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenuClient;
import fr.pizzeria.ihm.menu.option.InscriptionOptionMenu;
import fr.pizzeria.ihm.menu.option.LoginOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.model.Client;


public class MenuIdentification {

	private static final String MENU_TITRE_LIBELLE = "Application Pizzeria Client - Identification";
	private Map<Integer, AbstractOptionMenuClient> options = new TreeMap<Integer, AbstractOptionMenuClient>();
	private Scanner sc;
	
	public MenuIdentification(Scanner sc, IFactoryDao factoryDao) {
		super();
		initialiserOptions(sc, factoryDao);
		this.sc = sc;
	}

	private void initialiserOptions(Scanner scanner, IFactoryDao factoryDao) {
		options.put(1, new InscriptionOptionMenu(scanner,factoryDao));
		options.put(2, new LoginOptionMenu(scanner,factoryDao));
		options.put(99, new QuitterOptionMenu());
	}

	public void afficher() {
		boolean continuer = true;
		while (continuer) {
			System.out.println("**** " + MENU_TITRE_LIBELLE + " ****");
			
			options.forEach((cle,valeur) -> System.out.println(cle + ". " + valeur.getLibelle()));
						
			int saisie = sc.nextInt();
			continuer = options.get(saisie).execute();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
