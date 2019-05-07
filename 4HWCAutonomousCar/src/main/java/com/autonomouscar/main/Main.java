package com.autonomouscar.main;
import java.util.ArrayList;
import java.util.Scanner;

import com.autonomouscar.model.AutonomousCar;

public class Main {

	// TEST POUR VOIR SI LES VEHICULES SONT CORRECTES

	static void voirLesVehicules(ArrayList<AutonomousCar> liste) {
		System.out.println("Nombre de véhicules pour parcourir la surface :" + liste.size());

		for (int l = 0; l < liste.size(); l++) {

			System.out.println("VEHICULE N° " + (l + 1) + "--> " + liste.get(l).getXCoinDroit() + " "
					+ liste.get(l).getYCoinDroit() + " " + liste.get(l).getXInitiale() + " "
					+ liste.get(l).getYInitiale() + " " + liste.get(l).getOrientationInitiale() + " "
					+ liste.get(l).getInstructions());

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean choixQuitter = false;

		while (choixQuitter == false) {
			System.out.println(
					"Bonjour, je m'appelle 4HWC et je vais vous aider à parcourir la surface :). Je vous prie de faire votre choix");

			System.out.println("1 : Utilisation des données préenregistrées");

			System.out.println("2 : Saisie des données");

			System.out.println("3 : Utilisation de l'intelligence artificielle 4HWC");

			System.out.println("0 : Fin :) !");

			Scanner sc = new Scanner(System.in);

			System.out.println("Faites votre choix en entrant 0,1,2 ou 3");

			int choix = sc.nextInt();

			switch (choix) {

			case 0:

				System.out.println("Au plaisir de vous revoir :) !");

				choixQuitter = true;

				break;

			case 1:

				AutonomousCar.deplacementDeTousLesVehicules(AutonomousCar.recupFichierBase());

				break;

			case 2:

				String nombreDeVehiules;

				ArrayList<AutonomousCar> vehicules = new ArrayList<AutonomousCar>();

				// Vérification nombre de tondeuses

				do {
					System.out.println("Entrez le nombre de véhicules pour parcourir la surface");

					nombreDeVehiules = sc.nextLine();

				} while (AutonomousCar.validationNombreDeVehiculesString(nombreDeVehiules) == false);

				for (int i = 0; i < Integer.parseInt(nombreDeVehiules.trim()); i++)

				{
					System.out.println("**** VEHICULE N° " + (i + 1) + " ****");

					String xCoinDroit, yCoinDroit, xInitiale, yInitiale;

					do

					{
						System.out.println(
								"Entrez la position du coin supérieur droit de la surface. S'il vous plaît , les valeurs sont comprises entre 0 et 5 ");

						System.out.println("Position suivant l'axe des abscisses");

						xCoinDroit = sc.nextLine();

						System.out.println("Position suivant l'axe des ordonnées");

						yCoinDroit = sc.nextLine();

						System.out.println("Entrez la position du véhicule sur la surface.");

						System.out.println("Position suivant l'axe des abscisses");

						xInitiale = sc.nextLine();

						System.out.println("Position suivant l'axe des ordonnées");

						yInitiale = sc.nextLine();

					} while (AutonomousCar.validationPositionsString(xCoinDroit, yCoinDroit, xInitiale,
							yInitiale) == false);

					String orientationInitiale;

					do {
						System.out.println("Entrez son orientation : N ou E ou W ou S ");

						orientationInitiale = sc.nextLine();

					} while (AutonomousCar.validationOrientationInitiale(orientationInitiale.toUpperCase()) == false);

					String instructions;

					do {

						System.out.println("Entrez les instructions en utilisant uniquement D G A sans espaces");

						instructions = sc.nextLine();

					} while (AutonomousCar.validationInstructions(instructions.toUpperCase()) == false);

					// J'ajoute les données à ma liste de tondeuses

					vehicules.add(
							new AutonomousCar(Integer.parseInt(xCoinDroit.trim()), Integer.parseInt(yCoinDroit.trim()),
									Integer.parseInt(xInitiale.trim()), Integer.parseInt(yInitiale.trim()),
									orientationInitiale.toUpperCase().trim(), instructions.toUpperCase().trim()));

				}

				AutonomousCar.deplacementDeTousLesVehicules(vehicules);

				break;

			case 3:

				AutonomousCar.deplacementDeTousLesVehicules(AutonomousCar.getVehicules4HWC());

				break;

			default:

				System.out.println("Mauvaise réponse");

			}

		}

	}

}
