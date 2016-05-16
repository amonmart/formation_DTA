package fr.pizzeria.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IPizzaDao {
	private EntityManagerFactory emf;
	private static final String REPERTOIRE_DATA = "data";

	public PizzaDaoJpa() {
	}

	public PizzaDaoJpa(EntityManagerFactory em) {
		this.emf = em;
	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		EntityManager entityManager = emf.createEntityManager();
		Query query = entityManager.createQuery("select p from Pizza p");
		List<Pizza> pizzas = (List<Pizza>) query.getResultList();
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
		TypedQuery<Pizza> query = entityManager.createQuery("select p from Pizza p where p.code = '" + codePizza + "'",
				Pizza.class);
		Pizza p = query.getSingleResult();
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
		TypedQuery<Pizza> query = entityManager.createQuery("select p from Pizza p where p.code = '" + codePizza + "'",
				Pizza.class);
		Pizza p = query.getSingleResult();
		entityManager.remove(p);
		et.commit();
		entityManager.close();

	}

	@Override
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
