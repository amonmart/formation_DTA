package fr.pizzeria.console;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.ihm.menu.Menu;

public class PizzaAdminApp {
	private PizzaAdminApp() {
	}

	public static void main(String[] args) throws IOException {
		Logger.getLogger("org").setLevel(Level.SEVERE);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfigJpaData.class)){
			Menu menu = context.getBean(Menu.class);
			menu.afficher();
		}
	}

}
