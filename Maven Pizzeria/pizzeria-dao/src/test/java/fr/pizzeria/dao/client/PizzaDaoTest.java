package fr.pizzeria.dao.client;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.config.PizzaDaoConfigTestGeneral;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PizzaDaoConfigTestGeneral.class)
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class PizzaDaoTest {
	
	protected static int NOMBRE_PIZZA_INITIAL;
	protected IPizzaDao pizzaDao;
	
	@Test
	public void testfindAllPizzas() throws DaoException, SQLException{
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		Assert.assertEquals(NOMBRE_PIZZA_INITIAL, pizzas.size());
	}
	
	@Test
	public void testSavePizza() throws DaoException, SQLException{
		Pizza p = new Pizza("FFF", "Pizza1", new BigDecimal("12") , CategoriePizza.VIANDE);
		pizzaDao.savePizza(p);
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		Assert.assertEquals(NOMBRE_PIZZA_INITIAL + 1, pizzas.size());
	}
	
	@Test
	public void testDeletePizza() throws DaoException, SQLException {
		Pizza p = new Pizza("FFF", "Pizza1", new BigDecimal("12") , CategoriePizza.VIANDE);
		pizzaDao.savePizza(p);
		pizzaDao.deletePizza("FFF");
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		Assert.assertEquals(NOMBRE_PIZZA_INITIAL, pizzas.size());
	}
	
	@Test
	public void testUpdatePizza() throws DaoException, SQLException {
		Pizza p = new Pizza("FFF", "Pizza1", new BigDecimal("12") , CategoriePizza.VIANDE);
		Pizza p2 = new Pizza("GGG", "Pizza1", new BigDecimal("12") , CategoriePizza.VIANDE);
		pizzaDao.savePizza(p);
		pizzaDao.updatePizza("FFF", p2);
		Pizza pizza = pizzaDao.findPizza("GGG");
		Assert.assertEquals("GGG", pizza.getCode());
	}
	
	@Test
	public void testfindPizza() throws DaoException, SQLException {
		Pizza p = new Pizza("FFF", "Pizza1", new BigDecimal("12") , CategoriePizza.VIANDE);
		pizzaDao.savePizza(p);
		Pizza pizza = pizzaDao.findPizza("FFF");
		Assert.assertEquals("FFF", pizza.getCode());
	}
	
	@Test
	public void testImportPizza() throws DaoException, SQLException{
		List<Pizza> pizzas = new ArrayList<>();
		pizzas.add(new Pizza("FFF", "Pizza1", new BigDecimal("12") , CategoriePizza.VIANDE));
		pizzas.add(new Pizza("GGG", "Pizza2", new BigDecimal("12") , CategoriePizza.VIANDE));
		pizzas.add(new Pizza("HHH", "Pizza3", new BigDecimal("12") , CategoriePizza.VIANDE));
		pizzaDao.importPizza(pizzas);
		pizzas = pizzaDao.findAllPizzas();
		Assert.assertEquals(NOMBRE_PIZZA_INITIAL + 3, pizzas.size());
	}
	
	@Test
	public void testImportPizzaFail() throws DaoException, SQLException {
		List<Pizza> pizzas = new ArrayList<>();
		pizzas.add(new Pizza("FFF", "Pizza1", new BigDecimal("12") , CategoriePizza.VIANDE));
		pizzas.add(new Pizza("GGG", "Pizza2", new BigDecimal("12") , CategoriePizza.VIANDE));
		pizzas.add(new Pizza("HHH", "Pizza3", new BigDecimal("12") , CategoriePizza.VIANDE));
		pizzas.add(new Pizza("III", "Pizza4", new BigDecimal("12") , CategoriePizza.VIANDE));
		pizzas.add(new Pizza("III", "Pizza5", new BigDecimal("12") , CategoriePizza.VIANDE));
		pizzas.add(new Pizza("JJJ", "Pizza6", new BigDecimal("12") , CategoriePizza.VIANDE));
		try{
			pizzaDao.importPizza(pizzas);
			Assert.fail("Une exception aurait du être lancée !!!");
		}catch(Exception e){
			List<Pizza> pizzasFound = pizzaDao.findAllPizzas();
			Assert.assertEquals(NOMBRE_PIZZA_INITIAL + 3, pizzas.size());
		}
	}
	
	
}
