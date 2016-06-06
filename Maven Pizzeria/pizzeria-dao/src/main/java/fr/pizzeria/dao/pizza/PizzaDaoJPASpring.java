package fr.pizzeria.dao.pizza;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Repository
@Transactional
public class PizzaDaoJPASpring implements IPizzaDao {
	
	@PersistenceContext EntityManager em;
	@Autowired PizzaDaoBatch batch;
	
	@Override
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		return query.getResultList();
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		em.persist(newPizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException {
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code = '" + codePizza + "'",
				Pizza.class);
		Pizza p = query.getSingleResult();
		p.setCode(updatePizza.getCode());
		p.setNom(updatePizza.getNom());
		p.setPrix(updatePizza.getPrix());
		p.setCategorie(updatePizza.getCategorie());
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code = '" + codePizza + "'",
				Pizza.class);
		Pizza p = query.getSingleResult();
		em.remove(p);
	}

	@Override
	public void importPizza(List<Pizza> pizzas) throws DaoException, SQLException {
		ListUtils.partition(pizzas, 3).forEach(batch::importPizza);
	}
	
	

	@Override
	public Pizza findPizza(String codePizza) {
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code = '" + codePizza + "'",
				Pizza.class);
		return query.getSingleResult();
	}

}
