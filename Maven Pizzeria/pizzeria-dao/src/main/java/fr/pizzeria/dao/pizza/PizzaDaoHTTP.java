package fr.pizzeria.dao.pizza;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoHTTP implements IPizzaDao {
	private Client client = ClientBuilder.newClient();
	private WebTarget target = client.target("http://localhost:8080/pizzeria-admin-app");
	
	@Override
	public List<Pizza> findAllPizzas() throws DaoException, SQLException {
		Invocation.Builder builder = target.path("api").path("pizzas").request();
		List<Pizza> response = builder.get(new GenericType<List<Pizza>>(){});
		return response;
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		Invocation.Builder builder = target.path("api").path("pizzas").request();
		Response post = builder.post(Entity.entity(newPizza, MediaType.APPLICATION_JSON));
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException {
		Invocation.Builder builder = target.path("api").path("pizzas").request();
		Response put = builder.put(Entity.entity(updatePizza, MediaType.APPLICATION_JSON));
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		Invocation.Builder builder = target.path("api").path("pizzas").path(codePizza).request();
		builder.delete();	
	}

	@Override
	public void importPizza() throws DaoException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pizza findPizza(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}
}
