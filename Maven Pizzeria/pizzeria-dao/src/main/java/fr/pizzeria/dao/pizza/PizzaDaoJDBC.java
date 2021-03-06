package fr.pizzeria.dao.pizza;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Repository
@Transactional
public class PizzaDaoJDBC implements IPizzaDao {

	@Override
	public List<Pizza> findAllPizzas() throws SQLException {
		List<Pizza> pizzas = new ArrayList<>();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "antonin",
				"antonin123");
		Statement statement = connection.createStatement();
		ResultSet resultats = statement.executeQuery("SELECT `code`, `nom`,`prix`,`CATEGORIE` FROM pizza");
		while (resultats.next()) {
			String code = resultats.getString("code");
			String nom = resultats.getString("nom");
			BigDecimal prix = resultats.getBigDecimal("prix");
			CategoriePizza cat = CategoriePizza.valueOf(resultats.getString("CATEGORIE"));

			pizzas.add(new Pizza(code, nom, prix, cat));
		}
		statement.close();
		connection.close();
		resultats.close();
		
		return pizzas;
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException, SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "antonin","antonin123");
		PreparedStatement statement = connection.prepareStatement("SELECT `code` FROM pizza WHERE `code` LIKE ?");
		statement.setString(1, newPizza.getCode());
		ResultSet resultats = statement.executeQuery();
		if (!resultats.next()){
			throw new SavePizzaException("code pizza déjà présent");
		}
		statement = connection.prepareStatement("INSERT INTO `pizza` (`code`, `nom`, `prix`, `CATEGORIE`) VALUES (?, ?, ?, ?)");
		statement.setString(1, newPizza.getCode());
		statement.setString(2, newPizza.getNom());
		statement.setBigDecimal(3, newPizza.getPrix());
		statement.setString(4, newPizza.getCategorie().getLibelle().toUpperCase());
		statement.executeUpdate();
		
		statement.close();
		connection.close();
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "antonin","antonin123");
		PreparedStatement statement = connection.prepareStatement("SELECT `code` FROM pizza WHERE `code` LIKE ?");
		statement.setString(1, codePizza);
		ResultSet resultats = statement.executeQuery();
		if (!resultats.next()){
			throw new UpdatePizzaException("code pizza non trouvé");
		}
		statement = connection.prepareStatement("UPDATE `pizza` SET `code` = ?, `nom`= ?, `prix` = ?, `CATEGORIE` = ? WHERE `code` LIKE ?");
		statement.setString(1, updatePizza.getCode());
		statement.setString(2, updatePizza.getNom());
		statement.setBigDecimal(3, updatePizza.getPrix());
		statement.setString(4, updatePizza.getCategorie().getLibelle().toUpperCase());
		statement.setString(5, codePizza);
		statement.executeUpdate();
		
		statement.close();
		connection.close();
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "antonin","antonin123");
		PreparedStatement statement = connection.prepareStatement("SELECT `code` FROM pizza WHERE `code` LIKE ?");
		statement.setString(1, codePizza);
		ResultSet resultats = statement.executeQuery();
		if (!resultats.next()){
			throw new DeletePizzaException("code pizza non trouvé");
		}
		statement = connection.prepareStatement("DELETE FROM `pizza` WHERE `code` LIKE ?");
		statement.setString(1, codePizza);
		statement.executeUpdate();
		
		statement.close();
		connection.close();
	}
	
	public void importPizza(List<Pizza> pizzas) throws DaoException, SQLException{
		/*
		IPizzaDao pizzaDaoFichier = new PizzaDaoFichierImpl();
		List<Pizza> pizzas = new ArrayList<>();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "antonin","antonin123");
		connection.setAutoCommit(false);
		
		ListUtils.partition(pizzas, 3).forEach();
		statement.setString(1, updatePizza.getCode());
		statement.setString(2, updatePizza.getNom());
		statement.setDouble(3, updatePizza.getPrix());
		statement.setString(4, updatePizza.getCategorie().getLibelle().toUpperCase());
		pizzas = pizzaDaoFichier.findAllPizzas();
		*/
		
		
		
	}

	@Override
	public Pizza findPizza(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	 
}
