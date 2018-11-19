package com.autonomouscar.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import com.autonomouscar.controller.Chronometre;
import com.autonomouscar.controller.SpeechAxiv;

public class AutonomousCar {

	// Coins droits

	protected int xCoinDroit;

	protected int yCoinDroit;

	// Positions initiales

	protected int xTondeuseInitiale;

	protected int yTondeuseInitiale;

	protected String orientationTondeuseInitiale;

	protected String instructions;

	// Positions actuelles

	protected int xTondeuseActuelle;

	protected int yTondeuseActuelle;

	protected String orientationTondeuseActuelle;

	// Positions finales à atteindre

	protected int xTondeuseFinale;

	protected int yTondeuseFinale;

	protected String orientationTondeuseFinale;

	// Chrono du temps mis pour tondre le gazon par la tondeuse en ms

	protected long chronoFinale;

	public AutonomousCar(int xCoinDroit, int yCoinDroit, int xTondeuseInitiale, int yTondeuseInitiale,
			String orientationTondeuseInitiale, String instructions) {

		this.xCoinDroit = xCoinDroit;

		this.yCoinDroit = yCoinDroit;

		this.xTondeuseInitiale = xTondeuseInitiale;

		this.yTondeuseInitiale = yTondeuseInitiale;

		this.orientationTondeuseInitiale = orientationTondeuseInitiale;

		this.instructions = instructions;

		// Au départ la position et l'orientation actuelles sont identiques aux
		// données initiales

		this.xTondeuseActuelle = this.xTondeuseInitiale;

		this.yTondeuseActuelle = this.yTondeuseInitiale;

		this.orientationTondeuseActuelle = this.orientationTondeuseInitiale;

	}

	// Validation de nombre de tondeuses

	static boolean validationNombreDeTondeuses(int nombre) {
		boolean validation = false;

		if (nombre >= 1) {
			validation = true;

			System.out.println("Nombre correct");
		} else {
			System.out.println("Nombre incorrect");
		}

		return validation;
	}

	// Validation de nombre de tondeuses String

	public static boolean validationNombreDeTondeusesString(String nbre) {
		boolean validation = false;

		int entier = 0;

		if (AutonomousCar.isNombre(nbre) == true) {

			String nbreTrim = nbre.trim();

			entier = Integer.parseInt(nbreTrim);

			if (entier >= 1) {
				// correct

				validation = true;

			} else {

				System.out.println("INCORRECT");

			}

		} else {

			// Ce n'est pas un nombre

			System.out.println("INCORRECT");

		}

		return validation;
	}

	// Validation d'un nombre

