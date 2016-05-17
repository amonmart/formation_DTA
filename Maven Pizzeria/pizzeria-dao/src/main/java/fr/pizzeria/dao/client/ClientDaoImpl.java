package fr.pizzeria.dao.client;

import java.util.List;
import java.util.Set;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;

public class ClientDaoImpl implements IClientDao {

	public ClientDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveClient(Client newClient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loginClient(String motDePasse, Client email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Commande> listerCommandes(Client client) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client getClient(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void commanderPizza(Commande commande) {
		// TODO Auto-generated method stub
		
	}

}
