package fr.pizzeria.dao.client;


import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;

public interface IClientDao {
	
	public void saveClient(Client newClient);
	public boolean loginClient(String motDePasse, Client email);
	public List<Commande> listerCommandes(Client client);
	public void commanderPizza(Commande commande);
	public Client getClient(String email);
}
