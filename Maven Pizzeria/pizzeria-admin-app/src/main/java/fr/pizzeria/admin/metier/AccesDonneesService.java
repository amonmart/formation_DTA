package fr.pizzeria.admin.metier;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.admin.web.IdentifierController;
import fr.pizzeria.model.Pizza;

@Stateless
@TransactionManagement
public class AccesDonneesService <E> {
	
	@PersistenceContext(unitName="pizzeria") private EntityManager em;
/*	
	public E findAll(){
		TypedQuery<E> query = em.createQuery("select p from Pizza p", <E>);
		return query.getSingleResult();
	}
	*/
}
