package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichierImpl implements IPizzaDao {
	
	private Path repertoire = Paths.get("data");

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		
		try {
			return Files.list(repertoire)
				.map(path -> {
					Pizza p = new Pizza();
					p.setCode(path.getFileName().toString().replaceAll(".txt", ""));
					try {
						String ligne = Files.readAllLines(path).get(0);
						String[] ligneTab = ligne.split(";");
						p.setNom(ligneTab[0]);
						p.setPrix(Double.valueOf(ligneTab[1]));
						p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return p;
				})
				.collect(Collectors.toList());
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void savePizza(Pizza newPizza) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}