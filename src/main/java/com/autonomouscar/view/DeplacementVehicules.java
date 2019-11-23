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
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.autonomouscar.model.AutonomousCar;
import com.autonomouscar.service.AutonomousCarService;
import com.autonomouscar.utils.Chronometre;

public class DeplacementVehicules extends JFrame {

	private DeplacementVehiculesPanneau4HWC container = new DeplacementVehiculesPanneau4HWC();

	private String origine = "";

	private List<AutonomousCar> listeVehicules = new ArrayList<>();

	private Border whiteBorder = new LineBorder(Color.WHITE, 1);

	private int compteurVehicules = 0;

	private Font policeCalibriLight = new Font("Calibri Light", Font.BOLD, 30);

	private Font policeCalibri = new Font("Calibri", Font.BOLD, 30);

	private Font policeAgencyFB = new Font("Agency FB", Font.BOLD, 30);

	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	public static final int ATTENTE = 1500;

	AutonomousCarService autonomousCarService = new AutonomousCarService();

	public DeplacementVehicules() {

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

		this.setIconImage(Bienvenue4HWC.icon4HWC.getImage());

		this.listeVehicules = ChargementDeplacementVehicules.listeVehicules;

		this.origine = ChargementDeplacementVehicules.origine;

		container.setLayout(new GridBagLayout());

		PositionOrientationTempsReelPanneau4HWC positionOrientationTempsReel = new PositionOrientationTempsReelPanneau4HWC();

		positionOrientationTempsReel.setPreferredSize(new Dimension(500, 70));

		//////////////////////////

		/*
		 * Boucle pour chaque tondeuse
		 */

		for (int i = 0; i < this.listeVehicules.size(); i++) {

			compteurVehicules++;

			// Lancement du chronometre

			Chronometre.goChrono();

			System.out.println("**************************************************************************");

			System.out.println("Nombre de véhicules déployées : " + this.listeVehicules.size());

			System.out.println("Véhicule N° : " + (i + 1));

			// Début du parcours de la boucle d'indice I

			// Je récupère la tondeuse d'indice i

			AutonomousCar vehicule = this.listeVehicules.get(i);

			String titleSuccesinit = "Le véhicule N°" + (i + 1) + "/ " + this.listeVehicules.size()
					+ " débute son parcours.";

			new DialogAvantParcours(null, titleSuccesinit, true, vehicule);

			System.out.println("INIT");

			System.out.println("POSITION XCOIN DROIT : " + vehicule.getXCoinDroit() + " / " + "POSITION YCOIN DROIT : "
					+ vehicule.getYCoinDroit() + " / " + "POSITION XINIT : " + vehicule.getXInitiale() + " / "
					+ "POSITION YINIT : " + vehicule.getYInitiale() + " / " + "O INIT : "
					+ vehicule.getOrientationInitiale());

			// Je récupère le véhicule et ses différentes positions

			List<AutonomousCar> vehiculeAvecParametresDifferents = autonomousCarService.autonomousCarStates(vehicule);

			// J'affiche le véhicule à différentes positions : Xactuelle;
			// Yactuelle et Oactuelle

			for (int j = 0; j < vehiculeAvecParametresDifferents.size(); j++)

			{
				DeplacementVehiculesSurface bitume = new DeplacementVehiculesSurface();

				bitume.setLayout(new GridBagLayout());

				int xCD = vehiculeAvecParametresDifferents.get(j).getXCoinDroit();

				int yCD = vehiculeAvecParametresDifferents.get(j).getYCoinDroit();

				GridBagConstraints gbcBitume = new GridBagConstraints();

				setDimensionsBitume(xCD, yCD, bitume);

				/*
				 * Boucle pour Création de surfaces rectangulaires pour la surface
				 */

				// Positionnement de la case de départ du composant

				gbcBitume.gridx = 0;

				gbcBitume.gridy = 0;

				// Taille en hauteur et largeur

				gbcBitume.gridheight = 1;

				gbcBitume.gridwidth = 1;

				/* Positionnement sur la surface */

				for (int posY = 0; posY <= yCD; posY++) {

					for (int posX = 0; posX <= xCD; posX++) {

						JPanel surface = new JPanel();
						surface.setPreferredSize(new Dimension(120, 72));
						surface.setOpaque(false);
						surface.setBorder(whiteBorder);

						surface.setLayout(new BorderLayout());

						bitume.add(surface, gbcBitume);

						gbcBitume.gridx++;

					} // posX

					gbcBitume.gridy++; // On passe à une autre ligne

					gbcBitume.gridx = 0; // Je me place à la 1ère colonne

				} // posY

				// fin du dessin des surfaces rectangulaires sur la surface

				// Affichage des différentes positions sur la surface

				affichageVehiculeSurBitume(gbcBitume, vehiculeAvecParametresDifferents.get(j), bitume);

				GridBagConstraints gbc = new GridBagConstraints();

				gbc.gridx = 0;

				gbc.gridy = 0;

				String textePositionOrientationInstantT = "( " + vehiculeAvecParametresDifferents.get(j).getXActuelle()
						+ " , " + vehiculeAvecParametresDifferents.get(j).getYActuelle() + " , "
						+ vehiculeAvecParametresDifferents.get(j).getOrientationActuelle() + " )";

				JLabel positionOrientationInstantT = new JLabel(textePositionOrientationInstantT);

				positionOrientationInstantT.setFont(policeAgencyFB);

				positionOrientationInstantT.setForeground(Color.WHITE);

				positionOrientationTempsReel.setLayout(new FlowLayout());

				positionOrientationTempsReel.add(positionOrientationInstantT);

				container.add(positionOrientationTempsReel, gbc);

				gbc.gridy = 1;

				container.add(bitume, gbc);

				this.setContentPane(container);

				this.setVisible(true);

				// Temps mis par le véhicule pour changer de position ou
				// d'orientation

				try {
					Thread.sleep(ATTENTE);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				positionOrientationTempsReel.removeAll();

				container.removeAll();

			} // Boucle for j

			// Fin du parcours du véhicule d'indice I

			// Stop chrono

			Chronometre.stopChrono();

			vehicule.setChronoFinale(Chronometre.getChrono());

			// Communication de la position et de l'orientation finale

			vehicule.setXFinale(vehicule.getXActuelle());

			vehicule.setYFinale(vehicule.getYActuelle());

			vehicule.setOrientationFinale(vehicule.getOrientationActuelle());

			System.out.println("CHRONO : " + vehicule.getChronoFinale() + " unités temporelles");

			System.out.println("FIN");

			System.out.println("POSITION X FINALE : " + vehicule.getXFinale() + " / POSITION Y FINALE : "
					+ vehicule.getYFinale() + " / O FINALE : " + vehicule.getOrientationFinale());

			System.out.println("**************************************************************************");

			String titleSuccess = "Le véhicule N°" + (i + 1) + "/ " + this.listeVehicules.size()
					+ " est bien arrivée à destination.";

			new DialogApresParcours(null, titleSuccess, true, vehicule);

		} // Boucle for i

		// Redirection vers le menu dès que tous les véhicules ont effectué
		// leurs parcours

		// Initialisation des paramètres statiques du formulaire pour permettre
		// une meilleure saisie

		if (compteurVehicules == this.listeVehicules.size()) {

			redirectionVersMenu();

		}

	} // Fin constructeur

	private void redirectionVersMenu() {

		if (this.origine.equals("paramètres")) {

			// Si les véhicules proviennent du formulaire

			FormulaireVehicules.compteur = 1;

			FormulaireVehicules.listeVehicules.clear();

		}

		this.dispose();

		new Menu4HWC();

	}

	private void setDimensionsBitume(int xCD, int yCD, DeplacementVehiculesSurface bitume) {

		int dimensionX = (xCD + 1) * 120;

		int dimensionY = (yCD + 1) * 72;

		bitume.setPreferredSize(new Dimension(dimensionX, dimensionY));
	}

	/*
	 * Mon repère est différent de celui de l'ordi donc il est important de
	 * convertir. On a le même axe des abscisses mais les axes des ordonnées ont des
	 * sens opposés.
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
	 * Cette fonction récupère les x;y et orientations actuelles et affiche le
	 * véhicule sur la surface
	 */

	private void affichageVehiculeSurBitume(GridBagConstraints gbc, AutonomousCar vehicule,
			DeplacementVehiculesSurface bitume) {

		DeplacementVehiculesSurfaceSens imageVehiculeActuelle = new DeplacementVehiculesSurfaceSens(
				vehicule.getOrientationActuelle());

		int xActuelle = vehicule.getXActuelle();

		int yActuelle = vehicule.getYActuelle();

		int yCD = vehicule.getYCoinDroit();

		gbc.gridx = xActuelle;

		gbc.gridy = DeplacementVehicules.ySurfaceToYComputer(yActuelle, yCD);

		JPanel surface = new JPanel();
		surface.setPreferredSize(new Dimension(120, 72));
		surface.setOpaque(false);
		surface.setBorder(whiteBorder);

		surface.setLayout(new BorderLayout());

		surface.add(imageVehiculeActuelle);

		bitume.add(surface, gbc);

		bitume.repaint();

	}

}
