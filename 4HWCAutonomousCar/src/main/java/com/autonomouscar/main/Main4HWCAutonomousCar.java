package com.autonomouscar.main;
import com.autonomouscar.view.Bienvenue4HWC;
import com.autonomouscar.view.Menu4HWC;

public class Main4HWCAutonomousCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(Integer.valueOf("4").intValue());

		Bienvenue4HWC fenBienvenue = new Bienvenue4HWC(); // Première
															// fenêtre

		Bienvenue4HWC.voixBienvenue4HWC(); // Voix de bienvenue première
											// fenêtre

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		fenBienvenue.setVisible(false); // Fermeture de la première fenêtre

		new Menu4HWC(); // Affichage deuxième fenêtre de
						// menu

		// Menu4HWC.voixMenu4HWC();

	}

}
