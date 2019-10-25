package com.autonomouscar;

import com.autonomouscar.view.Bienvenue4HWC;
import com.autonomouscar.view.Menu4HWC;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(Integer.valueOf("4").intValue());

		Bienvenue4HWC fenBienvenue = new Bienvenue4HWC(); // Première
															// fenêtre

		// Speech will be improved later

		Bienvenue4HWC.voixBienvenue4HWC(); // Voix de bienvenue première
											// fenêtre

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		fenBienvenue.dispose(); // Fermeture de la première fenêtre

		new Menu4HWC(); // Affichage deuxième fenêtre de
						// menu

		// Menu4HWC.voixMenu4HWC();

	}

}
