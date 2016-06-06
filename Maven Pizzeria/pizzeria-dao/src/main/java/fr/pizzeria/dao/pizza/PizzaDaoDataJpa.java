package fr.pizzeria.dao.pizza;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.dao.repository.IPizzaRepository;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Repository
@Transactional
public class PizzaDaoDataJpa implements IPizzaDao {
	
	@Autowired IPizzaRepository pizzaRepository;
	@PersistenceContext EntityManager em;
	
	@Override
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		return pizzaRepository.findAll();
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		pizzaRepository.save(newPizza);

	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException {
		this.deletePizza(codePizza);
		this.savePizza(updatePizza);
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		Pizza p = findPizza(codePizza);
		pizzaRepository.delete(p);
	}

	@Override
	public void importPizza(List<Pizza> pizzas) throws DaoException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Pizza findPizza(String codePizza) {
		return pizzaRepository.findByCode(codePizza);
	}

}
