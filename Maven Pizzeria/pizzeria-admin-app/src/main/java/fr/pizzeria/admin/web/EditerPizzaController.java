package fr.pizzeria.admin.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {
	private IPizzaDao pizzaDao = IPizzaDao.IMPLEMENTATION;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			RequestDispatcher rqd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
			String code = (String) req.getParameter("code");
			Pizza pizza = pizzaDao.findPizza(code);
			req.setAttribute("pizza", pizza);
			
			rqd.forward(req, resp); 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = (String) req.getParameter("code");
		String nom = (String) req.getParameter("nom");
		BigDecimal prix = new BigDecimal( req.getParameter("prix"));
		Pizza pizza = new Pizza(code, nom, prix);
		try {
			pizzaDao.updatePizza(code, pizza);
			resp.setStatus(201);
			resp.sendRedirect(req.getContextPath()+"/pizzas/list");
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
