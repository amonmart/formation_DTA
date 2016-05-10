package fr.pizzeria.console;

import java.io.IOException;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.model.Pizza;


public class PizzaAdminApp {

	public static void main(String[] args) throws IOException {
		


		Pizza pizza1 = new Pizza();
		Pizza pizza2 = new Pizza();
		
		pizza1.equals(pizza2);
		
		try(Scanner sc = new Scanner(System.in)) {
			IPizzaDao dao = new PizzaDaoImpl();
			Menu menu = new Menu(sc,dao);
			menu.afficher();
		}
		
	}

}
