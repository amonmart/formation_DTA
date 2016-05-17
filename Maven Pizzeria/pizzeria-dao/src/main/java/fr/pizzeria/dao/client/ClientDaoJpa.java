package fr.pizzeria.dao.client;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;

public class ClientDaoJpa implements IClientDao{
	private EntityManagerFactory emf;
	
	public ClientDaoJpa(EntityManagerFactory em) {
		this.emf = em;
	}

	@Override
	public void saveClient(Client newClient) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		entityManager.persist(newClient);
		et.commit();
		entityManager.close();
	}
	
	@Override
	public Client getClient(String email){
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery<Client> query = entityManager.createQuery("select c from Client c where c.email = '"+email+"'", Client.class);
		Client c = query.getSingleResult();
		return c;
	}

	@Override
	public boolean loginClient(String motDePasse, Client client) {
		EntityManager entityManager = emf.createEntityManager();
		boolean reponse = false;
		TypedQuery<Client> query = entityManager.createQuery("select c from Client c where c.email = '"+client.getEmail()+"'", Client.class);
		Client c = query.getSingleResult();
		if (c.getMotDePasse().equals(motDePasse)){
			reponse = true;
		}
		entityManager.close();
		return reponse;
	}

	@Override
	public List<Commande> listerCommandes(Client client) {
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery query = entityManager.createQuery("select c from Commande c", Commande.class);
		List<Commande> commandes = query.getResultList();
		entityManager.close();
		return commandes;
	}

	@Override
	public void commanderPizza(Commande commande) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		entityManager.persist(commande);
		et.commit();
		entityManager.close();
	}

}
