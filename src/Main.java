import java.util.ArrayList;
import java.util.Scanner;

import com.autonomouscar.model.AutonomousCar;

public class Main {

	// TEST POUR VOIR SI LES TONDEUSES SONT CORRECTES

	static void voirLesTondeuses(ArrayList<AutonomousCar> liste) {
		System.out.println("Nombre de tondeuses pour tondre le gazon :" + liste.size());

		for (int l = 0; l < liste.size(); l++) {

			System.out.println("TONDEUSE N° " + (l + 1) + "--> " + liste.get(l).getXCoinDroit() + " "
					+ liste.get(l).getYCoinDroit() + " " + liste.get(l).getXTondeuseInitiale() + " "
					+ liste.get(l).getYTondeuseInitiale() + " " + liste.get(l).getOrientationTondeuseInitiale() + " "
					+ liste.get(l).getInstructions());

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean choixQuitter = false;

		while (choixQuitter == false) {
			System.out.println(
					"Bonjour, je m'appelle AXIV et je vais vous aider à tondre le gazon :). Je vous prie de faire votre choix");

			System.out.println("1 : Utilisation des données préenregistrées");

			System.out.println("2 : Saisie des données");

			System.out.println("3 : Utilisation de l'intelligence artificielle d'AXIV");

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

				AutonomousCar.deplacementDeToutesLesTondeuses(AutonomousCar.recupFichierBase());

				break;

			case 2:

				String nombreDeTondeuses;

				ArrayList<AutonomousCar> tondeusesPourGazon = new ArrayList<AutonomousCar>();

				// Vérification nombre de tondeuses

				do {
					System.out.println("Entrez le nombre de tondeuses pour tondre le gazon");

					nombreDeTondeuses = sc.nextLine();

				} while (AutonomousCar.validationNombreDeTondeusesString(nombreDeTondeuses) == false);

				for (int i = 0; i < Integer.parseInt(nombreDeTondeuses.trim()); i++)

				{
					System.out.println("**** TONDEUSE N° " + (i + 1) + " ****");

					String xCoinDroit, yCoinDroit, xTondeuseInitiale, yTondeuseInitiale;

					do

					{
						System.out.println(
								"Entrez la position du coin supérieur droit de la pelouse. S'il vous plaît , les valeurs sont comprises entre 0 et 5 ");

						System.out.println("Position suivant l'axe des abscisses");

						xCoinDroit = sc.nextLine();

						System.out.println("Position suivant l'axe des ordonnées");

						yCoinDroit = sc.nextLine();

						System.out.println("Entrez la position de la tondeuse sur la pelouse.");

						System.out.println("Position suivant l'axe des abscisses");

						xTondeuseInitiale = sc.nextLine();

						System.out.println("Position suivant l'axe des ordonnées");

						yTondeuseInitiale = sc.nextLine();

					} while (AutonomousCar.validationPositionsString(xCoinDroit, yCoinDroit, xTondeuseInitiale,
							yTondeuseInitiale) == false);

					String orientationTondeuseInitiale;

					do {
						System.out.println("Entrez son orientation : N ou E ou W ou S ");

						orientationTondeuseInitiale = sc.nextLine();

					} while (AutonomousCar
							.validationOrientationTondeuseInitiale(orientationTondeuseInitiale.toUpperCase()) == false);

					String instructions;

					do {

						System.out.println("Entrez les instructions en utilisant uniquement D G A sans espaces");

						instructions = sc.nextLine();

					} while (AutonomousCar.validationInstructions(instructions.toUpperCase()) == false);

					// J'ajoute les données à ma liste de tondeuses

					tondeusesPourGazon.add(new AutonomousCar(Integer.parseInt(xCoinDroit.trim()),
							Integer.parseInt(yCoinDroit.trim()), Integer.parseInt(xTondeuseInitiale.trim()),
							Integer.parseInt(yTondeuseInitiale.trim()),
							orientationTondeuseInitiale.toUpperCase().trim(), instructions.toUpperCase().trim()));

				}

				AutonomousCar.deplacementDeToutesLesTondeuses(tondeusesPourGazon);

				break;

			case 3:

				AutonomousCar.deplacementDeToutesLesTondeuses(AutonomousCar.getTondeusesAXIV());

				break;

			default:

				System.out.println("Mauvaise réponse");

			}

		}

	}

}
