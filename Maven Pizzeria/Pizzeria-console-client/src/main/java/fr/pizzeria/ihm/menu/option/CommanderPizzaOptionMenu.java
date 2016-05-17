package fr.pizzeria.ihm.menu.option;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import fr.pizzeria.dao.IFactoryDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;

/**
 */
public class CommanderPizzaOptionMenu extends AbstractOptionMenuClient {

	private static final String INSCRIPTION_LIBELLE_MENU = "Commander une pizza";

	public CommanderPizzaOptionMenu(Scanner scanner, IFactoryDao factoryDao) {
		super(INSCRIPTION_LIBELLE_MENU, factoryDao, scanner);
	}

	@Override
	public boolean execute() {
		//NE FAIT RIEN
		return true;
	}

	@Override
	public boolean execute(Client client) {
		Commande commande = new Commande();
		boolean testFinCommande = false;
		Set<Pizza> pizzaCommande = new HashSet<Pizza>();
		Integer i;
		try {
			factoryDao.getPizzaDao().findAllPizzas().stream()
				.sorted(Comparator.comparing(Pizza::getCode))
				.forEach(System.out::println);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Veuillez saisir le code de la pizza à commander");
		while (!testFinCommande) {
			pizzaCommande.add(factoryDao.getPizzaDao().findPizza(sc.next()));
			System.out.println("Voulez-vous commander une autre pizza? 1. Oui 2.Non");
			System.out.println("1. Oui");
			System.out.println("2. Non");
			i = sc.nextInt(); 
			switch (i) {
			case 1:
				System.out.println("Veuillez saisir le code de la nouvelle pizza à commander");
				break;
			default:
				testFinCommande = true;
				break;
			}
			commande.setClientId(client.getId());
			commande.setPizzas(pizzaCommande);
			factoryDao.getClientDao().commanderPizza(commande);
		}
		return true;
	}

}
