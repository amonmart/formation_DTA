package fr.pizzeria.admin.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoMemoire;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@WebServlet("/login")
public class IdentifierController extends HttpServlet {
	@Inject private PizzaService pizzaService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Pizza> pizzas = pizzaService.findAllPizzas();
			req.setAttribute("listePizza", pizzas);
			
			RequestDispatcher rqd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/identifier.jsp");
			// /WEB-INF/views/pizzas/listerPizzas.jsp
			rqd.forward(req, resp);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String identifiant = req.getParameter("identifiant");
		String motDePasse = req.getParameter("motDePasse");
		HttpSession session = req.getSession();
		
		if(identifiant.equals("admin") && motDePasse.equals("admin123") ){
			session.setAttribute("identifie", true);
			resp.setStatus(201);
			resp.sendRedirect(req.getContextPath()+"/pizzas/list");
		}else{
			session.setAttribute("identifie", false);
			resp.setStatus(200);
			resp.sendRedirect(req.getContextPath()+"/login");
		}
	}

	
}
