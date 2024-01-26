package TestThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTime {

	public static void main(String[] args) {
	    viewClock();
	  }
	
	//interface graphique
	public static void viewClock() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Appelle l'interface graphique
				} catch (ClassNotFoundException er) { //Si class pas trouvé
				} catch (InstantiationException er) { //Si l'instanciation échoue
				} catch (IllegalAccessException er) { //Si un accès non autorié est détecté
				} catch (UnsupportedLookAndFeelException e) { //Si une action non supporté est détecté
				}
				JFrame lookClock = new JFrame("Horloge"); //Titre de la fenêtre
				lookClock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //si je ferme ça quitte le pgogramme
				lookClock.setLayout(new BorderLayout()); //Créer la bordure de la fenêtre
				lookClock.add(new Clock()); //Appelle l'horloge
				lookClock.pack();
				lookClock.setLocationRelativeTo(null); //Définie un emplacement spécifique
				lookClock.setVisible(false); //rends la fenPetre visible
			}
		});
	}
	
	//méthode pour afficher l'horloge
	public static class Clock extends JPanel{
		private JLabel horloge;
		public Clock() {
			setLayout(new BorderLayout());
			horloge = new JLabel();
			horloge.setHorizontalAlignment(JLabel.CENTER);
			horloge.setFont(
					UIManager.getFont("Label.font").deriveFont(Font.BOLD, 50f)
				);
			horloge.setText(
					new SimpleDateFormat("H:mm:ss").format(new Date())
				);
			add(horloge);
			Timer z = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent x) {
					horloge.setText(
							new SimpleDateFormat("H:mm:ss").format(new Date())
						);
					
				}
			});
			z.setRepeats(true);
			z.setCoalesce(true);
			z.setInitialDelay(0);
			z.start();
		}
	}
}
