package fr.pizzeria.ihm.menu.option;

import java.sql.SQLException;
import java.util.Comparator;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class ImporterPizzasFichiersOptionMenu extends AbstractOptionMenu {

	private static final String IMPORTER_PIZZAS_LIBELLE_MENU = "Importer des pizzas";

	public ImporterPizzasFichiersOptionMenu(IPizzaDao pizzaDao) {
		super(IMPORTER_PIZZAS_LIBELLE_MENU, pizzaDao);
	}

	@Override
	public boolean execute() {
		System.out.println("Importer des pizza");
		try {
			pizzaDao.importPizza();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
