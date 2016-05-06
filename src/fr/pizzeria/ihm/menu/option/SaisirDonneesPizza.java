package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.model.*;

public class SaisirDonneesPizza {
	
	public Pizza saisirDonneesPizza(Scanner sc) {
		Pizza p = new Pizza();
		System.out.println("Veuillez saisir le code");
		String newCode = sc.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String newNom = sc.next();
		System.out.println("Veuillez saisir le prix");
		double newPrix = sc.nextDouble();
		System.out.println("Veuillez saisir la catégorie de la pizza");
		for(CategoriePizza categories : CategoriePizza.values()){
			System.out.println(categories.getNum() + " . " + categories.getLabelle());
		}
		int newCategorie = sc.nextInt();
		p.modifier(newCode, newNom, newPrix, CategoriePizza.getCategorieByInt(newCategorie));
		return p;
	}

}
