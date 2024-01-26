import java.util.Scanner;

import javax.accessibility.AccessibleRelationSet;

public class Exercice1_2 {
	public static void main(String[] args) {
		System.out.println("Devien un nombre entre 1 et 100");
		int numberMagic = (int) (Math.random() * (100 - 1)),
			numberTentatives = 1,
			userNumber = 0;
		do {
			userNumber = writeNumber();
			if (userNumber < numberMagic) {
				System.out.println("C'est plus");
				numberTentatives ++;
			} else if (userNumber > numberMagic) {
				System.out.println("C'est moins");
				numberTentatives ++;
			} else {
				if (numberTentatives > 1) {
					System.out.println("Vous avez trouvé le numéro: "+numberMagic+" après: "+numberTentatives+" tentatives.");
				} else {
					System.out.println("Brabo vous avez trouvé: "+numberMagic+" du premier coup!");
				}
			}
		} while (userNumber != numberMagic);
		System.out.println("À bientôt");
	}
	
	public static int writeNumber() {
		Scanner scn = new Scanner(System.in);
		boolean reset = true;
		int x = 0;
		//x = scn.nextInt();
		/*while(!scn.hasNextInt()) {
			System.out.println("veuillez saisir une valeur entière!");
			scn.next();
		}
		System.out.println(x);*/
		
		while (reset) {
			System.out.println("Écrire un chiffre");
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
