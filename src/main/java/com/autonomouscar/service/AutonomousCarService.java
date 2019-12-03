package com.autonomouscar.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.autonomouscar.exceptions.AutonomousCarException;
import com.autonomouscar.logs.AutonomousCarLog;
import com.autonomouscar.model.AutonomousCar;

/**
 * 
 * <b>This class contains the application's logic</b>
 * 
 * 
 * @see AutonomousCarServiceTest
 * 
 * @see AutonomousCar
 * 
 * @author Fanon Jupkwo
 */

public class AutonomousCarService {

	/**
	 * Constant representing the maximum number of instructions generated randomly
	 * 
	 * @see AutonomousCarService#getInstructions4HWC()
	 */

	public static final int NUMBER_OF_INSTRUCTIONS_MAX = 50;

	/**
	 * Constant representing the maximum number of cars generated randomly
	 * 
	 * @see AutonomousCarService#getNombreDeVehicules4HWC()
	 */

	public static final int NUMBER_OF_VEHICLES_MAX = 20;

	/**
	 * Constant representing an error message related to wrong orientation
	 * 
	 * @see AutonomousCarService#validationOrientationInitiale(String)
	 */

	public static final String MESSAGEERRORNEWS = "Veuillez entrer une lettre N , E , W ou S";

	/**
	 * Constant representing an error message related to wrong orientation
	 * 
	 * @see AutonomousCarService#validationOrientationInitiale(String)
	 */

	public static final String MESSAGEERRORO = "Veuillez entrer l'orientation";

	/**
	 * Constant representing an error message related to wrong position on the
	 * surface
	 * 
	 * @see AutonomousCarService#validationPositionsString(String, String, String,
	 *      String)
	 */

	public static final String MESSAGEERRORVEHICULE = "S'il vous plaît choisissez une position correcte du véhicule";

	/**
	 * Constant representing an error message related to wrong dimensions of the
	 * surface
	 * 
	 * @see AutonomousCarService#validationPositionsString(String, String, String,
	 *      String)
	 */

	public static final String MESSAGEERRORCD = "S'il vous plaît choisissez une position correcte du coin Supérieur Droit";

	/**
	 * Constant representing an error message related to wrong number of cars
	 * 
	 * @see AutonomousCarService#validationNombreDeVehiculesString(String)
	 */

	public static final String MESSAGEERRORNBRE = "S'il vous plaît saisissez des caractères numériques";

	/**
	 * Constant representing an error message related to wrong instructions
	 * 
	 * @see AutonomousCarService#validationInstructions(String)
	 */

	public static final String MESSAGEERRORESPACES = "Les espaces sont interdits dans vos instructions";

	/**
	 * Constant representing an error message related to wrong instructions
	 * 
	 * @see AutonomousCarService#validationInstructions(String)
	 */

	public static final String MESSAGEERRORDGA = "Les instructions contiennent uniquement D, G ou A";

	/**
	 * Constant representing an error message related to wrong instructions
	 * 
	 * @see AutonomousCarService#validationInstructions(String)
	 */

	public static final String MESSAGEERRORI = "Veuillez entrer des instructions";

	/**
	 * Constant representing an error message related to wrong number of cars
	 * 
	 * @see AutonomousCarService#validationNombreDeVehiculesString(String)
	 */

	public static final String MESSAGEERRORNUMBEROFCARS = "S'il vous plaît choisissez un nombre supérieur ou égal à 1";

	/**
	 * 
	 * Verifies if the number of cars is correct
	 * 
	 * @param nbre
	 * @throws AutonomousCarException if nbre is not a number or if nbre is inferior
	 *                                than 1
	 */

	public void validationNombreDeVehicules(String nbre) throws AutonomousCarException {

		try {
			int number = Integer.parseInt(nbre.trim());

			if (number >= 1) {

			}

			else {
				throw new AutonomousCarException(MESSAGEERRORNUMBEROFCARS);
			}

		} catch (NumberFormatException e) {

			throw new AutonomousCarException(MESSAGEERRORNUMBEROFCARS);

		}

	}

