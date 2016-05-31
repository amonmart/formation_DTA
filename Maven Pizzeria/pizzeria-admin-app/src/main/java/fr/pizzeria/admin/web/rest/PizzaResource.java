package fr.pizzeria.admin.web.rest;

import java.sql.SQLException;
import java.util.List;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaResource {
	@Inject private PizzaService pizzaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> lister() throws DaoException, SQLException{
		return pizzaService.findAllPizzas();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void creer(Pizza newPizza) throws DaoException, SQLException{
		pizzaService.savePizza(newPizza);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Pizza updatePizza) throws DaoException, SQLException{
		pizzaService.updatePizza(updatePizza.getCode(), updatePizza);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/code")
	public void delete(@PathParam("code") String codePizza) throws DaoException, SQLException{
		pizzaService.deletePizza(codePizza);
	}
}