	static boolean isNombre(String nbre) {

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

	// Setter et getter Coin droit

	public void setXCoinDroit(int xCoinDroit) {
		this.xCoinDroit = xCoinDroit;
	}

	public int getXCoinDroit() {
		return xCoinDroit;
	}

	public void setYCoinDroit(int yCoinDroit) {
		this.yCoinDroit = yCoinDroit;
	}

	public int getYCoinDroit() {
		return yCoinDroit;
	}

	// Setters et getters initiaux

	public void setXTondeuseInitiale(int xTondeuseInitiale) {
		this.xTondeuseInitiale = xTondeuseInitiale;
	}

	public int getXTondeuseInitiale() {
		return xTondeuseInitiale;
	}

	public void setYTondeuseInitiale(int yTondeuseInitiale) {
		this.yTondeuseInitiale = yTondeuseInitiale;
	}

	public int getYTondeuseInitiale() {
		return yTondeuseInitiale;
	}

	// Validation Positions entrées : int

	static boolean validationPositions(int xCoinDroit, int yCoinDroit, int xTondeuseInitiale, int yTondeuseInitiale) {

		boolean validation = false;

		if (xCoinDroit >= 0 && xCoinDroit <= 5 && yCoinDroit >= 0 && yCoinDroit <= 5) {
			if (xTondeuseInitiale >= 0 && xTondeuseInitiale <= xCoinDroit && yTondeuseInitiale >= 0
					&& yTondeuseInitiale <= yCoinDroit) {
				validation = true;

				System.out.println(" La tondeuse est bien positionnée sur la pelouse");
			} else {
				System.out.println(" Position incorrecte de la tondeuse");
			}
		} else {
			System.out.println(
					" Position incorrecte du coin supérieur droit de la pelouse, entrez des valeurs comprises entre 0 et 5");
		}

		return validation;
	}

	// Validation Positions entrées : string

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean validationPositionsString(String xCoinDroit, String yCoinDroit, String xTondeuseInitiale,
			String yTondeuseInitiale) {

		boolean validation = false;

		int xCoinDroitInt = 0, yCoinDroitInt = 0, xTondeuseInitialeInt = 0, yTondeuseInitialeInt = 0;

		if (AutonomousCar.isNombre(xCoinDroit) && AutonomousCar.isNombre(yCoinDroit) && AutonomousCar.isNombre(xTondeuseInitiale)
				&& AutonomousCar.isNombre(yTondeuseInitiale)) {

			xCoinDroitInt = Integer.parseInt(xCoinDroit.trim());

			yCoinDroitInt = Integer.parseInt(yCoinDroit.trim());

			xTondeuseInitialeInt = Integer.parseInt(xTondeuseInitiale.trim());

			yTondeuseInitialeInt = Integer.parseInt(yTondeuseInitiale.trim());

			if (xCoinDroitInt >= 0 && xCoinDroitInt <= 5 && yCoinDroitInt >= 0 && yCoinDroitInt <= 5) {
				if (xTondeuseInitialeInt >= 0 && xTondeuseInitialeInt <= xCoinDroitInt && yTondeuseInitialeInt >= 0
						&& yTondeuseInitialeInt <= yCoinDroitInt) {
					validation = true;

					System.out.println(" La tondeuse est bien positionnée sur la pelouse");
				} else {
					System.out.println(" Position incorrecte de la tondeuse");
				}
			} else {
				System.out.println(
						" Position incorrecte du coin supérieur droit de la pelouse, entrez des valeurs comprises entre 0 et 5");
			}

		} else {
			System.out.println("INCORRECT");
		}

		return validation;

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setOrientationTondeuseInitiale(String orientationTondeuseInitiale) {
		this.orientationTondeuseInitiale = orientationTondeuseInitiale;
	}

	public String getOrientationTondeuseInitiale() {
		return orientationTondeuseInitiale;
	}

	// Vérification orientation

	public static boolean validationOrientationTondeuseInitiale(String orientationTondeuseInitiale) {
		boolean validation = false;

		if (orientationTondeuseInitiale != null) {
			String orientationTondeuseInitialeTrim = orientationTondeuseInitiale.trim();

			if (orientationTondeuseInitialeTrim.length() != 0) {
				if (orientationTondeuseInitialeTrim.length() == 1) {
					if (orientationTondeuseInitialeTrim.equals("N") || orientationTondeuseInitialeTrim.equals("E")
							|| orientationTondeuseInitialeTrim.equals("W")
							|| orientationTondeuseInitialeTrim.equals("S")) {

						validation = true;

						System.out.println("Bravo :)pour la correcte orientation");

					} else {

						System.out.println("Veuillez entrer une lettre N , E , W ou S");

					} // 4e if
				} else {
					System.out.println("Veuillez entrer une lettre N , E , W ou S");
				} // 3e if
			} else {
				System.out.println("Veuillez entrer l'orientation");
			} // 2e if
		} else {
			System.out.println("Veuillez entrer l'orientation");
		} // 1er if

		return validation;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getInstructions() {
		return instructions;
	}

	// Vérification instructions

	public static boolean validationInstructions(String instructions) {

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
						System.out.println("Les espaces sont interdits dans vos instructions");

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
								System.out.println("Les instructions sont correctes, bravo :)");

								validation = true;

								System.out.println("Valeur :-" + instructions + "-");
							}

						} else {
							// Présence d'un intrus

							validation = false;

							System.out.println("Les instructions contiennent uniquement D, G ou A");

							break;
						}

					} // for

				} else {
					// Rien faire car espace présent
				}

			} else {
				System.out.println("Veuillez entrer des instructions");

			}
		} else {
			System.out.println("Veuillez entrer des instructions");
		}

		return validation;
	}

	// Setters et getters actuels

	public void setXTondeuseActuelle(int xTondeuseActuelle) {
		this.xTondeuseActuelle = xTondeuseActuelle;
	}

	public int getXTondeuseActuelle() {
		return xTondeuseActuelle;
	}

	public void setYTondeuseActuelle(int yTondeuseActuelle) {
		this.yTondeuseActuelle = yTondeuseActuelle;
	}

	public int getYTondeuseActuelle() {
		return yTondeuseActuelle;
	}

	public void setOrientationTondeuseActuelle(String orientationTondeuseActuelle) {
		this.orientationTondeuseActuelle = orientationTondeuseActuelle;
	}

	public String getOrientationTondeuseActuelle() {
		return orientationTondeuseActuelle;
	}

	// Setters et getters finaux

	public void setXTondeuseFinale(int xTondeuseFinale) {
		this.xTondeuseFinale = xTondeuseFinale;
	}

	public int getXTondeuseFinale() {
		return xTondeuseFinale;
	}

	public void setYTondeuseFinale(int yTondeuseFinale) {
		this.yTondeuseFinale = yTondeuseFinale;
	}

	public int getYTondeuseFinale() {
		return yTondeuseFinale;
	}

	public void setOrientationTondeuseFinale(String orientationTondeuseFinale) {
		this.orientationTondeuseFinale = orientationTondeuseFinale;
	}

	public String getOrientationTondeuseFinale() {
		return orientationTondeuseFinale;
	}

	// Setter et getter du Chrono du temps mis pour tondre le gazon par la
	// tondeuse

	public void setChronoFinale(long chronoFinale) {
		this.chronoFinale = chronoFinale;
	}

	public long getChronoFinale() {
		return chronoFinale;
	}

	// Récupération des données du fichier de base

	public static ArrayList<AutonomousCar> recupFichierBase() {

		ArrayList<AutonomousCar> listeInitiale = new ArrayList<AutonomousCar>();

		ArrayList<String> lignes = new ArrayList<String>();

		URL url = AutonomousCar.class.getResource("/fichierDeBase");

		File f = new File(url.getFile());

		FileInputStream fis = null;

		if (f.exists()) {
			if (f.isFile()) {
				// Début du traitement

				try {
					fis = new FileInputStream(f);

					byte[] buf = new byte[1024];

					int count = 0;

					int n = 0;

					String ligne = "";

					while ((n = fis.read(buf)) >= 0) {
						for (int i = 0; i < n; i++) {

							if (buf[i] != '\n') {
								ligne = ligne + (char) buf[i];
							}

							if (buf[i] == '\n') {

								// System.out.println(ligne);

								lignes.add(ligne);
								count++;

								ligne = "";
								/*
								 * Compter le nombre de retour à la ligne
								 * Sachant que le nombre de lignes se trouve en
								 * ajoutant 1 au nombre final de retour à la
								 * ligne
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

					/*
					 * for (int h = 0; h < listeInitiale.size(); h++) {
					 * System.out.println(listeInitiale.get(h).xCoinDroit + "" +
					 * listeInitiale.get(h).yCoinDroit + "" +
					 * listeInitiale.get(h).xTondeuseInitiale + "" +
					 * listeInitiale.get(h).yTondeuseInitiale + "" +
					 * listeInitiale.get(h).orientationTondeuseInitiale + "" +
					 * listeInitiale.get(h).instructions); }
					 */

				} catch (FileNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {

					try {
						if (fis != null)
							fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		} else {

			System.out.println("Fichier de base introuvable");

		}
		return listeInitiale;

	}

	// Intelligence Artificielle AXIV à l'oeuvre

	// Nombre de tondeuses

	static int getNombreDeTondeusesAXIV() {
		Random randomNumbers = new Random();

		int n = randomNumbers.nextInt(20) + 1; // 1 to 20

		return n; // 1 to 20
	}

	// XCoinDroitAXIV

	static int getXCoinDroitAXIV() {
		Random randomNumbers = new Random();

		return randomNumbers.nextInt(6); // 0 to 5
	}

	// YCoinDroitAXIV

	static int getYCoinDroitAXIV() {

		Random randomNumbers = new Random();

		return randomNumbers.nextInt(6); // 0 to 5
	}

	// XTondeuseInitialeAXIV

	static int getXTondeuseInitialeAXIV(int x) // X --> xCoinDroitAXIV
	{

		/*
		 * 0<=x<=5 et 0<=XTondeuseInitialeAXIV<=x donc si x=0 alors
		 * XTondeuseInitialeAXIV=0
		 */

		int n = 1; // Initialisation toute bête

		if (x == 0) {
			n = 0;
		} else {
			Random randomNumbers = new Random();

			n = randomNumbers.nextInt(x); // 0 to x
		}

		return n;

	}

	// YTondeuseInitialeAXIV

	static int getYTondeuseInitialeAXIV(int y) // Y --> yCoinDroitAXIV
	{

		/*
		 * 0<=y<=5 et 0<=YTondeuseInitialeAXIV<=y donc si y=0 alors
		 * YTondeuseInitialeAXIV=0
		 */

		int n = 1; // Initialisation toute bête

		if (y == 0) {
			n = 0;
		} else {
			Random randomNumbers = new Random();

			n = randomNumbers.nextInt(y); // 0 to y
		}

		return n;

	}

	// OrientationAXIV

	static String getOrientationTondeuseInitialeAXIV() {
		String tabOrientations[] = { "N", "E", "W", "S" };

		Random randomNumbers = new Random();

		return tabOrientations[randomNumbers.nextInt(tabOrientations.length)];

	}

	// InstructionsAXIV

	static String getInstructionsAXIV() {
		String tabInstructions[] = { "D", "G", "A" };

		Random randomNumbers = new Random();

		int tailleInstructions = randomNumbers.nextInt(50) + 1; // 1 to 50

		String instructionsAXIV = "";

		Random randomNumbers2 = new Random();

		for (int t = 0; t < tailleInstructions; t++) {
			instructionsAXIV = instructionsAXIV + tabInstructions[randomNumbers2.nextInt(tabInstructions.length)];
		}

		return instructionsAXIV;

	}

	// Génération Automatique AXIV

	public static ArrayList<AutonomousCar> getTondeusesAXIV() {
		ArrayList<AutonomousCar> liste = new ArrayList<AutonomousCar>();

		for (int i = 0; i < AutonomousCar.getNombreDeTondeusesAXIV(); i++) {

			int xCoinDroitAXIV = AutonomousCar.getXCoinDroitAXIV();

			int yCoinDroitAXIV = AutonomousCar.getYCoinDroitAXIV();

			int xTondeuseInitialeAXIV = AutonomousCar.getXTondeuseInitialeAXIV(xCoinDroitAXIV);

			int yTondeuseInitialeAXIV = AutonomousCar.getYTondeuseInitialeAXIV(yCoinDroitAXIV);

			String orientationAXIV = AutonomousCar.getOrientationTondeuseInitialeAXIV();

			String instructionsAXIV = AutonomousCar.getInstructionsAXIV();

			liste.add(new AutonomousCar(xCoinDroitAXIV, yCoinDroitAXIV, xTondeuseInitialeAXIV, yTondeuseInitialeAXIV,
					orientationAXIV, instructionsAXIV));

		}

		return liste;
	}

	// Déplacement sur le gazon de plusieurs tondeuses

	public static void deplacementDeToutesLesTondeuses(ArrayList<AutonomousCar> liste) {

		System.out.println("NOMBRE DE TONDEUSES DEPLOYEES :" + liste.size());

		SpeechAxiv.repete("NOMBRE DE TONDEUSES DEPLOYEES :" + liste.size());

		for (int c = 0; c < liste.size(); c++) {
			tondreLeGazon(liste.get(c));
		}
	}

	// Déplacement sur le gazon d'une tondeuse (mode console)

	private static void tondreLeGazon(AutonomousCar tondeuseEnDeplacement)

	{

		// Chrono chrono = new Chrono();

		String instructionsASuivre = tondeuseEnDeplacement.getInstructions();

		// Lancement du chronometre

		Chronometre.goChrono();

		for (int i = 0; i < instructionsASuivre.length(); i++) // Suivre les
																// instructions

		{
			String instructionActuelle = instructionsASuivre.charAt(i) + ""; // char
																				// to
																				// String

			String orientationActuelle = tondeuseEnDeplacement.getOrientationTondeuseActuelle();

			int xActuelle = tondeuseEnDeplacement.getXTondeuseActuelle();

			int yActuelle = tondeuseEnDeplacement.getYTondeuseActuelle();

			// Tourner à droite

			// Modification de l'orientation

			if (instructionActuelle.equals("D"))

			{

				if (orientationActuelle.equals("N")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("E");
				}

				if (orientationActuelle.equals("E")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("S");
				}

				if (orientationActuelle.equals("W")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("N");
				}

				if (orientationActuelle.equals("S")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("W");
				}
			}

			// Tourner à gauche

			// Modification de l'orientation

			if (instructionActuelle.equals("G")) {

				if (orientationActuelle.equals("N")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("W");
				}

				if (orientationActuelle.equals("E")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("N");
				}

				if (orientationActuelle.equals("W")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("S");
				}

				if (orientationActuelle.equals("S")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("E");
				}
			}

			// Avancer

			// Se rassurer que la future position est dans la pelouse
			// Si oui Avancer
			// Sinon, pas de mouvement, orientation conservée puis traiter
			// instruction suivante(indice suivant)
			// Ne pas modifier l'orientation

			if (instructionActuelle.equals("A")) {
				if (orientationActuelle.equals("N"))// y+1
				{
					int yActuelleFuture = yActuelle + 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= tondeuseEnDeplacement.getYCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setYTondeuseActuelle(yActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("E"))// x+1
				{
					int xActuelleFuture = xActuelle + 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= tondeuseEnDeplacement.getXCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setXTondeuseActuelle(xActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("W"))// x-1
				{
					int xActuelleFuture = xActuelle - 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= tondeuseEnDeplacement.getXCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setXTondeuseActuelle(xActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("S"))// y-1
				{
					int yActuelleFuture = yActuelle - 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= tondeuseEnDeplacement.getYCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setYTondeuseActuelle(yActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}
			}

		} // for

		// Stop chrono

		Chronometre.stopChrono();

		tondeuseEnDeplacement.setChronoFinale(Chronometre.getChrono());

		// Communication de la position et de l'orientation finale

		tondeuseEnDeplacement.setXTondeuseFinale(tondeuseEnDeplacement.getXTondeuseActuelle());

		tondeuseEnDeplacement.setYTondeuseFinale(tondeuseEnDeplacement.getYTondeuseActuelle());

		tondeuseEnDeplacement.setOrientationTondeuseFinale(tondeuseEnDeplacement.getOrientationTondeuseActuelle());

		System.out.println("CHRONO : " + tondeuseEnDeplacement.getChronoFinale() + " nanosecondes");

		System.out.println("INIT");

		System.out.println("POSITION XCOIN DROIT : " + tondeuseEnDeplacement.getXCoinDroit() + " / "
				+ "POSITION YCOIN DROIT : " + tondeuseEnDeplacement.getYCoinDroit() + " / " + "POSITION XINIT : "
				+ tondeuseEnDeplacement.getXTondeuseInitiale() + " / " + "POSITION YINIT : "
				+ tondeuseEnDeplacement.getYTondeuseInitiale() + " / " + "O INIT : "
				+ tondeuseEnDeplacement.getOrientationTondeuseInitiale());

		System.out.println("INSTRUCTIONS :" + tondeuseEnDeplacement.getInstructions());

		System.out.println("FIN");

		System.out.println("POSITION X FINALE : " + tondeuseEnDeplacement.getXTondeuseFinale()
				+ " / POSITION Y FINALE : " + tondeuseEnDeplacement.getYTondeuseFinale() + " / O FINALE : "
				+ tondeuseEnDeplacement.getOrientationTondeuseFinale());
	}

	// Déplacement sur le gazon d'une tondeuse (mode graphique)

	public static void tondreLeGazonGraphique(AutonomousCar tondeuseEnDeplacement)

	{

		// Chrono chrono = new Chrono();

		String instructionsASuivre = tondeuseEnDeplacement.getInstructions();

		// Lancement du chronometre

		Chronometre.goChrono();

		for (int i = 0; i < instructionsASuivre.length(); i++) // Suivre les
																// instructions

		{
			String instructionActuelle = instructionsASuivre.charAt(i) + ""; // char
																				// to
																				// String

			String orientationActuelle = tondeuseEnDeplacement.getOrientationTondeuseActuelle();

			int xActuelle = tondeuseEnDeplacement.getXTondeuseActuelle();

			int yActuelle = tondeuseEnDeplacement.getYTondeuseActuelle();

			// Tourner à droite

			// Modification de l'orientation

			if (instructionActuelle.equals("D"))

			{

				if (orientationActuelle.equals("N")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("E");
				}

				if (orientationActuelle.equals("E")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("S");
				}

				if (orientationActuelle.equals("W")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("N");
				}

				if (orientationActuelle.equals("S")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("W");
				}
			}

			// Tourner à gauche

			// Modification de l'orientation

			if (instructionActuelle.equals("G")) {

				if (orientationActuelle.equals("N")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("W");
				}

				if (orientationActuelle.equals("E")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("N");
				}

				if (orientationActuelle.equals("W")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("S");
				}

				if (orientationActuelle.equals("S")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("E");
				}
			}

			// Avancer

			// Se rassurer que la future position est dans la pelouse
			// Si oui Avancer
			// Sinon, pas de mouvement, orientation conservée puis traiter
			// instruction suivante(indice suivant)
			// Ne pas modifier l'orientation

			if (instructionActuelle.equals("A")) {
				if (orientationActuelle.equals("N"))// y+1
				{
					int yActuelleFuture = yActuelle + 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= tondeuseEnDeplacement.getYCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setYTondeuseActuelle(yActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("E"))// x+1
				{
					int xActuelleFuture = xActuelle + 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= tondeuseEnDeplacement.getXCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setXTondeuseActuelle(xActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("W"))// x-1
				{
					int xActuelleFuture = xActuelle - 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= tondeuseEnDeplacement.getXCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setXTondeuseActuelle(xActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("S"))// y-1
				{
					int yActuelleFuture = yActuelle - 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= tondeuseEnDeplacement.getYCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setYTondeuseActuelle(yActuelleFuture);
					} else {
						continue; // Passage à la commande suivante
					}
				}
			}

		} // for

		// Stop chrono

		Chronometre.stopChrono();

		tondeuseEnDeplacement.setChronoFinale(Chronometre.getChrono());

		// Communication de la position et de l'orientation finale

		tondeuseEnDeplacement.setXTondeuseFinale(tondeuseEnDeplacement.getXTondeuseActuelle());

		tondeuseEnDeplacement.setYTondeuseFinale(tondeuseEnDeplacement.getYTondeuseActuelle());

		tondeuseEnDeplacement.setOrientationTondeuseFinale(tondeuseEnDeplacement.getOrientationTondeuseActuelle());

		System.out.println("CHRONO : " + tondeuseEnDeplacement.getChronoFinale() + " nanosecondes");

		System.out.println("INIT");

		System.out.println("POSITION XCOIN DROIT : " + tondeuseEnDeplacement.getXCoinDroit() + " / "
				+ "POSITION YCOIN DROIT : " + tondeuseEnDeplacement.getYCoinDroit() + " / " + "POSITION XINIT : "
				+ tondeuseEnDeplacement.getXTondeuseInitiale() + " / " + "POSITION YINIT : "
				+ tondeuseEnDeplacement.getYTondeuseInitiale() + " / " + "O INIT : "
				+ tondeuseEnDeplacement.getOrientationTondeuseInitiale());

		System.out.println("INSTRUCTIONS :" + tondeuseEnDeplacement.getInstructions());

		System.out.println("FIN");

		System.out.println("POSITION X FINALE : " + tondeuseEnDeplacement.getXTondeuseFinale()
				+ " / POSITION Y FINALE : " + tondeuseEnDeplacement.getYTondeuseFinale() + " / O FINALE : "
				+ tondeuseEnDeplacement.getOrientationTondeuseFinale());
	}

	// Enregistrement des paramètres actuels

	public static ArrayList<AutonomousCar> enregistrementParametresActuels(AutonomousCar tondeuseEnDeplacement)

	{

		// A chaque mise à jour des paramètres, j'ajoute à mon ArrayList

		ArrayList<AutonomousCar> tondeuseAvecParametresDifferents = new ArrayList<AutonomousCar>();

		// Enregistrement des paramètres initiaux de la tondeuse

		tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
				tondeuseEnDeplacement.getYCoinDroit(), tondeuseEnDeplacement.getXTondeuseInitiale(),
				tondeuseEnDeplacement.getYTondeuseInitiale(), tondeuseEnDeplacement.getOrientationTondeuseInitiale(),
				tondeuseEnDeplacement.getInstructions()));

		String instructionsASuivre = tondeuseEnDeplacement.getInstructions();

		for (int i = 0; i < instructionsASuivre.length(); i++) // Suivre les
																// instructions

		{
			String instructionActuelle = instructionsASuivre.charAt(i) + ""; // char
																				// to
																				// String

			String orientationActuelle = tondeuseEnDeplacement.getOrientationTondeuseActuelle();

			int xActuelle = tondeuseEnDeplacement.getXTondeuseActuelle();

			int yActuelle = tondeuseEnDeplacement.getYTondeuseActuelle();

			// Tourner à droite

			// Modification de l'orientation

			if (instructionActuelle.equals("D"))

			{

				if (orientationActuelle.equals("N")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("E");

					tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
							tondeuseEnDeplacement.getYCoinDroit(), tondeuseEnDeplacement.getXTondeuseActuelle(),
							tondeuseEnDeplacement.getYTondeuseActuelle(), "E",
							tondeuseEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("E")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("S");

					tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
							tondeuseEnDeplacement.getYCoinDroit(), tondeuseEnDeplacement.getXTondeuseActuelle(),
							tondeuseEnDeplacement.getYTondeuseActuelle(), "S",
							tondeuseEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("W")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("N");

					tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
							tondeuseEnDeplacement.getYCoinDroit(), tondeuseEnDeplacement.getXTondeuseActuelle(),
							tondeuseEnDeplacement.getYTondeuseActuelle(), "N",
							tondeuseEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("S")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("W");

					tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
							tondeuseEnDeplacement.getYCoinDroit(), tondeuseEnDeplacement.getXTondeuseActuelle(),
							tondeuseEnDeplacement.getYTondeuseActuelle(), "W",
							tondeuseEnDeplacement.getInstructions()));
				}
			}

			// Tourner à gauche

			// Modification de l'orientation

			if (instructionActuelle.equals("G")) {

				if (orientationActuelle.equals("N")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("W");

					tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
							tondeuseEnDeplacement.getYCoinDroit(), tondeuseEnDeplacement.getXTondeuseActuelle(),
							tondeuseEnDeplacement.getYTondeuseActuelle(), "W",
							tondeuseEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("E")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("N");

					tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
							tondeuseEnDeplacement.getYCoinDroit(), tondeuseEnDeplacement.getXTondeuseActuelle(),
							tondeuseEnDeplacement.getYTondeuseActuelle(), "N",
							tondeuseEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("W")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("S");

					tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
							tondeuseEnDeplacement.getYCoinDroit(), tondeuseEnDeplacement.getXTondeuseActuelle(),
							tondeuseEnDeplacement.getYTondeuseActuelle(), "S",
							tondeuseEnDeplacement.getInstructions()));
				}

				if (orientationActuelle.equals("S")) {
					tondeuseEnDeplacement.setOrientationTondeuseActuelle("E");

					tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
							tondeuseEnDeplacement.getYCoinDroit(), tondeuseEnDeplacement.getXTondeuseActuelle(),
							tondeuseEnDeplacement.getYTondeuseActuelle(), "E",
							tondeuseEnDeplacement.getInstructions()));
				}
			}

			// Avancer

			// Se rassurer que la future position est dans la pelouse
			// Si oui Avancer
			// Sinon, pas de mouvement, orientation conservée puis traiter
			// instruction suivante(indice suivant)
			// Ne pas modifier l'orientation

			if (instructionActuelle.equals("A")) {
				if (orientationActuelle.equals("N"))// y+1
				{
					int yActuelleFuture = yActuelle + 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= tondeuseEnDeplacement.getYCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setYTondeuseActuelle(yActuelleFuture);

						tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
								tondeuseEnDeplacement.getYCoinDroit(), tondeuseEnDeplacement.getXTondeuseActuelle(),
								yActuelleFuture, tondeuseEnDeplacement.getOrientationTondeuseActuelle(),
								tondeuseEnDeplacement.getInstructions()));
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("E"))// x+1
				{
					int xActuelleFuture = xActuelle + 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= tondeuseEnDeplacement.getXCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setXTondeuseActuelle(xActuelleFuture);

						tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
								tondeuseEnDeplacement.getYCoinDroit(), xActuelleFuture,
								tondeuseEnDeplacement.getYTondeuseActuelle(),
								tondeuseEnDeplacement.getOrientationTondeuseActuelle(),
								tondeuseEnDeplacement.getInstructions()));
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("W"))// x-1
				{
					int xActuelleFuture = xActuelle - 1;

					if (0 <= xActuelleFuture && xActuelleFuture <= tondeuseEnDeplacement.getXCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setXTondeuseActuelle(xActuelleFuture);

						tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
								tondeuseEnDeplacement.getYCoinDroit(), xActuelleFuture,
								tondeuseEnDeplacement.getYTondeuseActuelle(),
								tondeuseEnDeplacement.getOrientationTondeuseActuelle(),
								tondeuseEnDeplacement.getInstructions()));
					} else {
						continue; // Passage à la commande suivante
					}
				}

				if (orientationActuelle.equals("S"))// y-1
				{
					int yActuelleFuture = yActuelle - 1;

					if (0 <= yActuelleFuture && yActuelleFuture <= tondeuseEnDeplacement.getYCoinDroit())// Avancer
					{
						tondeuseEnDeplacement.setYTondeuseActuelle(yActuelleFuture);

						tondeuseAvecParametresDifferents.add(new AutonomousCar(tondeuseEnDeplacement.getXCoinDroit(),
								tondeuseEnDeplacement.getYCoinDroit(), tondeuseEnDeplacement.getXTondeuseActuelle(),
								yActuelleFuture, tondeuseEnDeplacement.getOrientationTondeuseActuelle(),
								tondeuseEnDeplacement.getInstructions()));
					} else {
						continue; // Passage à la commande suivante
					}
				}
			}

		} // for

		return tondeuseAvecParametresDifferents;
	}

}
