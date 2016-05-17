package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IFactoryDao;
import fr.pizzeria.model.Client;

public abstract class AbstractOptionMenuClient {
	private String libelle;
	protected IFactoryDao factoryDao;
	protected Scanner sc;
	
	public AbstractOptionMenuClient(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public AbstractOptionMenuClient(String libelle, IFactoryDao factoryDao) {
		this(libelle);
		this.factoryDao = factoryDao;
	}

	public AbstractOptionMenuClient(String libelle, IFactoryDao factoryDao, Scanner sc) {
		this(libelle, factoryDao);
		this.sc = sc;
	}

	public abstract boolean execute();
	public abstract boolean execute(Client client);

	public String getLibelle() {
		return libelle;
	}
	
}
