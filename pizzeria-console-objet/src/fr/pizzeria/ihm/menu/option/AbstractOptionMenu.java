package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImp;
import fr.pizzeria.dao.iPizzaDao;
import fr.pizzeria.exception.*;

public abstract class AbstractOptionMenu {
	private String libelle;
	protected iPizzaDao pizzaDao;
	protected Scanner sc;
	
	public AbstractOptionMenu(String libelle, PizzaDaoImp iP, Scanner sc) {
		super();
		this.libelle = libelle;
		this.pizzaDao = iP;
		this.sc = sc;
	}
	
	public abstract boolean execute() throws DaoException;
	
	public String getLibelle() {
		return libelle;
	}
}
