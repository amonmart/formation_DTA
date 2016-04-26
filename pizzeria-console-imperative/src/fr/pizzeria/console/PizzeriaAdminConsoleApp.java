package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		//Initialisation des variables
		//Scanners
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		//Données
		double D1 = 0;
		String[] tableauIdNoms = new String [100];
		String[] tableauNoms = new String[100] ;
		double [] tableauPrix = new double[100] ;
		int nombreDePizza = 8;
		String modifications = new String();
		double modificationsDouble = 0;
		
		//Initialisation des tableaux
		tableauIdNoms[0] = "PEP";
		tableauNoms[0] = "Pépéroni";
		tableauPrix[0] = 12.50;
		
		tableauIdNoms[1] = "MAR";
		tableauNoms[1] = "Margherita";
		tableauPrix[1] = 14.00;
		
		tableauIdNoms[2] = "REI";
		tableauNoms[2] = "Reine";
		tableauPrix[2] = 11.50;
		
		tableauIdNoms[3] = "FRO";
		tableauNoms[3] = "La 4 Fromages";
		tableauPrix[3] = 12.00;
		
		tableauIdNoms[4] = "CAN";
		tableauNoms[4] = "La Cannibale";
		tableauPrix[4] = 12.50;
		
		tableauIdNoms[5] = "SAV";
		tableauNoms[5] = "La Savoyarde";
		tableauPrix[5] = 13.00;
		
		tableauIdNoms[6] = "ORI";
		tableauNoms[6] = "L'Orientale";
		tableauPrix[6] = 13.50;
		
		tableauIdNoms[7] = "IND";
		tableauNoms[7] = "L'Indienne";
		tableauPrix[7] = 14.00;
		
		while (D1 != 99){
			//Affichage de la liste des options
			System.out.println("*****Administration de la pizzeria*****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			System.out.println("Validez votre choix :");
			
			D1 = sc1.nextDouble();
			
			if (D1 == 1){
				System.out.println("Liste des pizzas");
				for (int i = 0; i < nombreDePizza; i++){
					System.out.println("| " + i + " | " + tableauIdNoms[i] + " | " + tableauNoms[i] + " | " + tableauPrix[i] + " |");
				}
				continue;
			}
			if (D1 == 2){
				System.out.println("Ajout d'une nouvelle pizza");
				
				//Saisie du code de la pizza
				System.out.println("Veuillez saisir le code pizza :");
				modifications = sc1.next();
				tableauIdNoms[nombreDePizza] = modifications;
				
				//Saisie du nom de la pizza
				System.out.println("Veuillez saisir le nom de la pizza :");
				modifications = sc1.next();
				tableauNoms[nombreDePizza] = modifications;
				
				//Saisie du prix de la pizza
				System.out.println("Veuillez saisir le prix de la pizza :");
				modificationsDouble = sc2.nextDouble();
				tableauPrix[nombreDePizza] = modificationsDouble;
				
				nombreDePizza = nombreDePizza + 1;
				
				continue;
			}
			if (D1 == 3){
				System.out.println("Mise à jour d'une pizza");
				continue;
			}
			if (D1 == 4){
				System.out.println("Suppression d'une pizza");
				continue;
			}
			if (D1 == 99){
				System.out.println("Aurevoir ! =)");
				break;
			}
		}
		
			
	}

}
