package fr.pizzeria.admin.metier;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Element;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Stateless
@TransactionManagement
public class PizzaService {
	private static final String REPERTOIRE_DATA = "data";
	@Inject private IPizzaDao pizzaDao;
	@PersistenceContext(unitName="pizzeria") private EntityManager em;
	
	@TransactionAttribute
	public Pizza findPizza(String code) throws DaoException, SQLException{
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		return query.getSingleResult();
	}
	
	
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		return pizzas; 
	}
	
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException {
		deletePizza(codePizza);
		savePizza(updatePizza);
	}
	
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		em.persist(newPizza);
	}
	
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code = '" + codePizza + "'",
				Pizza.class);
		Pizza p = query.getSingleResult();
		em.remove(p);

	}
	
	public void importPizza() throws DaoException, SQLException {
		List<Pizza> pizzas;
		List<List<Pizza>> test = new ArrayList<List<Pizza>>();
		try {
			pizzas = Files.list(Paths.get(REPERTOIRE_DATA)).map(path -> {
				Pizza p = new Pizza();
				p.setCode(path.getFileName().toString().replaceAll(".txt", ""));
				try {
					String ligne = Files.readAllLines(path).get(0);
					String[] ligneTab = ligne.split(";");
					p.setNom(ligneTab[0]);
					p.setPrix(new BigDecimal(ligneTab[1]));
					p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
				} catch (Exception e) {
					e.printStackTrace();
				}

				return p;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new DaoException(e);
		}
		test = ListUtils.partition(pizzas, 3);

		for (List<Pizza> listPizza : test) {
			for (Pizza pizza : listPizza) {
				savePizza(pizza);
			}
		}
	}
	
}
