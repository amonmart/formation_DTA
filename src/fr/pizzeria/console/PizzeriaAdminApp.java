package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImp;
import fr.pizzeria.ihm.menu.Menu;

public class PizzeriaAdminApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PizzaDaoImp pizzaDao = new PizzaDaoImp();
		Menu m = new Menu(sc, pizzaDao);
		
		m.afficher();

	}

}
