package fr.pizzeria.performance;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.performance.PerformanceDaoDataJpa;
import fr.pizzeria.preformance.Performance;

@Aspect
@Component
public class PerformanceDaoAspect {
	
	@Autowired private PerformanceDaoDataJpa performanceDao;
	
	@Around("fr.pizzeria.performance.PerformancePointCoupe.toutesLesMethodesDao()")
	public Object performanceAspect(ProceedingJoinPoint pjp) throws Throwable{
		Calendar date = Calendar.getInstance();
		long time;
		long startTime = System.nanoTime();
		Object valeurRetournee = pjp.proceed();
		long endTime = System.nanoTime();
		time = endTime - startTime;
		performanceDao.savePerformance(new Performance("pizzaDao", date, time));
		
		return valeurRetournee;
	}
}
