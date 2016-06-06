package fr.pizzeria.dao.pizza;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Repository
@Transactional
public class PizzaDaoJDBCTemplate implements IPizzaDao {

	private PlatformTransactionManager txManager;
	private TransactionTemplate txTemplate;
	private JdbcTemplate jdbcTemplate;
	
	public PizzaDaoJDBCTemplate(DataSource dataSource, PlatformTransactionManager txManager) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.txManager = txManager;
		this.txTemplate = new TransactionTemplate(txManager);
	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		String sql = "SELECT `id`, `code`, `nom`,`prix`,`CATEGORIE` FROM pizza";
		return this.jdbcTemplate.query(sql, new PizzaMapper());
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException {
		String sql = "INSERT INTO PIZZA (`code`, `nom`, `prix`, `categorie`) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, newPizza.getCode(), newPizza.getNom(), newPizza.getPrix().toString(),
				newPizza.getCategorie().toString().toUpperCase());
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException, SQLException {
		deletePizza(codePizza);
		savePizza(updatePizza);
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException, SQLException {
		Pizza p = new Pizza();
		p = findPizza(codePizza);
		if (p.getCode() != null) {
			String sql = "DELETE FROM PIZZA WHERE `code` LIKE ?";
			jdbcTemplate.update(sql, codePizza);
		}
	}

	@Override
	public void importPizza(List<Pizza> pizzas) throws DaoException {
		
		ListUtils.partition(pizzas, 3).forEach(list -> {
			this.txTemplate.execute(status -> {
				list.forEach(t -> {
					try {
						this.savePizza(t);
		
					} catch (DaoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				});
				return null;
			});
		});
			
			
		}

	@Override
	public Pizza findPizza(String codePizza) {
		String sql = "SELECT `id`, `code`, `nom`,`prix`,`CATEGORIE` FROM Pizza WHERE code LIKE ?";
		return this.jdbcTemplate.queryForObject(sql, new PizzaMapper(), codePizza);
	}

	private class PizzaMapper implements RowMapper<Pizza> {

		@Override
		public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pizza p = new Pizza();
			p.setId(rs.getInt("id"));
			p.setCode(rs.getString("code"));
			p.setNom(rs.getString("nom"));
			p.setPrix(new BigDecimal(rs.getString("prix")));
			p.setCategorie(CategoriePizza.valueOf(rs.getString("categorie")));
			return p;
		}

	}

}
