package fr.pizzeria.ihm.menu;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImp;
import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.menu.option.*;

public class Menu {
	private static final String ADMINISTRATION_PIZZERIA_TITRE = "Administration Pizzeria";
	private AbstractOptionMenu[] options;
	private Scanner sc;

	public Menu(Scanner scanner, PizzaDaoImp pizzaDao) {
		super();
		initialiserOptions(scanner, pizzaDao);
		this.sc = scanner;
	}

	private void initialiserOptions(Scanner scanner, PizzaDaoImp iPizza){
		this.options = new AbstractOptionMenu[]{
				new ListerPizzaOptionMenu(iPizza, scanner), 
				new NouvellePizzaOptionMenu(iPizza, scanner),
				new ModifierPizzaOptionMenu(iPizza, scanner),
				new SupprimerPizzaOptionMenu(iPizza, scanner),
				new QuitterOptionMenu(iPizza, scanner)
		};
	}
	
	public void afficher(){
		boolean continuer = true;
		while (continuer){
			System.out.println("*****" + ADMINISTRATION_PIZZERIA_TITRE + "*****");
			for(int i = 0; i < options.length; i++){
				AbstractOptionMenu opt = options[i];
				System.out.println(i + " . " + opt.getLibelle());
			}
			int saisie = sc.nextInt();
			try {
				continuer = options[saisie].execute();
			} catch (DaoException e){
				e.printStackTrace();
			}
			
		}
	}
	
	
	
}
