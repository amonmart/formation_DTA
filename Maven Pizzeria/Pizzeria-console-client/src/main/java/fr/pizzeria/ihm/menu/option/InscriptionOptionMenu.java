package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IFactoryDao;
import fr.pizzeria.model.Client;

/**
 */
public class InscriptionOptionMenu extends AbstractOptionMenuClient {

	private static final String INSCRIPTION_LIBELLE_MENU = "S'inscrire";

	public InscriptionOptionMenu(Scanner scanner, IFactoryDao factoryDao) {
		super(INSCRIPTION_LIBELLE_MENU, factoryDao, scanner);
	}

	@Override
	public boolean execute() {

		Client newClient = new Client();
		System.out.println("Veuillez saisir votre nom");
		newClient.setNom(sc.next());
		System.out.println("Veuillez saisir votre prénom (sans espace)");
		newClient.setPrenom(sc.next());;
		System.out.println("Veuillez saisir votre e-mail");
		newClient.setEmail(sc.next());
		System.out.println("Veuillez saisir votre mot de passe");
		newClient.setMotDePasse(sc.next());

		factoryDao.getClientDao().saveClient(newClient);
		
		return true;
	}

	@Override
	public boolean execute(Client client) {
		//NE FAIT RIEN
		return false;
	}

}
