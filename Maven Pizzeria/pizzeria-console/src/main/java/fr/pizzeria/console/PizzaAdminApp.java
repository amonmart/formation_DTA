package fr.pizzeria.console;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

import java.util.logging.Level;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;
import fr.pizzeria.dao.pizza.PizzaDaoHTTP;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.dao.pizza.PizzaDaoJDBCImpl;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;
import fr.pizzeria.ihm.menu.Menu;

public class PizzaAdminApp {
	static IPizzaDao daoImpl;

	private PizzaAdminApp() {
	}

	public static void main(String[] args) throws IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);

		try (Scanner sc = new Scanner(System.in)) {
			switch (daoImplConf) {
			case 0:
				daoImpl = new PizzaDaoImpl();
				System.err.println("Veuillez configurer l'application avec une implémentation base de données.");
				break;
			case 1:
				daoImpl = new PizzaDaoFichierImpl();
				System.err.println("Veuillez configurer l'application avec une implémentation base de données.");
				break;
			case 2:
				daoImpl = new PizzaDaoJDBCImpl();
				break;
			case 3:
				java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console");
				daoImpl = new PizzaDaoJpa(emf);
				break;
			case 4:
				daoImpl = new PizzaDaoHTTP();
				break;
			default:
				daoImpl = new PizzaDaoImpl();
				System.err.println("Veuillez configurer l'application avec une implémentation base de données.");
				break;
			}
			Menu menu = new Menu(sc, daoImpl);
			menu.afficher();
		}

	}

}
