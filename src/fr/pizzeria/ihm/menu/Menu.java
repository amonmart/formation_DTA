package fr.pizzeria.ihm.menu;

import java.util.*;
import java.util.Map.Entry;

import fr.pizzeria.dao.PizzaDaoImp;
import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.menu.option.*;

public class Menu {
	private static final String ADMINISTRATION_PIZZERIA_TITRE = "Administration Pizzeria";
	private Map<Integer,AbstractOptionMenu> options = new TreeMap<Integer,AbstractOptionMenu>();
	private Scanner sc;

	public Menu(Scanner scanner, PizzaDaoImp pizzaDao) {
		super();
		initialiserOptions(scanner, pizzaDao);
		this.sc = scanner;
	}

	private void initialiserOptions(Scanner scanner, PizzaDaoImp iPizza){
		this.options.put(1, new ListerPizzaOptionMenu(iPizza, scanner));
		this.options.put(2, new NouvellePizzaOptionMenu(iPizza, scanner));
		this.options.put(3, new ModifierPizzaOptionMenu(iPizza, scanner));
		this.options.put(4, new SupprimerPizzaOptionMenu(iPizza, scanner));
		this.options.put(99, new QuitterOptionMenu(iPizza, scanner));	
	}
	
	public void afficher(){
		boolean continuer = true;
		while (continuer){
			System.out.println("*****" + ADMINISTRATION_PIZZERIA_TITRE + "*****");
			for (Entry<Integer,AbstractOptionMenu> optionMenuEntry : options.entrySet() ){
				System.out.println(optionMenuEntry.getKey() + " ." + optionMenuEntry.getValue().getLibelle());
			}
			int saisie = sc.nextInt();
			try {
				continuer = options.get(saisie).execute();
			} catch (DaoException e){
				e.printStackTrace();
			}
			
		}
	}
	
	
	
}
