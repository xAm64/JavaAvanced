import java.util.ArrayList;
import java.util.Date;

public class Exercice1_1 {

	public static void main(String[] args) {
		//je met les valeurs dans un tableau
		ArrayList<Date> tableDate = new ArrayList<>();
		tableDate.add(null);
		tableDate.add(new Date());
		//je parcours le tableau
		for (Date dates : tableDate) {
			try {
				System.out.println(dates.getClass().getName());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
}
