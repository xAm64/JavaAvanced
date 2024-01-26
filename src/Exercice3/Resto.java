package Exercice3;

import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CosNaming.NamingContextExt;

import Exercice3.*;

public class Resto {
	public static final String [] STARTER = 	{"entrée", "salade","soupe","quiche","aucune"};
	public static final String [] DISHES = 		{"plats" , "poulet" , "boeuf" , "poisson" , "végétarien" , "vegan","aucun"};
	public static final String [] SIDE_DISH = 	{"accompagnements" , "riz" , "pates" , "frites" , "légumes","aucun"};
	public static final String [] DRINKS = 		{"boissons" , "eau plate" , "eau gazeuze" , "soda" , "vin","aucune"};
	public static final String [] DESSERTS = 	{"desserts" , "tarte maison" , "mousse au chocolat" , "tiramisu","aucun"};

	public static ArrayList createMenuClient(Scanner scan) {
		ArrayList<String>  order = new ArrayList<String>();
		System.out.println("Appuyer sur la touche 1 pour commander");
		scan.next();
		int result = getInfos(scan,STARTER[0]);
		if(STARTER.length-1 > result)	order.add(STARTER[result]);

		result = getInfos(scan,DISHES[0]);
		if(DISHES.length-1 > result)	order.add(DISHES[result]);	

		result = getInfos(scan,SIDE_DISH[0]);
		if(SIDE_DISH.length-1 > result)	order.add(SIDE_DISH[result]);	

		result = getInfos(scan,DRINKS[0]);
		if(DRINKS.length-1 > result)	order.add(DRINKS[result]);

		result = getInfos(scan,DESSERTS[0]);
		if(DESSERTS.length-1 > result)	order.add(DESSERTS[result]);	

		return(order);
	}
	/*
	public static void main(String[] args) {		
		System.out.println("bonjour, combien de menus souhaitez vous ?");
		Scanner scan = new Scanner(System.in);
		int nbMenu;
		while(scan.hasNextInt() == false)	scan.next();
		nbMenu = scan.nextInt();
		ArrayList<String>  order = new ArrayList<String>();
		for(int i = 0 ; i < nbMenu ; i ++) {
			System.out.println("Commande numéro " + (i+1));
			int result = getInfos(scan,STARTER[0]);
			if(STARTER.length-1 > result)	order.add(STARTER[result]);

			result = getInfos(scan,DISHES[0]);
			if(DISHES.length-1 > result)	order.add(DISHES[result]);	

			result = getInfos(scan,SIDE_DISH[0]);
			if(SIDE_DISH.length-1 > result)	order.add(SIDE_DISH[result]);	

			result = getInfos(scan,DRINKS[0]);
			if(DRINKS.length-1 > result)	order.add(DRINKS[result]);

			result = getInfos(scan,DESSERTS[0]);
			if(DESSERTS.length-1 > result)	order.add(DESSERTS[result]);	

			System.out.println("Résumé de la commande "+(i+1));
			sendToPrint(order);
			//System.out.println(order);		//ici on pourrait stocker la commande en base par exemple
			//System.out.println();			//avant de passer à la suivante
			order.clear();
		}	
		scan.close();
	}*/
	public static int getInfos(Scanner scan, String info) {
		System.out.println("choix " + info + " : ");
		int maxChoice = 0;
		if(info.equalsIgnoreCase(STARTER[0]))	maxChoice = displayTable(STARTER);
		else if(info.equalsIgnoreCase(DISHES[0])) maxChoice = displayTable(DISHES);
		else if(info.equalsIgnoreCase(SIDE_DISH[0])) maxChoice = displayTable(SIDE_DISH);
		else if(info.equalsIgnoreCase(DRINKS[0])) maxChoice = displayTable(DRINKS);
		else if(info.equalsIgnoreCase(DESSERTS[0])) maxChoice =	displayTable(DESSERTS);		
		System.out.println("que souhaitez vous comme "+ info + " ? [saisir le chiffre correspondant]");

		int value = 0; 
		while(value < 1 || value > maxChoice) {				
			while(scan.hasNextInt() == false)	scan.next();	
			value = scan.nextInt();
			if(value < 1 || value > maxChoice)	System.out.println("mauvaise saisie !");
		}			
		return value; 
	}
	public static int displayTable(String [] table) {
		for(int i=1;i<table.length;i++) {			
			System.out.print("[" + i + " - " + table[i].toUpperCase() + "]");
		}
		System.out.println();
		return table.length;
	}
}
