package com.autonomouscar.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

import com.autonomouscar.logs.AutonomousCarLog;
import com.autonomouscar.model.AutonomousCar;
import com.autonomouscar.utils.Chronometre;

public class AutonomousCarService {

	public static final int NUMBER_OF_INSTRUCTIONS_MAX = 50;

	public static final int NUMBER_OF_VEHICLES_MAX = 20;

	public static final String INCORRECT = "INCORRECT";
	// Validation de nombre de véhicules String

	// SERVICE

	public boolean validationNombreDeVehiculesString(String nbre) {
		boolean validation = false;

		int entier = 0;

		if (isNombre(nbre) == true) {

			String nbreTrim = nbre.trim();

			entier = Integer.parseInt(nbreTrim);

			if (entier >= 1) {
				// correct

				validation = true;

			} else {

				AutonomousCarLog.logger.error(INCORRECT);

			}

		} else {

			// Ce n'est pas un nombre

			AutonomousCarLog.logger.error(INCORRECT);

		}

		return validation;
	}

	// Validation d'un nombre

	// SERVICE

	private boolean isNombre(String nbre) {

		boolean presenceEspace = false;

		boolean validation = false;

		if (nbre != null) {
			String nbreTrim = nbre.trim();

			if (nbreTrim.length() != 0) {

				for (int i = 0; i < nbreTrim.length(); i++) {

					if (nbreTrim.charAt(i) == ' ') {

						presenceEspace = true;

						break;
					}
				} // for

				if (presenceEspace == false)

				{

					int compteurChiffresCorrects = 0;

					for (int j = 0; j < nbreTrim.length(); j++) {

						String nbreTrimString = nbreTrim.charAt(j) + "";

						if (nbreTrimString.equals("0") || nbreTrimString.equals("1") || nbreTrimString.equals("2")
								|| nbreTrimString.equals("3") || nbreTrimString.equals("4")
								|| nbreTrimString.equals("5") || nbreTrimString.equals("6")
								|| nbreTrimString.equals("7") || nbreTrimString.equals("8")
								|| nbreTrimString.equals("9")) {
							// Correct

							compteurChiffresCorrects++;

							if (compteurChiffresCorrects == nbreTrim.length()) {

								validation = true;
							}

						} else {
							// Présence d'un intrus

							validation = false;

							break;
						}

					} // for

				} else {
					// Rien faire car espace présent
				}

			} else {

			}
		} else {

		}

		return validation;
	}

	// SERVICE

	// Vérification orientation

	public boolean validationOrientationInitiale(String orientationInitiale) {
		boolean validation = false;

		if (orientationInitiale != null) {
			String orientationInitialeTrim = orientationInitiale.trim();

			if (orientationInitialeTrim.length() != 0) {
				if (orientationInitialeTrim.length() == 1) {
					if (orientationInitialeTrim.equals("N") || orientationInitialeTrim.equals("E")
							|| orientationInitialeTrim.equals("W") || orientationInitialeTrim.equals("S")) {

						validation = true;

						AutonomousCarLog.logger.debug("Bravo :)pour la correcte orientation");

					} else {

						AutonomousCarLog.logger.error("Veuillez entrer une lettre N , E , W ou S");

					} // 4e if
				} else {

					AutonomousCarLog.logger.error("Veuillez entrer une lettre N , E , W ou S");
				} // 3e if
			} else {

				AutonomousCarLog.logger.error("Veuillez entrer l'orientation");
			} // 2e if
		} else {

			AutonomousCarLog.logger.error("Veuillez entrer l'orientation");
		} // 1er if

		return validation;
	}

	// Validation Positions entrées : string

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	// SERVICE

