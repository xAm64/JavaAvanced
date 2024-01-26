package Exercice3;

import java.awt.peer.MouseInfoPeer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.Box.Filler;

import Exercice3.*;

public class TestResto extends Resto {
	

	public static void main(String[] args) {
		
		FileOutputStream menu = null;
		File file;
		String contenu = printMenu();
		
		/*
		 try {
			file = new File("Menu.txt");
			menu = new FileOutputStream(file);
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			byte[] contentByte = contenu.getBytes();
			
			menu.write(contentByte);
			menu.flush();
			menu.close();
			
			System.out.println("Menu écrit");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (menu != null) {
					menu.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	public void printAll(String content, File name) {
		FileOutputStream newFile = null;
		File file;
		
		try {
			file = new File(name+".txt");
			content = new FileOutputStream(file);
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			byte[] contentByte = content.getBytes();
			
			content.write(contentByte);
			content.flush();
			content.close();
			
			System.out.println("Opération réussi");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (content != null) {
					content.close();
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
	public static String printCommande() {
		/*ArrayList<String> CommandeClient = createMenuClient();
		FileOutputStream restoTest = null;
		try {
			restoTest = new FileOutputStream(new File("Resto.txt"));
			for (int i = 0; i<)
				restoTest.write(buf);
		}catch (Exception e) {
			System.out.println(e);
		}*/
		return "Travail en cours";
	}

}
