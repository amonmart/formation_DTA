package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class SaisirDonneesPizza {
	
	public Pizza saisirDonneesPizza(Scanner sc) {
		Pizza p = new Pizza();
		System.out.println("Veuillez saisir le code");
		String newCode = sc.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String newNom = sc.next();
		System.out.println("Veuillez saisir le prix");
		double newPrix = sc.nextDouble();
		p.modifier(newCode, newNom, newPrix);
		return p;
	}

}