	public boolean validationPositionsString(String xCoinDroit, String yCoinDroit, String xInitiale, String yInitiale) {

		boolean validation = false;

		int xCoinDroitInt = 0, yCoinDroitInt = 0, xInitialeInt = 0, yInitialeInt = 0;

		if (isNombre(xCoinDroit) && isNombre(yCoinDroit) && isNombre(xInitiale) && isNombre(yInitiale)) {

			xCoinDroitInt = Integer.parseInt(xCoinDroit.trim());

			yCoinDroitInt = Integer.parseInt(yCoinDroit.trim());

			xInitialeInt = Integer.parseInt(xInitiale.trim());

			yInitialeInt = Integer.parseInt(yInitiale.trim());

			if (xCoinDroitInt >= 0 && xCoinDroitInt <= 5 && yCoinDroitInt >= 0 && yCoinDroitInt <= 5) {
				if (xInitialeInt >= 0 && xInitialeInt <= xCoinDroitInt && yInitialeInt >= 0
						&& yInitialeInt <= yCoinDroitInt) {
					validation = true;

					AutonomousCarLog.logger.debug(" Le véhicule est bien positionné sur la surface");
				} else {
					AutonomousCarLog.logger.error(" Position incorrecte du véhicule");
				}
			} else {
				AutonomousCarLog.logger.error(
						" Position incorrecte du coin supérieur droit de la surface, entrez des valeurs comprises entre 0 et 5");
			}

		} else {
			AutonomousCarLog.logger.error(INCORRECT);
		}

		return validation;

	}

	// Vérification instructions

	// SERVICE

	public boolean validationInstructions(String instructions) {

		boolean presenceEspace = false; // Je suppose qu'il n y a pas d'espace

		boolean validation = false; // Je suppose qu'il y a au moins un problème

		if (instructions != null) {
			String instructionsTrim = instructions.trim();

			if (instructionsTrim.length() != 0) {

				for (int i = 0; i < instructionsTrim.length(); i++) { // Boucle
																		// pour
																		// rechercher
																		// l'espace

					if (instructionsTrim.charAt(i) == ' ') // Dès que je trouve
															// un
					// espace, c'est pas
					// correct
					{

						AutonomousCarLog.logger.error("Les espaces sont interdits dans vos instructions");

						presenceEspace = true;

						break;
					}
				} // for

				if (presenceEspace == false)// Pas d'espace

				{
					String instructionsTrimMaj = instructionsTrim.toUpperCase(); // Je
																					// convertis
																					// tout
																					// à
																					// majuscule

					int compteurLettresCorrectes = 0;

					for (int j = 0; j < instructionsTrimMaj.length(); j++) {

						String instructionsTrimMajString = instructionsTrimMaj.charAt(j) + "";

						if (instructionsTrimMajString.equals("A") || instructionsTrimMajString.equals("D")
								|| instructionsTrimMajString.equals("G")) {
							// Correct

							compteurLettresCorrectes++;

							if (compteurLettresCorrectes == instructionsTrimMaj.length()) {
								AutonomousCarLog.logger.debug("Les instructions sont correctes, bravo :)");

								validation = true;

								AutonomousCarLog.logger.debug(String.format("Valeur :-%s-", instructions));
							}

						} else {
							// Présence d'un intrus

							validation = false;

							AutonomousCarLog.logger.error("Les instructions contiennent uniquement D, G ou A");

							break;
						}

					} // for

				} else {
					// Rien faire car espace présent
				}

			} else {
				AutonomousCarLog.logger.error("Veuillez entrer des instructions");

			}
		} else {
			AutonomousCarLog.logger.error("Veuillez entrer des instructions");
		}

		return validation;
	}

	// SERVICE

