package fr.pizzeria.ihm.menu.option;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class MettreAJourPizzaOptionMenu extends AbstractOptionMenu {

	private static final String MAJ_PIZZA_LIBELLE_MENU = "Mettre à jour une Pizza";

	public MettreAJourPizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(MAJ_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
	}
	
	@Override
	public boolean execute() {

		new ListerPizzaOptionMenu(pizzaDao).execute();
		
		System.out.println("Veuillez choisir la pizza à modifier. (99 pour abandonner)");
		String codePizza = sc.next();
		
		Pizza updatePizza = new Pizza();
		System.out.println("Veuillez saisir le nouveau code");
		updatePizza.setCode(sc.next());
		System.out.println("Veuillez saisir le nouveau nom (sans espace)");
		updatePizza.setNom(sc.next());
		System.out.println("Veuillez saisir le prix");
		updatePizza.setPrix(sc.nextBigDecimal());
		System.out.println("Veuillez saisir la catégorie");
		CategoriePizza[] categoriePizzas = CategoriePizza.values();
		Arrays.asList(categoriePizzas)
				.forEach(cat -> System.out.println(cat.ordinal() + " -> " + cat.getLibelle()));
		int saisieCategorie = sc.nextInt();
		updatePizza.setCategorie(categoriePizzas[saisieCategorie]);
		
		try {
			pizzaDao.updatePizza(codePizza, updatePizza);
			System.out.println("Pizza mise à jour");
		} catch (SavePizzaException e) {
			System.err.println("Echec mise à jour pizza");
		} catch (UpdatePizzaException e) {
			System.err.println("Echec mise à jour pizza");
		} catch (DaoException e) {
			e.printStackTrace();
			System.err.println("Echec mise à jour pizza");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Echec mise à jour pizza : SQL Exception");
		}


			
	

		return true;
	} 

}
