package fr.pizzeria.model;

public class Pizza {
	public int id;
	public String code;
	public String nom;
	public double prix;
	public static int nbPizza; 

	public void creer(int id, String code, String nom, double prix){
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		Pizza.nbPizza++;
	}
	
	public void modifier(String code, String nom, double prix){
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		Pizza.nbPizza++;
	}
}
