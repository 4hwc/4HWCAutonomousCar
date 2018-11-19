package com.autonomouscar.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.autonomouscar.controller.Chronometre;
import com.autonomouscar.model.AutonomousCar;

public class DeplacementTondeuses extends JFrame {

	private DeplacementTondeusesPanneauAxivIt container = new DeplacementTondeusesPanneauAxivIt();

	private String origine = "";

	private ArrayList<AutonomousCar> listeTondeuses = new ArrayList<AutonomousCar>();

	private Border whiteBorder = new LineBorder(Color.WHITE, 1);

	private int compteurTondeuses = 0;

	private Font policeCalibriLight = new Font("Calibri Light", Font.BOLD, 30);

	private Font policeCalibri = new Font("Calibri", Font.BOLD, 30);

	private Font policeAgencyFB = new Font("Agency FB", Font.BOLD, 30);

	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	public DeplacementTondeuses() {

		this.setTitle("4HWC AUTONOMOUS CAR : Déplacement des véhicules");

		this.setSize(1000, 600);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				int Answer = JOptionPane.showConfirmDialog(null, "Etes vous sûr(e) de quitter ?", "Quitter",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (Answer == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});

		this.setResizable(false);

		this.setIconImage(BienvenueAxivIt.iconAxivIt.getImage());

		this.listeTondeuses = ChargementDeplacementTondeuses.listeTondeuses;

		this.origine = ChargementDeplacementTondeuses.origine;

		container.setLayout(new GridBagLayout());

		PositionOrientationTempsReelPanneauAxivIt positionOrientationTempsReel = new PositionOrientationTempsReelPanneauAxivIt();

		positionOrientationTempsReel.setPreferredSize(new Dimension(500, 70));

		//////////////////////////

		/*
		 * Boucle pour chaque tondeuse
		 */

		for (int i = 0; i < this.listeTondeuses.size(); i++) {

			compteurTondeuses++;

			// Lancement du chronometre

			Chronometre.goChrono();

			System.out.println("**************************************************************************");

			System.out.println("Nombre de tondeuses déployées : " + this.listeTondeuses.size());

			System.out.println("Tondeuse N° : " + (i + 1));

			// Début du parcours de la boucle d'indice I

			// Je récupère la tondeuse d'indice i

			AutonomousCar tondeuse = this.listeTondeuses.get(i);

			String titleSuccesinit = "Le véhicule N°" + (i + 1) + "/ " + this.listeTondeuses.size()
					+ " débute son parcours.";

			new DialogAvantParcours(null, titleSuccesinit, true, tondeuse);

			System.out.println("INIT");

			System.out.println("POSITION XCOIN DROIT : " + tondeuse.getXCoinDroit() + " / " + "POSITION YCOIN DROIT : "
					+ tondeuse.getYCoinDroit() + " / " + "POSITION XINIT : " + tondeuse.getXTondeuseInitiale() + " / "
					+ "POSITION YINIT : " + tondeuse.getYTondeuseInitiale() + " / " + "O INIT : "
					+ tondeuse.getOrientationTondeuseInitiale());

			// Je récupère la tondeuse et ses différentes positions

			ArrayList<AutonomousCar> tondeuseAvecParametresDifferents = AutonomousCar.enregistrementParametresActuels(tondeuse);

			// J'affiche la tondeuse à différentes positions : Xactuelle;
			// Yactuelle et Oactuelle

			for (int j = 0; j < tondeuseAvecParametresDifferents.size(); j++)

			{
				DeplacementTondeusesGazon gazon = new DeplacementTondeusesGazon();

				gazon.setLayout(new GridBagLayout());

				int xCD = tondeuseAvecParametresDifferents.get(j).getXCoinDroit();

				int yCD = tondeuseAvecParametresDifferents.get(j).getYCoinDroit();

				GridBagConstraints gbcGazon = new GridBagConstraints();

				setDimensionsGazon(xCD, yCD, gazon);

				/*
				 * Boucle pour Création de surfaces rectangulaires pour le gazon
				 */

				// Positionnement de la case de départ du composant

				gbcGazon.gridx = 0;

				gbcGazon.gridy = 0;

				// Taille en hauteur et largeur

				gbcGazon.gridheight = 1;

				gbcGazon.gridwidth = 1;

				/* Positionnement sur le gazon */

				for (int posY = 0; posY <= yCD; posY++) {

					for (int posX = 0; posX <= xCD; posX++) {

						JPanel surface = new JPanel();
						surface.setPreferredSize(new Dimension(120, 72));
						surface.setOpaque(false);
						surface.setBorder(whiteBorder);

						surface.setLayout(new BorderLayout());

						gazon.add(surface, gbcGazon);

						gbcGazon.gridx++;

					} // posX

					gbcGazon.gridy++; // On passe à une autre ligne

					gbcGazon.gridx = 0; // Je me place à la 1ère colonne

				} // posY

				// fin du dessin des surfaces rectangulaires sur le gazon

				// Affichage des différentes positions sur le gazon

				affichageTondeuseSurGazon(gbcGazon, tondeuseAvecParametresDifferents.get(j), gazon);

				GridBagConstraints gbc = new GridBagConstraints();

				gbc.gridx = 0;

				gbc.gridy = 0;

				String textePositionOrientationInstantT = "( "
						+ tondeuseAvecParametresDifferents.get(j).getXTondeuseActuelle() + " , "
						+ tondeuseAvecParametresDifferents.get(j).getYTondeuseActuelle() + " , "
						+ tondeuseAvecParametresDifferents.get(j).getOrientationTondeuseActuelle() + " )";

				JLabel positionOrientationInstantT = new JLabel(textePositionOrientationInstantT);

				positionOrientationInstantT.setFont(policeAgencyFB);

				positionOrientationInstantT.setForeground(Color.WHITE);

				positionOrientationTempsReel.setLayout(new FlowLayout());

				positionOrientationTempsReel.add(positionOrientationInstantT);

				container.add(positionOrientationTempsReel, gbc);

				gbc.gridy = 1;

				container.add(gazon, gbc);

				this.setContentPane(container);

				this.setVisible(true);

				// Temps mis par la tondeuse pour changer de position ou
				// d'orientation

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				positionOrientationTempsReel.removeAll();

				container.removeAll();

			} // Boucle for j

			// Fin du parcours de la tondeuse d'indice I

			// Stop chrono

			Chronometre.stopChrono();

			tondeuse.setChronoFinale(Chronometre.getChrono());

			// Communication de la position et de l'orientation finale

			tondeuse.setXTondeuseFinale(tondeuse.getXTondeuseActuelle());

			tondeuse.setYTondeuseFinale(tondeuse.getYTondeuseActuelle());

			tondeuse.setOrientationTondeuseFinale(tondeuse.getOrientationTondeuseActuelle());

			System.out.println("CHRONO : " + tondeuse.getChronoFinale() + " unités temporelles");

			System.out.println("FIN");

			System.out.println("POSITION X FINALE : " + tondeuse.getXTondeuseFinale() + " / POSITION Y FINALE : "
					+ tondeuse.getYTondeuseFinale() + " / O FINALE : " + tondeuse.getOrientationTondeuseFinale());

			System.out.println("**************************************************************************");

			String titleSuccess = "Le véhicule N°" + (i + 1) + "/ " + this.listeTondeuses.size()
					+ " est bien arrivée à destination.";

			new DialogApresParcours(null, titleSuccess, true, tondeuse);

		} // Boucle for i

		// Redirection vers le menu dès que toutes les tondeuses ont effectué
		// leurs parcours

		// Initialisation des paramètres statiques du formulaire pour permettre
		// une meilleure saisie

		if (compteurTondeuses == this.listeTondeuses.size()) {

			redirectionVersMenu();

		}

	} // Fin constructeur

