package fr.pizzeria.console;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoFichierImpl;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.dao.PizzaDaoJDBCImpl;
import fr.pizzeria.ihm.menu.Menu;

public class PizzaAdminApp {
	static IPizzaDao daoImpl;
	
	public static void main(String[] args) throws IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);

		try (Scanner sc = new Scanner(System.in)) {
			switch (daoImplConf){
			case(0):
				daoImpl = new PizzaDaoImpl();
				break;
			case(1):
				daoImpl = new PizzaDaoFichierImpl();
				break;
			case(2):
				daoImpl = new PizzaDaoJDBCImpl();
			}
			Menu menu = new Menu(sc, daoImpl);
			menu.afficher();
		}

	}

}
