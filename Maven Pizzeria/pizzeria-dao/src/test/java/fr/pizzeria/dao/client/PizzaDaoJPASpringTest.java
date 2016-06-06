package fr.pizzeria.dao.client;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.config.PizzaDaoConfigTestJPA;
import fr.pizzeria.dao.IFactoryDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PizzaDaoConfigTestJPA.class)
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class PizzaDaoJPASpringTest extends PizzaDaoTest {
	
	@Autowired
	public void setPizzaDao(@Qualifier("factoryDaoJPASpring") IFactoryDao factoryDao){
		this.pizzaDao = factoryDao.getPizzaDao();
		this.NOMBRE_PIZZA_INITIAL = 5;
	}
}
