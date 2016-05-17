package fr.pizzeria.ihm.menu.option;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.Scanner;

import fr.pizzeria.dao.IFactoryDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;

/**
 */
public class ListerCommandesOptionMenu extends AbstractOptionMenuClient {

	private static final String INSCRIPTION_LIBELLE_MENU = "Voir vos commandes";

	public ListerCommandesOptionMenu(Scanner scanner, IFactoryDao factoryDao) {
		super(INSCRIPTION_LIBELLE_MENU, factoryDao, scanner);
	}

	@Override
	public boolean execute() {
		//NE FAIT RIEN
		return true;
	}

	@Override
	public boolean execute(Client client) {
			factoryDao.getClientDao().listerCommandes(client).stream()
				.forEach(System.out::println);
		return true;
	}

}