	private void redirectionVersMenu() {

		if (this.origine.equals("paramètres")) {

			// Si les tondeuses proviennent du formulaire

			FormulaireTondeuses.compteur = 1;

			FormulaireTondeuses.listeTondeuses.clear();

		}

		this.setVisible(false);

		new MenuAxivIt();

	}

	private void setDimensionsGazon(int xCD, int yCD, DeplacementTondeusesGazon gazon) {

		int dimensionX = (xCD + 1) * 120;

		int dimensionY = (yCD + 1) * 72;

		gazon.setPreferredSize(new Dimension(dimensionX, dimensionY));
	}

	/*
	 * Mon repère est différent de celui de l'ordi donc il est important de
	 * convertir. Ona le même axe des abscisses mais les axes des ordonnées ont
	 * des sens opposés.
	 * 
	 * L'axe y de l'ordi est descendant, le mien est ascendant
	 * 
	 * 0<=x<=xCD<=5 0<=y<=yCD<=5
	 */

	static int yComputerToYSurface(int y, int yCD) {

		return (yCD - y);
	}

	static int ySurfaceToYComputer(int y, int yCD) {

		return (yCD - y);
	}

	/*
	 * Cette fonction récupère les x;y et orientations actuelles et affiche la
	 * tondeuse sur le gazon
	 */

	private void affichageTondeuseSurGazon(GridBagConstraints gbc, AutonomousCar tondeuse, DeplacementTondeusesGazon gazon) {

		DeplacementTondeusesGazonSens imageTondeuseActuelle = new DeplacementTondeusesGazonSens(
				tondeuse.getOrientationTondeuseActuelle());

		int xActuelle = tondeuse.getXTondeuseActuelle();

		int yActuelle = tondeuse.getYTondeuseActuelle();

		int yCD = tondeuse.getYCoinDroit();

		gbc.gridx = xActuelle;

		gbc.gridy = DeplacementTondeuses.ySurfaceToYComputer(yActuelle, yCD);

		JPanel surface = new JPanel();
		surface.setPreferredSize(new Dimension(120, 72));
		surface.setOpaque(false);
		surface.setBorder(whiteBorder);

		surface.setLayout(new BorderLayout());

		surface.add(imageTondeuseActuelle);

		gazon.add(surface, gbc);

		gazon.repaint();

	}

}
