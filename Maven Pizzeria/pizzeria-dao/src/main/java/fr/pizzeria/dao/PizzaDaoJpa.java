package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IPizzaDao {
	private EntityManagerFactory emf;
	
	public PizzaDaoJpa() {
	}
	
	public PizzaDaoJpa(EntityManagerFactory em){
		this.emf = em;
	}
	
	@Override
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		EntityManager entityManager = emf.createEntityManager();
		Query query = entityManager.createQuery("select p from Pizza p");
		List<Pizza> pizzas = (List <Pizza>) query.getResultList();
		entityManager.close();
		return pizzas;
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		entityManager.persist(newPizza);
		et.commit();
		entityManager.close();
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		TypedQuery<Pizza> query = entityManager.createQuery("select p from Pizza p where p.code = '"+codePizza+"'"
				, Pizza.class);
		Pizza p = (Pizza) query.getSingleResult();
		p.setCode(updatePizza.getCode());
		p.setNom(updatePizza.getNom());
		p.setPrix(updatePizza.getPrix());
		p.setCategorie(updatePizza.getCategorie());
		et.commit();
		entityManager.close();
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		TypedQuery<Pizza> query = entityManager.createQuery("select p from Pizza p where p.code = '"+codePizza+"'"
				, Pizza.class);
		Pizza p = (Pizza) query.getSingleResult();
		entityManager.remove(p);
		et.commit();
		entityManager.close();
		
	}

	@Override
	public void importPizza() throws DaoException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