	/**
	 * 
	 * Verifies if the orientation is correct
	 * 
	 * @param orientationInitiale
	 * @throws AutonomousCarException
	 */

	public void validationOrientationInitiale(String orientationInitiale) throws AutonomousCarException {

		if (orientationInitiale != null) {
			String orientationInitialeTrim = orientationInitiale.trim().toUpperCase();

			if (orientationInitialeTrim.length() != 0) {
				if (orientationInitialeTrim.length() == 1) {
					if (orientationInitialeTrim.equals("N") || orientationInitialeTrim.equals("E")
							|| orientationInitialeTrim.equals("W") || orientationInitialeTrim.equals("S")) {

					} else {

						// AutonomousCarLog.logger.error("Veuillez entrer une lettre N , E , W ou S");
						throw new AutonomousCarException(MESSAGEERRORNEWS);

					} // 4e if
				} else {

					// AutonomousCarLog.logger.error("Veuillez entrer une lettre N , E , W ou S");
					throw new AutonomousCarException(MESSAGEERRORNEWS);
				} // 3e if
			} else {

				// AutonomousCarLog.logger.error("Veuillez entrer l'orientation");
				throw new AutonomousCarException(MESSAGEERRORO);
			} // 2e if
		} else {

			// AutonomousCarLog.logger.error("Veuillez entrer l'orientation");
			throw new AutonomousCarException(MESSAGEERRORO);
		} // 1er if

	}

	/**
	 * 
	 * Verifies if car's position and surface dimensions are correct
	 * 
	 * @param xCoinDroit
	 * @param yCoinDroit
	 * @param orientationInitiale
	 * @param orientationInitiale
	 * @throws AutonomousCarException
	 */

	public void validationPositions(String xCoinDroit, String yCoinDroit, String xInitiale, String yInitiale)
			throws AutonomousCarException {

		try {

			int xCoinDroitInt = Integer.parseInt(xCoinDroit.trim());

			int yCoinDroitInt = Integer.parseInt(yCoinDroit.trim());

			int xInitialeInt = Integer.parseInt(xInitiale.trim());

			int yInitialeInt = Integer.parseInt(yInitiale.trim());

			if (xCoinDroitInt >= 0 && xCoinDroitInt <= 5 && yCoinDroitInt >= 0 && yCoinDroitInt <= 5) {
				if (xInitialeInt >= 0 && xInitialeInt <= xCoinDroitInt && yInitialeInt >= 0
						&& yInitialeInt <= yCoinDroitInt) {

				} else {

					throw new AutonomousCarException(MESSAGEERRORVEHICULE);
				}
			} else {
				throw new AutonomousCarException(MESSAGEERRORCD);

			}

		} catch (NumberFormatException e) {

			throw new AutonomousCarException(MESSAGEERRORNBRE);

		}

	}

	/**
	 * 
	 * Verifies if instructions are correct
	 * 
	 * @param instructions
	 * @throws AutonomousCarException
	 */

