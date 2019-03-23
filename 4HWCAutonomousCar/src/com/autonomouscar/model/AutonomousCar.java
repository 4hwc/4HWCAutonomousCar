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

	protected int xInitiale;

	protected int yInitiale;

	protected String orientationInitiale;

	protected String instructions;

	// Positions actuelles

	protected int xActuelle;

	protected int yActuelle;

	protected String orientationActuelle;

	// Positions finales à atteindre

	protected int xFinale;

	protected int yFinale;

	protected String orientationFinale;

	// Chrono du temps mis pour parcourir la surface par la voiture en ms

	protected long chronoFinale;

	public AutonomousCar(int xCoinDroit, int yCoinDroit, int xInitiale, int yInitiale, String orientationInitiale,
			String instructions) {

		this.xCoinDroit = xCoinDroit;

		this.yCoinDroit = yCoinDroit;

		this.xInitiale = xInitiale;

		this.yInitiale = yInitiale;

		this.orientationInitiale = orientationInitiale;

		this.instructions = instructions;

		// Au départ la position et l'orientation actuelles sont identiques aux
		// données initiales

		this.xActuelle = this.xInitiale;

		this.yActuelle = this.yInitiale;

		this.orientationActuelle = this.orientationInitiale;

	}

	// Validation de nombre de véhicules

	static boolean validationNombreDeVehicules(int nombre) {
		boolean validation = false;

		if (nombre >= 1) {
			validation = true;

			System.out.println("Nombre correct");
		} else {
			System.out.println("Nombre incorrect");
		}

		return validation;
	}

	// Validation de nombre de véhicules String

	public static boolean validationNombreDeVehiculesString(String nbre) {
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

	public void setXInitiale(int xInitiale) {
		this.xInitiale = xInitiale;
	}

	public int getXInitiale() {
		return xInitiale;
	}

	public void setYInitiale(int yInitiale) {
		this.yInitiale = yInitiale;
	}

	public int getYInitiale() {
		return yInitiale;
	}

	// Validation Positions entrées : int

	static boolean validationPositions(int xCoinDroit, int yCoinDroit, int xInitiale, int yInitiale) {

		boolean validation = false;

		if (xCoinDroit >= 0 && xCoinDroit <= 5 && yCoinDroit >= 0 && yCoinDroit <= 5) {
			if (xInitiale >= 0 && xInitiale <= xCoinDroit && yInitiale >= 0 && yInitiale <= yCoinDroit) {
				validation = true;

				System.out.println(" Le véhicule est bien positionné sur la surface");
			} else {
				System.out.println(" Position incorrecte du véhicule");
			}
		} else {
			System.out.println(
					" Position incorrecte du coin supérieur droit de la surface, entrez des valeurs comprises entre 0 et 5");
		}

		return validation;
	}

	// Validation Positions entrées : string

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean validationPositionsString(String xCoinDroit, String yCoinDroit, String xInitiale,
			String yInitiale) {

		boolean validation = false;

		int xCoinDroitInt = 0, yCoinDroitInt = 0, xInitialeInt = 0, yInitialeInt = 0;

		if (AutonomousCar.isNombre(xCoinDroit) && AutonomousCar.isNombre(yCoinDroit)
				&& AutonomousCar.isNombre(xInitiale) && AutonomousCar.isNombre(yInitiale)) {

			xCoinDroitInt = Integer.parseInt(xCoinDroit.trim());

			yCoinDroitInt = Integer.parseInt(yCoinDroit.trim());

			xInitialeInt = Integer.parseInt(xInitiale.trim());

			yInitialeInt = Integer.parseInt(yInitiale.trim());

			if (xCoinDroitInt >= 0 && xCoinDroitInt <= 5 && yCoinDroitInt >= 0 && yCoinDroitInt <= 5) {
				if (xInitialeInt >= 0 && xInitialeInt <= xCoinDroitInt && yInitialeInt >= 0
						&& yInitialeInt <= yCoinDroitInt) {
					validation = true;

					System.out.println(" Le véhicule est bien positionné sur la surface");
				} else {
					System.out.println(" Position incorrecte du véhicule");
				}
			} else {
				System.out.println(
						" Position incorrecte du coin supérieur droit de la surface, entrez des valeurs comprises entre 0 et 5");
			}

		} else {
			System.out.println("INCORRECT");
		}

		return validation;

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setOrientationInitiale(String orientationInitiale) {
		this.orientationInitiale = orientationInitiale;
	}

	public String getOrientationInitiale() {
		return orientationInitiale;
	}

	// Vérification orientation

	public static boolean validationOrientationInitiale(String orientationInitiale) {
		boolean validation = false;

		if (orientationInitiale != null) {
			String orientationInitialeTrim = orientationInitiale.trim();

			if (orientationInitialeTrim.length() != 0) {
				if (orientationInitialeTrim.length() == 1) {
					if (orientationInitialeTrim.equals("N") || orientationInitialeTrim.equals("E")
							|| orientationInitialeTrim.equals("W") || orientationInitialeTrim.equals("S")) {

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

	public void setXActuelle(int xActuelle) {
		this.xActuelle = xActuelle;
	}

	public int getXActuelle() {
		return xActuelle;
	}

	public void setYActuelle(int yActuelle) {
		this.yActuelle = yActuelle;
	}

	public int getYActuelle() {
		return yActuelle;
	}

	public void setOrientationActuelle(String orientationActuelle) {
		this.orientationActuelle = orientationActuelle;
	}

	public String getOrientationActuelle() {
		return orientationActuelle;
	}

	// Setters et getters finaux

	public void setXFinale(int xFinale) {
		this.xFinale = xFinale;
	}

	public int getXFinale() {
		return xFinale;
	}

	public void setYFinale(int yFinale) {
		this.yFinale = yFinale;
	}

	public int getYFinale() {
		return yFinale;
	}

	public void setOrientationFinale(String orientationFinale) {
		this.orientationFinale = orientationFinale;
	}

	public String getOrientationFinale() {
		return orientationFinale;
	}

	// Setter et getter du Chrono du temps mis pour parcourir par la
	// voiture

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

					byte[] buf = new byte[2048];

					int count = 0;

					int n = 0;

					String ligne = "";

					while ((n = fis.read(buf)) >= 0) {
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

					/*
					 * for (int h = 0; h < listeInitiale.size(); h++) {
					 * System.out.println(listeInitiale.get(h).xCoinDroit + "" +
					 * listeInitiale.get(h).yCoinDroit + "" + listeInitiale.get(h).xInitiale + "" +
					 * listeInitiale.get(h).yInitiale + "" +
					 * listeInitiale.get(h).orientationInitiale + "" +
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

	// Intelligence Artificielle 4HWC à l'oeuvre

	// Nombre de véhicules

	static int getNombreDeVehicules4HWC() {
		Random randomNumbers = new Random();

		int n = randomNumbers.nextInt(20) + 1; // 1 to 20

		return n; // 1 to 20
	}

	// XCoinDroit4HWC

	static int getXCoinDroit4HWC() {
		Random randomNumbers = new Random();

		return randomNumbers.nextInt(6); // 0 to 5
	}

	// YCoinDroit4HWC

	static int getYCoinDroit4HWC() {

		Random randomNumbers = new Random();

		return randomNumbers.nextInt(6); // 0 to 5
	}

	// XInitiale4HWC

	static int getXInitiale4HWC(int x) // X --> xCoinDroit4HWC
	{

		/*
		 * 0<=x<=5 et 0<=XInitiale4HWC<=x donc si x=0 alors XInitiale4HWC=0
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

	// YInitiale4HWC

	static int getYInitiale4HWC(int y) // Y --> yCoinDroit4HWC
	{

		/*
		 * 0<=y<=5 et 0<=YInitiale4HWC<=y donc si y=0 alors YInitiale4HWC=0
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

	// Orientation4HWC

	static String getOrientationInitiale4HWC() {
		String tabOrientations[] = { "N", "E", "W", "S" };

		Random randomNumbers = new Random();

		return tabOrientations[randomNumbers.nextInt(tabOrientations.length)];

	}

	// Instructions4HWC

	static String getInstructions4HWC() {
		String tabInstructions[] = { "D", "G", "A" };

		Random randomNumbers = new Random();

		int tailleInstructions = randomNumbers.nextInt(50) + 1; // 1 to 50

		String instructions4HWC = "";

		Random randomNumbers2 = new Random();

		for (int t = 0; t < tailleInstructions; t++) {
			instructions4HWC = instructions4HWC + tabInstructions[randomNumbers2.nextInt(tabInstructions.length)];
		}

		return instructions4HWC;

	}

	// Génération Automatique 4HWC

	public static ArrayList<AutonomousCar> getVehicules4HWC() {
		ArrayList<AutonomousCar> liste = new ArrayList<AutonomousCar>();

		for (int i = 0; i < AutonomousCar.getNombreDeVehicules4HWC(); i++) {

			int xCoinDroit4HWC = AutonomousCar.getXCoinDroit4HWC();

			int yCoinDroit4HWC = AutonomousCar.getYCoinDroit4HWC();

			int xInitiale4HWC = AutonomousCar.getXInitiale4HWC(xCoinDroit4HWC);

			int yInitiale4HWC = AutonomousCar.getYInitiale4HWC(yCoinDroit4HWC);

			String orientation4HWC = AutonomousCar.getOrientationInitiale4HWC();

			String instructions4HWC = AutonomousCar.getInstructions4HWC();

			liste.add(new AutonomousCar(xCoinDroit4HWC, yCoinDroit4HWC, xInitiale4HWC, yInitiale4HWC, orientation4HWC,
					instructions4HWC));

		}

		return liste;
	}

	// Déplacement sur la surface de plusieurs véhicules

	public static void deplacementDeTousLesVehicules(ArrayList<AutonomousCar> liste) {

		System.out.println("NOMBRE DE VEHICULES DEPLOYEES :" + liste.size());

		SpeechAxiv.repete("NOMBRE DE VEHICULES DEPLOYEES :" + liste.size());

		for (int c = 0; c < liste.size(); c++) {
			parcourirLaSurface(liste.get(c));
		}
	}

	// Déplacement sur la surface d'un véhicule (mode console)

	private static void parcourirLaSurface(AutonomousCar vehiculeEnDeplacement)

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

		System.out.println("CHRONO : " + vehiculeEnDeplacement.getChronoFinale() + " nanosecondes");

		System.out.println("INIT");

		System.out.println("POSITION XCOIN DROIT : " + vehiculeEnDeplacement.getXCoinDroit() + " / "
				+ "POSITION YCOIN DROIT : " + vehiculeEnDeplacement.getYCoinDroit() + " / " + "POSITION XINIT : "
				+ vehiculeEnDeplacement.getXInitiale() + " / " + "POSITION YINIT : "
				+ vehiculeEnDeplacement.getYInitiale() + " / " + "O INIT : "
				+ vehiculeEnDeplacement.getOrientationInitiale());

		System.out.println("INSTRUCTIONS :" + vehiculeEnDeplacement.getInstructions());

		System.out.println("FIN");

		System.out.println("POSITION X FINALE : " + vehiculeEnDeplacement.getXFinale() + " / POSITION Y FINALE : "
				+ vehiculeEnDeplacement.getYFinale() + " / O FINALE : " + vehiculeEnDeplacement.getOrientationFinale());
	}

	// Déplacement sur la surface d'un véhicule (mode graphique)

	public static void parcourirLaSurfaceGraphique(AutonomousCar vehiculeEnDeplacement)

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

		System.out.println("CHRONO : " + vehiculeEnDeplacement.getChronoFinale() + " nanosecondes");

		System.out.println("INIT");

		System.out.println("POSITION XCOIN DROIT : " + vehiculeEnDeplacement.getXCoinDroit() + " / "
				+ "POSITION YCOIN DROIT : " + vehiculeEnDeplacement.getYCoinDroit() + " / " + "POSITION XINIT : "
				+ vehiculeEnDeplacement.getXInitiale() + " / " + "POSITION YINIT : "
				+ vehiculeEnDeplacement.getYInitiale() + " / " + "O INIT : "
				+ vehiculeEnDeplacement.getOrientationInitiale());

		System.out.println("INSTRUCTIONS :" + vehiculeEnDeplacement.getInstructions());

		System.out.println("FIN");

		System.out.println("POSITION X FINALE : " + vehiculeEnDeplacement.getXFinale() + " / POSITION Y FINALE : "
				+ vehiculeEnDeplacement.getYFinale() + " / O FINALE : " + vehiculeEnDeplacement.getOrientationFinale());
	}

	// Enregistrement des paramètres actuels

	public static ArrayList<AutonomousCar> enregistrementParametresActuels(AutonomousCar vehiculeEnDeplacement)

	{

		// A chaque mise à jour des paramètres, j'ajoute à mon ArrayList

		ArrayList<AutonomousCar> vehiculeAvecParametresDifferents = new ArrayList<AutonomousCar>();

		// Enregistrement des paramètres initiaux de la tondeuse

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
