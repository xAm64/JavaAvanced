package Exercice3;

import java.awt.peer.MouseInfoPeer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.script.ScriptContext;
import javax.swing.Box.Filler;

import Exercice3.*;

public class TestResto extends Resto {
	

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String instructions = "Souhaitez-vous :\n"
				+ "1: Imprimmer le menu\n"
				+ "2: Imprimmer une commande";
		int choise;
		do {
			choise = writeNumber(instructions, scn);
			if (choise >= 1 && choise <= 2) {
				switch (choise) {
				case 1:
					printAll(printMenu(), "Menu");
					break;
				case 2:
					printAll(printCommande(scn), "Commande");
					break;
				default:
					choise = 0;
					System.out.println("Comportement anormal détecté, veuillez recommencer");
					break;
				}
			} else {
				System.out.println("Merci de saisir le bon numéro corpondant a votre choix");
			}
		} while (choise < 1 || choise > 2);
	}
	
	//permet de créer le fichier demander selon le contexte
	public static void printAll(String content, String name) {
		FileOutputStream newFile = null;
		File file;
		
		try {
			file = new File(name+".txt");
			newFile = new FileOutputStream(file);
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			byte[] contentByte = content.getBytes();
			
			newFile.write(contentByte);
			newFile.flush();
			newFile.close();
			
			System.out.println("Opération réussi");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (newFile != null) {
					newFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//imprimmer le menu
	public static String printMenu() {
		String menu = "****** MENU ******\n";
		menu += parcourtItem(Resto.STARTER);
		menu += parcourtItem(Resto.DISHES);
		menu += parcourtItem(Resto.SIDE_DISH);
		menu += parcourtItem(Resto.DRINKS);
		menu += parcourtItem(Resto.DESSERTS);
		return menu;
	}
	//Répéter l'opération du tableau
	public static String parcourtItem(String[] item) {
		String printItemp = "";
		for (int i=0; i<item.length; i++) {
			if (i > 0) {
				printItemp += item[i]+"\n";
			} else {
				printItemp += "******"+item[0]+"******\n";
			}
		}
		printItemp += "\n";
		return printItemp;
	}
	
	//Imprimmer la commande
	public static String printCommande(Scanner scn) {
		int numberCommandes = writeNumber("Combiens de commandes ?", scn);
		String contentCommande = "";
		if (numberCommandes >1) {
			contentCommande += "****** COMMANDES ******\n";
		} else {
			contentCommande += "****** COMMANDE ******\n";
		}
		for (int i = 1; i<= numberCommandes; i++) {
			contentCommande += "**** Commande numéro: "+i+"****\n";
			ArrayList<String> commandeClient = createMenuClient(scn);
			for (String x: commandeClient) {
				contentCommande += x+"\n";
			}
			contentCommande += "\n";
		}
		return contentCommande;
	}

	//control saisie utilisateur
	public static int writeNumber(String instructions, Scanner scn) {
		boolean reset = true;
		int x = 0;
		while (reset) {
			System.out.println(instructions);
			try {
				x = scn.nextInt();
				return x;
			}catch (Exception e) {
				System.out.println("ceci n'est pas un chiffre: "+e);
				scn.next();
				//reset = false;
			}
		};
		return 0;
	}
}