	public List<AutonomousCar> recupFichierBase() {

		List<AutonomousCar> listeInitiale = new ArrayList<AutonomousCar>();

		List<String> lignes = new ArrayList<String>();

		InputStream inputStream = AutonomousCarService.class.getClassLoader().getResourceAsStream("default4HWC.txt");

		if (inputStream != null) {

			// Début du traitement

			try {

				byte[] buf = new byte[2048];

				int count = 0;

				int n = 0;

				String ligne = "";

				while ((n = inputStream.read(buf)) >= 0) {
					for (int i = 0; i < n; i++) {

						if (buf[i] != '\n') {
							ligne = ligne + (char) buf[i];

							if (i == n - 1) // enregistrement dernière ligne
								lignes.add(ligne);
						}

						if (buf[i] == '\n') {

							// System.out.println(ligne);

							lignes.add(ligne);
							count++;

							ligne = "";
							/*
							 * Compter le nombre de retour à la ligne Sachant que le nombre de lignes se
							 * trouve en ajoutant 1 au nombre final de retour à la ligne
							 */
						}

					} // for

				} // while

				String ligne0 = lignes.get(0); // 5 5

				String ligne1 = lignes.get(1);// 1 2 N

				String instructions1 = lignes.get(2);// GAGAGAGAA

				String ligne3 = lignes.get(3);// 3 3 E

				String instructions2 = lignes.get(4);// AADAADADDA

				int xCD = Integer.parseInt(ligne0.charAt(0) + "");// 5

				int yCD = Integer.parseInt(ligne0.charAt(2) + "");// 5

				int xT1 = Integer.parseInt(ligne1.charAt(0) + "");// 1

				int yT1 = Integer.parseInt(ligne1.charAt(2) + "");// 2

				String o1 = ligne1.charAt(4) + "";// N

				int xT2 = Integer.parseInt(ligne3.charAt(0) + "");// 3

				int yT2 = Integer.parseInt(ligne3.charAt(2) + "");// 3

				String o2 = ligne3.charAt(4) + "";// E

				listeInitiale.add(new AutonomousCar(xCD, yCD, xT1, yT1, o1, instructions1));

				listeInitiale.add(new AutonomousCar(xCD, yCD, xT2, yT2, o2, instructions2));

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {

				try {
					if (inputStream != null)
						inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else {

			AutonomousCarLog.logger.error("Fichier de base introuvable");

		}
		return listeInitiale;

	}

	// Intelligence Artificielle 4HWC à l'oeuvre

	// Nombre de véhicules

	// SERVICE

	private int getNombreDeVehicules4HWC() {
		Random randomNumbers = new Random();

		return randomNumbers.nextInt(NUMBER_OF_VEHICLES_MAX) + 1; // 1 to NUMBER_OF_VEHICLES_MAX (20)
	}

	// XCoinDroit4HWC

	// SERVICE

	private int getXCoinDroit4HWC() {
		Random randomNumbers = new Random();

		return randomNumbers.nextInt(6); // 0 to 5
	}

	// YCoinDroit4HWC

	// SERVICE

	private int getYCoinDroit4HWC() {

		Random randomNumbers = new Random();

		return randomNumbers.nextInt(6); // 0 to 5
	}

	// XInitiale4HWC

	// SERVICE

	private int getXInitiale4HWC(int x) // X --> xCoinDroit4HWC
	{

		/*
		 * 0<=x<=5 et 0<=XInitiale4HWC<=x donc si x=0 alors XInitiale4HWC=0
		 */

		return x == 0 ? 0 : new Random().nextInt(x);

	}

	// YInitiale4HWC

	// SERVICE

	private int getYInitiale4HWC(int y) // Y --> yCoinDroit4HWC
	{

		/*
		 * 0<=y<=5 et 0<=YInitiale4HWC<=y donc si y=0 alors YInitiale4HWC=0
		 */

		return y == 0 ? 0 : new Random().nextInt(y);

	}

	// Orientation4HWC

	// SERVICE

	private String getOrientationInitiale4HWC() {
		String tabOrientations[] = { "N", "E", "W", "S" };

		Random randomNumbers = new Random();

		return tabOrientations[randomNumbers.nextInt(tabOrientations.length)];

	}

	// Instructions4HWC

	// SERVICE

	private String getInstructions4HWC() {
		String tabInstructions[] = { "D", "G", "A" };

		Random randomNumbers = new Random();

		int tailleInstructions = randomNumbers.nextInt(NUMBER_OF_INSTRUCTIONS_MAX) + 1; // 1 to
																						// NUMBER_OF_INSTRUCTIONS_MAX
																						// (50)
		/*
		 * Don't use StringBuilder
		 * 
		 * Why ? java.lang.OutOfMemoryError : Java heap space
		 * 
		 * StringBuilder instructions4HWC = new StringBuilder();
		 * 
		 * Random randomNumbers2 = new Random();
		 * 
		 * for (int t = 0; t < tailleInstructions; t++)
		 * 
		 * instructions4HWC.append(instructions4HWC.toString())
		 * .append(tabInstructions[randomNumbers2.nextInt(tabInstructions.length)]);
		 * 
		 * return instructions4HWC.toString();
		 */

		String instructions4HWC = "";

		Random randomNumbers2 = new Random();

		for (int t = 0; t < tailleInstructions; t++)

			instructions4HWC = instructions4HWC + tabInstructions[randomNumbers2.nextInt(tabInstructions.length)];

		return instructions4HWC;

	}

	// Génération Automatique 4HWC

	// SERVICE

	public List<AutonomousCar> getVehicules4HWC() {

		List<AutonomousCar> liste = new ArrayList<AutonomousCar>();

		for (int i = 0; i < getNombreDeVehicules4HWC(); i++) {

			/*
			 * Initial postions depends on Surface so it's important to save it first. if
			 * not the values will be wrong.
			 * 
			 */

			int xCD = getXCoinDroit4HWC();

			int yCD = getYCoinDroit4HWC();

			liste.add(new AutonomousCar(xCD, yCD, getXInitiale4HWC(xCD), getYInitiale4HWC(yCD),
					getOrientationInitiale4HWC(), getInstructions4HWC()));

		}

		return liste;
	}

	// Déplacement sur la surface de plusieurs véhicules

	// SERVICE

	public void deplacementDeTousLesVehicules(List<AutonomousCar> liste) {

		AutonomousCarLog.logger.debug(String.format("NOMBRE DE VEHICULES DEPLOYEES :%d", liste.size()));

		// Speech will be improved later

		// Speech.repete("NOMBRE DE VEHICULES DEPLOYEES :" + liste.size());

		AutonomousCarService autonomousCarService = new AutonomousCarService();

		liste.parallelStream().forEachOrdered(autonomousCarService::parcourirLaSurface);

	}

	// Déplacement sur la surface d'un véhicule (mode console)

	// SERVICE

	private void parcourirLaSurface(AutonomousCar vehiculeEnDeplacement)

	{

		// Chrono chrono = new Chrono();

		String instructionsASuivre = vehiculeEnDeplacement.getInstructions();

		// Lancement du chronometre

		Chronometre.goChrono();

		for (int i = 0; i < instructionsASuivre.length(); i++) // Suivre les
																// instructions

		{
			String instructionActuelle = instructionsASuivre.charAt(i) + ""; // char
																				// to
																				// String

			String orientationActuelle = vehiculeEnDeplacement.getOrientationActuelle();

			int xActuelle = vehiculeEnDeplacement.getXActuelle();

			int yActuelle = vehiculeEnDeplacement.getYActuelle();

			// Tourner à droite

			// Modification de l'orientation

			if (instructionActuelle.equals("D"))

			{

				if (orientationActuelle.equals("N")) {
					vehiculeEnDeplacement.setOrientationActuelle("E");
				}

				if (orientationActuelle.equals("E")) {
					vehiculeEnDeplacement.setOrientationActuelle("S");
				}

				if (orientationActuelle.equals("W")) {
					vehiculeEnDeplacement.setOrientationActuelle("N");
				}

				if (orientationActuelle.equals("S")) {
					vehiculeEnDeplacement.setOrientationActuelle("W");
				}
			}

			// Tourner à gauche

			// Modification de l'orientation

			if (instructionActuelle.equals("G")) {

				if (orientationActuelle.equals("N")) {
					vehiculeEnDeplacement.setOrientationActuelle("W");
				}

				if (orientationActuelle.equals("E")) {
					vehiculeEnDeplacement.setOrientationActuelle("N");
				}

				if (orientationActuelle.equals("W")) {
					vehiculeEnDeplacement.setOrientationActuelle("S");
				}

				if (orientationActuelle.equals("S")) {
					vehiculeEnDeplacement.setOrientationActuelle("E");
				}
			}

			// Avancer

			// Se rassurer que la future position est dans la surface
			// Si oui Avancer
			// Sinon, pas de mouvement, orientation conservée puis traiter
			// instruction suivante(indice suivant)
			// Ne pas modifier l'orientation

			if (instructionActuelle.equals("A")) {
				if (orientationActuelle.equals("N"))// y+1
				{
					int yActuelleFuture = yActuelle + 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= vehiculeEnDeplacement.getYCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setYActuelle(yActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("E"))// x+1
				{
					int xActuelleFuture = xActuelle + 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= vehiculeEnDeplacement.getXCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setXActuelle(xActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("W"))// x-1
				{
					int xActuelleFuture = xActuelle - 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= vehiculeEnDeplacement.getXCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setXActuelle(xActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("S"))// y-1
				{
					int yActuelleFuture = yActuelle - 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= vehiculeEnDeplacement.getYCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setYActuelle(yActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}
			}

		} // for

		// Stop chrono

		Chronometre.stopChrono();

		vehiculeEnDeplacement.setChronoFinale(Chronometre.getChrono());

		// Communication de la position et de l'orientation finale

		vehiculeEnDeplacement.setXFinale(vehiculeEnDeplacement.getXActuelle());

		vehiculeEnDeplacement.setYFinale(vehiculeEnDeplacement.getYActuelle());

		vehiculeEnDeplacement.setOrientationFinale(vehiculeEnDeplacement.getOrientationActuelle());

		AutonomousCarLog.logger.debug("CHRONO : " + vehiculeEnDeplacement.getChronoFinale() + " nanosecondes");

		AutonomousCarLog.logger
				.debug(String.format("CHRONO : %d nanosecondes", vehiculeEnDeplacement.getChronoFinale()));

		AutonomousCarLog.logger.debug("INIT");

		AutonomousCarLog.logger.debug(String.format(
				"POSITION XCOIN DROIT : %d  / POSITION YCOIN DROIT : %d / POSITION XINIT : %d / POSITION YINIT : %d / O INIT : %s",
				vehiculeEnDeplacement.getXCoinDroit(), vehiculeEnDeplacement.getYCoinDroit(),
				vehiculeEnDeplacement.getXInitiale(), vehiculeEnDeplacement.getYInitiale(),
				vehiculeEnDeplacement.getOrientationInitiale()));

		AutonomousCarLog.logger.debug(String.format(
				"INSTRUCTIONS :%s %n FIN %n POSITION X FINALE : %d / POSITION Y FINALE : %d / O FINALE : %s",
				vehiculeEnDeplacement.getInstructions(), vehiculeEnDeplacement.getXFinale(),
				vehiculeEnDeplacement.getYFinale(), vehiculeEnDeplacement.getOrientationFinale()));

	}

	// Déplacement sur la surface d'un véhicule (mode graphique)

	// SERVICE

	public void parcourirLaSurfaceGraphique(AutonomousCar vehiculeEnDeplacement)

	{

		String instructionsASuivre = vehiculeEnDeplacement.getInstructions();

		// Lancement du chronometre

		Chronometre.goChrono();

		for (int i = 0; i < instructionsASuivre.length(); i++) // Suivre les
																// instructions

		{
			String instructionActuelle = instructionsASuivre.charAt(i) + ""; // char
																				// to
																				// String

			String orientationActuelle = vehiculeEnDeplacement.getOrientationActuelle();

			int xActuelle = vehiculeEnDeplacement.getXActuelle();

			int yActuelle = vehiculeEnDeplacement.getYActuelle();

			// Tourner à droite

			// Modification de l'orientation

			if (instructionActuelle.equals("D"))

			{

				if (orientationActuelle.equals("N")) {
					vehiculeEnDeplacement.setOrientationActuelle("E");
				}

				if (orientationActuelle.equals("E")) {
					vehiculeEnDeplacement.setOrientationActuelle("S");
				}

				if (orientationActuelle.equals("W")) {
					vehiculeEnDeplacement.setOrientationActuelle("N");
				}

				if (orientationActuelle.equals("S")) {
					vehiculeEnDeplacement.setOrientationActuelle("W");
				}
			}

			// Tourner à gauche

			// Modification de l'orientation

			if (instructionActuelle.equals("G")) {

				if (orientationActuelle.equals("N")) {
					vehiculeEnDeplacement.setOrientationActuelle("W");
				}

				if (orientationActuelle.equals("E")) {
					vehiculeEnDeplacement.setOrientationActuelle("N");
				}

				if (orientationActuelle.equals("W")) {
					vehiculeEnDeplacement.setOrientationActuelle("S");
				}

				if (orientationActuelle.equals("S")) {
					vehiculeEnDeplacement.setOrientationActuelle("E");
				}
			}

			// Avancer

			// Se rassurer que la future position est dans la surface
			// Si oui Avancer
			// Sinon, pas de mouvement, orientation conservée puis traiter
			// instruction suivante(indice suivant)
			// Ne pas modifier l'orientation

			if (instructionActuelle.equals("A")) {
				if (orientationActuelle.equals("N"))// y+1
				{
					int yActuelleFuture = yActuelle + 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= vehiculeEnDeplacement.getYCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setYActuelle(yActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("E"))// x+1
				{
					int xActuelleFuture = xActuelle + 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= vehiculeEnDeplacement.getXCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setXActuelle(xActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("W"))// x-1
				{
					int xActuelleFuture = xActuelle - 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= vehiculeEnDeplacement.getXCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setXActuelle(xActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("S"))// y-1
				{
					int yActuelleFuture = yActuelle - 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= vehiculeEnDeplacement.getYCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setYActuelle(yActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}
			}

		} // for

		// Stop chrono

		Chronometre.stopChrono();

		vehiculeEnDeplacement.setChronoFinale(Chronometre.getChrono());

		// Communication de la position et de l'orientation finale

		vehiculeEnDeplacement.setXFinale(vehiculeEnDeplacement.getXActuelle());

		vehiculeEnDeplacement.setYFinale(vehiculeEnDeplacement.getYActuelle());

		vehiculeEnDeplacement.setOrientationFinale(vehiculeEnDeplacement.getOrientationActuelle());

		StringBuilder sbuf = new StringBuilder();
		Formatter fmt = new Formatter(sbuf);
		fmt.format(
				"CHRONO :  %d  nanosecondes %n INIT %n POSITION XCOIN DROIT :  %d / POSITION YCOIN DROIT : %d "
						+ "/ POSITION XINIT : %d /  POSITION YINIT : %d / O INIT : %s",
				vehiculeEnDeplacement.getChronoFinale(), vehiculeEnDeplacement.getXCoinDroit(),
				vehiculeEnDeplacement.getYCoinDroit(), vehiculeEnDeplacement.getXInitiale(),
				vehiculeEnDeplacement.getYInitiale(), vehiculeEnDeplacement.getOrientationInitiale());

		AutonomousCarLog.logger.debug(sbuf.toString());

		AutonomousCarLog.logger.debug(String.format(
				"INSTRUCTIONS :%s %n FIN %n" + " POSITION X FINALE : %d / POSITION Y FINALE : %d / O FINALE : %s",
				vehiculeEnDeplacement.getInstructions(), vehiculeEnDeplacement.getXFinale(),
				vehiculeEnDeplacement.getYFinale(), vehiculeEnDeplacement.getOrientationFinale()));

	}

	// Enregistrement des paramètres actuels

	// SERVICE

	public List<AutonomousCar> enregistrementParametresActuels(AutonomousCar vehiculeEnDeplacement)

	{

		// A chaque mise à jour des paramètres, j'ajoute à mon ArrayList

		List<AutonomousCar> vehiculeAvecParametresDifferents = new ArrayList<AutonomousCar>();

		// Enregistrement des paramètres initiaux du véhicule

		vehiculeAvecParametresDifferents
				.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(), vehiculeEnDeplacement.getYCoinDroit(),
						vehiculeEnDeplacement.getXInitiale(), vehiculeEnDeplacement.getYInitiale(),
						vehiculeEnDeplacement.getOrientationInitiale(), vehiculeEnDeplacement.getInstructions()));

		String instructionsASuivre = vehiculeEnDeplacement.getInstructions();

		for (int i = 0; i < instructionsASuivre.length(); i++) // Suivre les
																// instructions

		{
			String instructionActuelle = instructionsASuivre.charAt(i) + ""; // char
																				// to
																				// String

			String orientationActuelle = vehiculeEnDeplacement.getOrientationActuelle();

			int xActuelle = vehiculeEnDeplacement.getXActuelle();

			int yActuelle = vehiculeEnDeplacement.getYActuelle();

			// Tourner à droite

			// Modification de l'orientation

			if (instructionActuelle.equals("D"))

			{

				if (orientationActuelle.equals("N")) {
					vehiculeEnDeplacement.setOrientationActuelle("E");

					vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
							vehiculeEnDeplacement.getYCoinDroit(), vehiculeEnDeplacement.getXActuelle(),
							vehiculeEnDeplacement.getYActuelle(), "E", vehiculeEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("E")) {
					vehiculeEnDeplacement.setOrientationActuelle("S");

					vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
							vehiculeEnDeplacement.getYCoinDroit(), vehiculeEnDeplacement.getXActuelle(),
							vehiculeEnDeplacement.getYActuelle(), "S", vehiculeEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("W")) {
					vehiculeEnDeplacement.setOrientationActuelle("N");

					vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
							vehiculeEnDeplacement.getYCoinDroit(), vehiculeEnDeplacement.getXActuelle(),
							vehiculeEnDeplacement.getYActuelle(), "N", vehiculeEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("S")) {
					vehiculeEnDeplacement.setOrientationActuelle("W");

					vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
							vehiculeEnDeplacement.getYCoinDroit(), vehiculeEnDeplacement.getXActuelle(),
							vehiculeEnDeplacement.getYActuelle(), "W", vehiculeEnDeplacement.getInstructions()));
				}
			}

			// Tourner à gauche

			// Modification de l'orientation

			if (instructionActuelle.equals("G")) {

				if (orientationActuelle.equals("N")) {
					vehiculeEnDeplacement.setOrientationActuelle("W");

					vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
							vehiculeEnDeplacement.getYCoinDroit(), vehiculeEnDeplacement.getXActuelle(),
							vehiculeEnDeplacement.getYActuelle(), "W", vehiculeEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("E")) {
					vehiculeEnDeplacement.setOrientationActuelle("N");

					vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
							vehiculeEnDeplacement.getYCoinDroit(), vehiculeEnDeplacement.getXActuelle(),
							vehiculeEnDeplacement.getYActuelle(), "N", vehiculeEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("W")) {
					vehiculeEnDeplacement.setOrientationActuelle("S");

					vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
							vehiculeEnDeplacement.getYCoinDroit(), vehiculeEnDeplacement.getXActuelle(),
							vehiculeEnDeplacement.getYActuelle(), "S", vehiculeEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("S")) {
					vehiculeEnDeplacement.setOrientationActuelle("E");

					vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
							vehiculeEnDeplacement.getYCoinDroit(), vehiculeEnDeplacement.getXActuelle(),
							vehiculeEnDeplacement.getYActuelle(), "E", vehiculeEnDeplacement.getInstructions()));
				}
			}

			// Avancer

			// Se rassurer que la future position est dans la surface
			// Si oui Avancer
			// Sinon, pas de mouvement, orientation conservée puis traiter
			// instruction suivante(indice suivant)
			// Ne pas modifier l'orientation

			if (instructionActuelle.equals("A")) {
				if (orientationActuelle.equals("N"))// y+1
				{
					int yActuelleFuture = yActuelle + 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= vehiculeEnDeplacement.getYCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setYActuelle(yActuelleFuture);

						vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
								vehiculeEnDeplacement.getYCoinDroit(), vehiculeEnDeplacement.getXActuelle(),
								yActuelleFuture, vehiculeEnDeplacement.getOrientationActuelle(),
								vehiculeEnDeplacement.getInstructions()));
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("E"))// x+1
				{
					int xActuelleFuture = xActuelle + 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= vehiculeEnDeplacement.getXCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setXActuelle(xActuelleFuture);

						vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
								vehiculeEnDeplacement.getYCoinDroit(), xActuelleFuture,
								vehiculeEnDeplacement.getYActuelle(), vehiculeEnDeplacement.getOrientationActuelle(),
								vehiculeEnDeplacement.getInstructions()));
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("W"))// x-1
				{
					int xActuelleFuture = xActuelle - 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= vehiculeEnDeplacement.getXCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setXActuelle(xActuelleFuture);

						vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
								vehiculeEnDeplacement.getYCoinDroit(), xActuelleFuture,
								vehiculeEnDeplacement.getYActuelle(), vehiculeEnDeplacement.getOrientationActuelle(),
								vehiculeEnDeplacement.getInstructions()));
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("S"))// y-1
				{
					int yActuelleFuture = yActuelle - 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= vehiculeEnDeplacement.getYCoinDroit())// Avancer
					{
						vehiculeEnDeplacement.setYActuelle(yActuelleFuture);

						vehiculeAvecParametresDifferents.add(new AutonomousCar(vehiculeEnDeplacement.getXCoinDroit(),
								vehiculeEnDeplacement.getYCoinDroit(), vehiculeEnDeplacement.getXActuelle(),
								yActuelleFuture, vehiculeEnDeplacement.getOrientationActuelle(),
								vehiculeEnDeplacement.getInstructions()));
					} else {
						continue; // Passage à la commande suivante
					}
				}
			}

		} // for

		return vehiculeAvecParametresDifferents;
	}

}
