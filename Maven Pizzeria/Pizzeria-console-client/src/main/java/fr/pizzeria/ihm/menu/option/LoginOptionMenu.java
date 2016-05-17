package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.console.client.PizzeriaConsoleClientApp;
import fr.pizzeria.dao.FactoryDaoJPA;
import fr.pizzeria.dao.IFactoryDao;
import fr.pizzeria.ihm.menu.MenuCommandeClient;
import fr.pizzeria.ihm.menu.MenuIdentification;
import fr.pizzeria.model.Client;

/**
 */
public class LoginOptionMenu extends AbstractOptionMenuClient {

	private static final String LOGIN_LIBELLE_MENU = "S'identifier";

	public LoginOptionMenu(Scanner scanner, IFactoryDao factoryDao) {
		super(LOGIN_LIBELLE_MENU, factoryDao, scanner);
	}

	@Override
	public boolean execute() {
		boolean testLogin;
		Client loginClient = new Client();
		System.out.println("Veuillez saisir votre email");
		loginClient.setEmail(sc.next());
		System.out.println("Veuillez saisir votre mot de passe");
		loginClient.setMotDePasse(sc.next());

		loginClient = factoryDao.getClientDao().getClient(loginClient.getEmail());
		testLogin = factoryDao.getClientDao().loginClient(loginClient.getMotDePasse(),loginClient);
		if (testLogin){
			System.out.println("Identification réussie");
			MenuCommandeClient menu = new MenuCommandeClient(sc, new FactoryDaoJPA(PizzeriaConsoleClientApp.getEMF()), loginClient);
			menu.afficher();
			
		}else{
			System.out.println("Email inconnu");
		}
		return true;
	}

	@Override
	public boolean execute(Client client) {
		//NE FAIT RIEN
		return false;
	}

}
