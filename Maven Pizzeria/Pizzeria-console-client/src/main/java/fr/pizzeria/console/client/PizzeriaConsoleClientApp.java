package fr.pizzeria.console.client;


import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.dao.FactoryDaoJPA;
import fr.pizzeria.ihm.menu.MenuIdentification;

public class PizzeriaConsoleClientApp 
{
	private static EntityManagerFactory EMF;
	
    public static void main( String[] args )
    {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    	java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		EMF = Persistence.createEntityManagerFactory("Pizzeria-console-client");
    	
		Scanner sc = new Scanner(System.in);
		MenuIdentification menu = new MenuIdentification(sc, new FactoryDaoJPA(EMF));
		menu.afficher();
		
    }
    
    public static EntityManagerFactory getEMF(){
    	return EMF;
    }
}
