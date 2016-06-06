package fr.pizzeria.performance;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformancePointCoupe {
	
	@Pointcut("execution(* fr.pizzeria.dao.pizza.*.*(..))")
	public void toutesLesMethodesDao(){}
}
