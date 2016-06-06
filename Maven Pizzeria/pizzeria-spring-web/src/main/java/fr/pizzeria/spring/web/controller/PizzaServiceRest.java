package fr.pizzeria.spring.web.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.pizzeria.dao.IFactoryDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Controller
@RequestMapping("/pizzas")
public class PizzaServiceRest {
	@Autowired IFactoryDao factoryDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Pizza> getListPizza() throws DaoException, SQLException{
		return factoryDao.getPizzaDao().findAllPizzas();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postPizza(){
		return null;
	}
}
