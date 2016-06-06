package fr.pizzeria.dao.client;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.config.PizzaDaoConfigTestPerformances;
import fr.pizzeria.dao.FactoryDaoDataJpa;
import fr.pizzeria.dao.performance.PerformanceDaoDataJpa;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.preformance.Performance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PizzaDaoConfigTestPerformances.class)
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class PerformanceDaoTest {
	
	protected static int NOMBRE_PERF_INITIAL = 3;
	protected @Autowired PerformanceDaoDataJpa perfDao;
	protected @Autowired @Qualifier("factoryDaoDataJpa") FactoryDaoDataJpa factoryDaoDataJpa;
	
	@Test
	public void testfindAllPerformances(){
		List<Performance> performances = perfDao.findAllPerformances();
		Assert.assertEquals(NOMBRE_PERF_INITIAL, performances.size());
	}
	
	@Test
	public void testSavePerformances() throws DaoException, SQLException{
		Calendar date = Calendar.getInstance();
		long time = 1000;
		String service = "serviceTest";
		Performance perf = new Performance(service, date, time);
		perfDao.savePerformance(perf);
		List<Performance> performances = perfDao.findAllPerformances();
		Assert.assertEquals(NOMBRE_PERF_INITIAL + 1, performances.size());
	}
	
	@Test
	public void testSavePerformancesViaFactory() throws DaoException, SQLException{
		factoryDaoDataJpa.getPizzaDao().findAllPizzas();
		List<Performance> performances = perfDao.findAllPerformances();
		Assert.assertEquals(NOMBRE_PERF_INITIAL + 1, performances.size());
	}
	
	
}