	public void validationInstructions(String instructions) throws AutonomousCarException {

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

						throw new AutonomousCarException(MESSAGEERRORESPACES);

					}
				} // for

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

						}

					} else {
						// Présence d'un intrus

						throw new AutonomousCarException(MESSAGEERRORDGA);

					}

				} // for

			} else {

				throw new AutonomousCarException(MESSAGEERRORI);

			}
		} else {
			throw new AutonomousCarException(MESSAGEERRORI);
		}

	}

	/**
	 * Reads Cars Data from a file
	 * 
	 */

	public List<AutonomousCar> recupFichierBase() {

		List<AutonomousCar> listeInitiale = new ArrayList<>();

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

	/**
	 * Using Random class to generate a number of cars from 1 to
	 * {@value AutonomousCarService#NUMBER_OF_VEHICLES_MAX}
	 * 
	 * @see AutonomousCarService#NUMBER_OF_VEHICLES_MAX
	 * 
	 * @return Returns the number of cars generated randomly
	 * 
	 */

	private int getNombreDeVehicules4HWC() {
		Random randomNumbers = new Random();

		return randomNumbers.nextInt(NUMBER_OF_VEHICLES_MAX) + 1;
	}

	/**
	 * Using Random class to generate a number from 0 to 5 representing
	 * {@link AutonomousCar#getXCoinDroit()} and
	 * {@link AutonomousCar#getYCoinDroit()}
	 * 
	 * 
	 * @return Returns a number from 0 to 5
	 * 
	 */

	public int getXYCoinDroit4HWC() {

		return new Random().nextInt(6);
	}

	/**
	 * Using Random class to generate a number from 1 to
	 * {@link AutonomousCarService#getXYCoinDroit4HWC()} representing
	 * {@link AutonomousCar#getXInitiale()} and {@link AutonomousCar#getYInitiale()}
	 * 
	 * 
	 * @param xy representing {@link AutonomousCarService#getXYCoinDroit4HWC()}
	 * 
	 * 
	 * @return Returns a number from 0 to 5
	 * 
	 */

	public int getXYInitiale4HWC(int xy) {

		return new Random().nextInt(xy + 1);

	}

	/**
	 * Using Random class to generate an initial orientation amongst N,E,W,S
	 * representing {@link AutonomousCar#getOrientationInitiale()}
	 * 
	 * 
	 * @return Returns a value amongst N,E,W,S
	 * 
	 */

	private String getOrientationInitiale4HWC() {
		String tabOrientations[] = { "N", "E", "W", "S" };

		Random randomNumbers = new Random();

		return tabOrientations[randomNumbers.nextInt(tabOrientations.length)];

	}

	/**
	 * Using Random class to generate instructions defined by D,G or A representing
	 * {@link AutonomousCar#getInstructions()}
	 * 
	 * 
	 * @return Returns a String defined by D,G or A
	 * 
	 */

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

	/**
	 * <p>
	 * Generates a list of Autonomous Cars using those methods:
	 * <ul>
	 * <li>AutonomousCarService{@link #getNombreDeVehicules4HWC()}</li>
	 * <li>AutonomousCarService{@link #getXYCoinDroit4HWC()}</li>
	 * <li>AutonomousCarService{@link #getXYInitiale4HWC(int)}</li>
	 * <li>AutonomousCarService{@link #getOrientationInitiale4HWC()}</li>
	 * <li>AutonomousCarService{@link #getInstructions4HWC()}</li>
	 * </ul>
	 * </p>
	 * 
	 * 
	 * 
	 * @return Returns List<AutonomousCar> generated randomly
	 * 
	 */

	public List<AutonomousCar> getVehicules4HWC() {

		List<AutonomousCar> liste = new ArrayList<AutonomousCar>();

		for (int i = 0; i < getNombreDeVehicules4HWC(); i++) {

			/*
			 * Initial postions depends on Surface so it's important to save it first. if
			 * not the values will be wrong.
			 * 
			 */

			int xCD = getXYCoinDroit4HWC();

			int yCD = getXYCoinDroit4HWC();

			liste.add(new AutonomousCar(xCD, yCD, getXYInitiale4HWC(xCD), getXYInitiale4HWC(yCD),
					getOrientationInitiale4HWC(), getInstructions4HWC()));

		}

		return liste;
	}

	/**
	 * @param vehiculeEnDeplacement
	 * 
	 *                              Generate a list of Autonomous Cars representing
	 *                              the states of vehiculeEnDeplacement.
	 * 
	 *                              Each AutonomousCar present in the list
	 *                              represents a state of the main car
	 *                              vehiculeEnDeplacement.
	 * 
	 *                              The states of vehiculeEnDeplacement are
	 *                              recorded.
	 * 
	 * 
	 * 
	 * @return List<AutonomousCar>
	 */

	public List<AutonomousCar> autonomousCarStates(AutonomousCar vehiculeEnDeplacement)

	{

		// A chaque mise à jour des paramètres, j'ajoute à mon ArrayList

		List<AutonomousCar> vehiculeAvecParametresDifferents = new ArrayList<>();

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
						continue; // Passage à l'instruction suivante
					}
				}
			}

		} // for

		return vehiculeAvecParametresDifferents;
	}

}
