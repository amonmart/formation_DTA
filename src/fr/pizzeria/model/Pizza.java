package fr.pizzeria.model;

import java.lang.reflect.Field;

public class Pizza {
	public int id;
	@ToString public String code;
	public String nom;
	public double prix;
	public static int nbPizza; 
	public CategoriePizza categorie;

	public Pizza() {
		super();
		Pizza.nbPizza++;
	}
	
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		Pizza.nbPizza++;
	}

	public void creer(int id, String code, String nom, double prix){
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		Pizza.nbPizza++;
	}
	
	public void modifier(String code, String nom, double prix, CategoriePizza categorie){
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		Pizza.nbPizza++;
	}
	
	@Override
	public String toString() {
		String value = "";
		
		for(Field champ : this.getClass().getDeclaredFields()) {
			ToString annotation = champ.getAnnotation(ToString.class);
			
			if(annotation != null) {
				try {
					boolean uppercase = annotation.uppercase();
					
					Object valeurDuChamp = champ.get(this);
					
					value +=  uppercase ? valeurDuChamp.toString().toUpperCase() : valeurDuChamp + " ";
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
}
