package fr.pizzeria.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaServletWebApi extends HttpServlet {
	private IPizzaDao pizzaDao = new PizzaDaoImpl();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		try {
			List<Pizza> pizzas = pizzaDao.findAllPizzas();
			PrintWriter out = resp.getWriter();
		     out.println("<h1>"+pizzas.toString() +"</h1>");
		} catch (DaoException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			try {
				resp.sendError(501);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		String categorie = req.getParameter("categorie");
		
		Pizza p = new Pizza(code,nom,new BigDecimal(prix));
		try {
			pizzaDao.savePizza(p);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
