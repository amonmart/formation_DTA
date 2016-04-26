package fr.operateurs.console;

import java.util.Scanner;

public class OperateursApp {
	public static void main(String[] args){
		//Déclaration des deux scanners
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		//Saisie des nombres par l'utilisateur
		System.out.println("Veuillez saisir le premier nombre : ");
		double D1 = sc1.nextDouble();
		System.out.println("Veuillez saisir le second nombre : ");
		double D2 = sc2.nextDouble();
		
		//Affichage des opérateurs
		System.out.println(D1 + " + " + D2 + " = " + (D1+D2));
		System.out.println(D1 + " x " + D2 + " = " + (D1*D2));
		System.out.println(D1 + " - " + D2 + " = " + (D1-D2));
		System.out.println(D1 + " / " + D2 + " = " + (D1/D2));
		System.out.println(D1 + " modulo " + D2 + " = " + (D1%D2));
	}
}
