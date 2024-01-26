package TestThread;

import javax.swing.*;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTime {
	public static void main(String[] args) {
	    new ViewClock();
	  }
}

//interface graphique
class ViewClock {
	public ViewClock() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Appelle l'interface graphique
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException er) {
				}
				JFrame lookClock = new JFrame("Horloge"); //Titre de la fenêtre
				lookClock.getContentPane().setBackground(Color.decode("#96B1C9")); //change la couleur de fond.
				lookClock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //si je ferme ça quitte le pgogramme
				lookClock.setLayout(new BorderLayout()); //Créer la bordure de la fenêtre
				lookClock.add(new Clock()); //Appelle l'horloge
				lookClock.pack();
				lookClock.setLocationRelativeTo(null); //Définie un emplacement spécifique
				lookClock.setVisible(true); //rends la fenPetre visible
			}
		});
	}
}
//méthode pour afficher l'horloge
class Clock extends JPanel{
	private JLabel horloge;
	public Clock() {
		setLayout(new BorderLayout());
		horloge = new JLabel(); //créer une nouvelle horloge
		horloge.setForeground(Color.decode("#232107")); //change la couleur de police
		horloge.setHorizontalAlignment(JLabel.CENTER); //Alligne l'horloge au centre de la fenêtre
		horloge.setFont( //Change la police de l'horloge
				UIManager.getFont("Label.font").deriveFont(Font.BOLD, 50f)
				);
		horloge.setText( //Applicque le format Heure(1 chiffre si en dessous de 10), minutes, secondes.
				new SimpleDateFormat("H:mm:ss").format(new Date())
				);
		add(horloge); //ajoute l'horloge au point graphique.
		Timer z = new Timer(1000, new ActionListener() { //rafréchis la fenêtre toutes les secondes.
			@Override
			public void actionPerformed(ActionEvent x) { //Change le contenue de l'anciene horloge par la nouvelle.
				horloge.setText(
						new SimpleDateFormat("H:mm:ss").format(new Date())
						);
			}
		});
		z.setRepeats(true); //Permet de répeter l'action
		z.setCoalesce(true);  //convertit l'heure en string
		z.setInitialDelay(0); //décalage du temps initiale
		z.start(); //démarre l'horloge
	}
}