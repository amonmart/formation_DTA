package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Pizza;

@Repository
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class PizzaDaoBatch {
	@PersistenceContext EntityManager em;
	
	public void importPizza(List<Pizza> pizzas){
		pizzas.forEach(p -> em.persist(p));
	}
}
