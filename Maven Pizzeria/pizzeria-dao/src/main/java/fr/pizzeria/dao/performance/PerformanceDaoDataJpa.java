package fr.pizzeria.dao.performance;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.repository.IPerformanceRepository;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.preformance.Performance;

@Repository
public class PerformanceDaoDataJpa {

	@Autowired IPerformanceRepository performanceRepository;
	@PersistenceContext EntityManager em;
	
	public List<Performance> findAllPerformances(){
		return performanceRepository.findAll();
	}
	
	public void savePerformance(Performance newPerformance) throws DaoException, SQLException {
		performanceRepository.save(newPerformance);

	}
}
