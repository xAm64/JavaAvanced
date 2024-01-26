package Exercice3;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.Box.Filler;

import Exercice3.*;

public class TestResto extends Resto {
	

	public static void main(String[] args) {
		ArrayList<String> CommandeClient = createMenuClient();
		FileOutputStream restoTest = null;
		try {
		restoTest = new FileOutputStream(new File("Resto.txt"));
		for (int i = 0; i<)
		restoTest.write(buf);
		}catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
