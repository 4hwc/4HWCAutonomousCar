package com.autonomouscar.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.autonomouscar.model.AutonomousCar;

public class FormulaireVehicules extends JFrame implements ActionListener {

	private FormulaireVehiculesPanneau4HWC container = new FormulaireVehiculesPanneau4HWC();

	private JTextField jtfInstructions = new JTextField("Instructions constituées des lettres D; G et A sans espaces");

	private JTextField jtfOrientation = new JTextField("Orientation constituée d'une seule lettre N; E; W et S");

	private JTextField jtfX = new JTextField("abscisse initiale");

	private JTextField jtfY = new JTextField("ordonnée initiale");

	private JTextField jtfXCoinDroit = new JTextField("abscisse");

	private JTextField jtfYCoinDroit = new JTextField("ordonnée");

	private URL url = FormulaireVehicules.class.getResource("/boutonConfirmerNbreVehicules.png");

	private ImageIcon imageBoutonConfirmer = new ImageIcon(url);

	private JButton boutonConfirmer = new JButton(imageBoutonConfirmer);

	private int nbreDeVehicules;

	private int numeroFormulaire;

	private Font policeCalibriLight = new Font("Calibri Light", Font.BOLD, 30);

	private Font policeCalibri = new Font("Calibri", Font.BOLD, 30);

	private Font policeAgencyFB = new Font("Agency FB", Font.BOLD, 30);

	private Border whiteBorder = new LineBorder(Color.WHITE, 3);

	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	private JLabel positionInitialeDuVehicule = new JLabel("Position Du Véhicule");

	private JLabel coinSuperieurDroit = new JLabel("Coin Supérieur Droit");

	private boolean validationPositions;

	private boolean validationOrientation;

	private boolean validationInstructions;

	static ArrayList<AutonomousCar> listeVehicules = new ArrayList<AutonomousCar>(); // Vider
	// après
	// l'animation

	static int compteur = 1; // Remettre la valeur initiale après l'animation

	public FormulaireVehicules(int numeroFormulaire, int nbreDeVehicules) {

		this.nbreDeVehicules = nbreDeVehicules;

		this.numeroFormulaire = numeroFormulaire;

		if (this.nbreDeVehicules == 1) {
			this.setTitle("4HWC AUTONOMOUS CAR : caractéristiques du véhicule");

		} else // this.nbreDeTondeuses >1
		{
			this.setTitle("4HWC AUTONOMOUS CAR : caractéristiques des " + this.nbreDeVehicules + " véhicules");
		}

		this.setIconImage(Bienvenue4HWC.icon4HWC.getImage());

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

		//////////////////////////////////////////////////////////////////

		container.add(formulaire(this.numeroFormulaire, this.nbreDeVehicules));

		this.setContentPane(container);

		this.setVisible(true);

		/////////////////////////////////////////////////////////////////

	}

	private JPanel formulaire(int numero, int nbreVehicules) {
		// Découpage de content en 9 cellules , 4 lignes et 3 colonnes :
		// GridBagLayout

		// Conteneur principal (au dessus de l'image de fond)

		// Création des 12 cellules

		JPanel cell1_1 = new JPanel();
		cell1_1.setPreferredSize(new Dimension(330, 50));
		cell1_1.setOpaque(false);

		JPanel cell1_2 = new JPanel();
		cell1_2.setPreferredSize(new Dimension(330, 50));
		cell1_2.setOpaque(false);

		JPanel cell1_3 = new JPanel();
		cell1_3.setPreferredSize(new Dimension(330, 50));
		cell1_3.setOpaque(false);

		JPanel cell1 = new JPanel();
		cell1.setPreferredSize(new Dimension(330, 150));
		cell1.setOpaque(false);

		cell1.setLayout(new GridBagLayout());

		// Objet servant à positionner les composants

		GridBagConstraints gbc1 = new GridBagConstraints();

		gbc1.gridx = 0;

		gbc1.gridy = 0;

		gbc1.gridheight = 1;

		gbc1.gridwidth = 1;

		cell1.add(cell1_1, gbc1);

		gbc1.gridy = 1;

		cell1.add(cell1_2, gbc1);

		gbc1.gridy = 2;

		cell1.add(cell1_3, gbc1);

		// X CD

		jtfXCoinDroit.setPreferredSize(new Dimension(330, 40));

		jtfXCoinDroit.setFocusable(true);

		jtfXCoinDroit.setFont(policeCalibriLight);

		jtfXCoinDroit.setForeground(Color.WHITE);

		jtfXCoinDroit.setBorder(whiteBorder);

		jtfXCoinDroit.setOpaque(false);

		cell1_2.setLayout(new FlowLayout());

		cell1_2.add(jtfXCoinDroit);

		JPanel cell2_1 = new JPanel();
		cell2_1.setPreferredSize(new Dimension(330, 50));
		cell2_1.setOpaque(false);

		JPanel cell2_2 = new JPanel();
		cell2_2.setPreferredSize(new Dimension(330, 50));
		cell2_2.setOpaque(false);

		JPanel cell2_3 = new JPanel();
		cell2_3.setPreferredSize(new Dimension(330, 50));
		cell2_3.setOpaque(false);

		JPanel cell2 = new JPanel();
		cell2.setPreferredSize(new Dimension(330, 150));
		// cell2.setBackground(Color.WHITE);

		cell2.setOpaque(false);

		cell2.setLayout(new GridBagLayout());

		// Objet servant à positionner les composants

		GridBagConstraints gbc2 = new GridBagConstraints();

		gbc2.gridx = 0;

		gbc2.gridy = 0;

		gbc2.gridheight = 1;

		gbc2.gridwidth = 1;

		cell2.add(cell2_1, gbc2);

		gbc2.gridy = 1;

		cell2.add(cell2_2, gbc2);

		gbc2.gridy = 2;

		cell2.add(cell2_3, gbc2);

		cell2_1.setLayout(new FlowLayout());

		// Titre formulaire

		JLabel suiviFormulaire;

		if (nbreVehicules == 1) {
			suiviFormulaire = new JLabel("Véhicule unique");

		} else {

			suiviFormulaire = new JLabel("Véhicule N° " + numero + " sur " + nbreVehicules);
		}

		suiviFormulaire.setFont(policeAgencyFB);

		suiviFormulaire.setForeground(Color.WHITE);

		cell2_1.add(suiviFormulaire);

		// CD

		cell2_2.setLayout(new FlowLayout());

		coinSuperieurDroit.setFont(policeAgencyFB);

		coinSuperieurDroit.setForeground(Color.WHITE);

		cell2_2.add(coinSuperieurDroit);

		JPanel cell3_1 = new JPanel();
		cell3_1.setPreferredSize(new Dimension(330, 50));
		cell3_1.setOpaque(false);

		JPanel cell3_2 = new JPanel();
		cell3_2.setPreferredSize(new Dimension(330, 50));
		cell3_2.setOpaque(false);

		JPanel cell3_3 = new JPanel();
		cell3_3.setPreferredSize(new Dimension(330, 50));
		cell3_3.setOpaque(false);

		JPanel cell3 = new JPanel();
		cell3.setPreferredSize(new Dimension(330, 150));
		cell3.setOpaque(false);

		cell3.setLayout(new GridBagLayout());

		// Objet servant à positionner les composants

		GridBagConstraints gbc3 = new GridBagConstraints();

		gbc3.gridx = 0;

		gbc3.gridy = 0;

		gbc3.gridheight = 1;

		gbc3.gridwidth = 1;

		cell3.add(cell3_1, gbc3);

		gbc3.gridy = 1;

		cell3.add(cell3_2, gbc3);

		gbc3.gridy = 2;

		cell3.add(cell3_3, gbc3);

		// Y CD

		jtfYCoinDroit.setPreferredSize(new Dimension(330, 40));

		// jtfInstructions.setFocusable(true);

		jtfYCoinDroit.setFont(policeCalibriLight);

		jtfYCoinDroit.setForeground(Color.WHITE);

		jtfYCoinDroit.setBorder(whiteBorder);

		jtfYCoinDroit.setOpaque(false);

		cell3_2.setLayout(new FlowLayout());

		cell3_2.add(jtfYCoinDroit);

		JPanel cell4_1 = new JPanel();
		cell4_1.setPreferredSize(new Dimension(330, 50));
		cell4_1.setOpaque(false);

		JPanel cell4_2 = new JPanel();
		cell4_2.setPreferredSize(new Dimension(330, 50));
		cell4_2.setOpaque(false);

		JPanel cell4_3 = new JPanel();
		cell4_3.setPreferredSize(new Dimension(330, 50));
		cell4_3.setOpaque(false);

		JPanel cell4 = new JPanel();
		cell4.setPreferredSize(new Dimension(330, 150));
		cell4.setOpaque(false);

		cell4.setLayout(new GridBagLayout());

		// Objet servant à positionner les composants

		GridBagConstraints gbc4 = new GridBagConstraints();

		gbc4.gridx = 0;

		gbc4.gridy = 0;

		gbc4.gridheight = 1;

		gbc4.gridwidth = 1;

		cell4.add(cell4_1, gbc4);

		gbc4.gridy = 1;

		cell4.add(cell4_2, gbc4);

		gbc4.gridy = 2;

		cell4.add(cell4_3, gbc4);

		// X VEHICULE

		jtfX.setPreferredSize(new Dimension(330, 40));

		// jtfInstructions.setFocusable(true);

		jtfX.setFont(policeCalibriLight);

		jtfX.setForeground(Color.WHITE);

		jtfX.setBorder(whiteBorder);

		jtfX.setOpaque(false);

		cell4_2.setLayout(new FlowLayout());

		cell4_2.add(jtfX);

		JPanel cell5 = new JPanel();
		cell5.setPreferredSize(new Dimension(330, 150));

		cell5.setOpaque(false);

		cell5.setLayout(new FlowLayout());

		// Position Initiale V2HICULE

		// JLabel suiviFormulaire = new JLabel("Tondeuse N° i sur 4");

		positionInitialeDuVehicule.setFont(policeAgencyFB);

		positionInitialeDuVehicule.setForeground(Color.WHITE);

		cell5.add(positionInitialeDuVehicule);

		JPanel cell6_1 = new JPanel();
		cell6_1.setPreferredSize(new Dimension(330, 50));
		cell6_1.setOpaque(false);

		JPanel cell6_2 = new JPanel();
		cell6_2.setPreferredSize(new Dimension(330, 50));
		cell6_2.setOpaque(false);

		JPanel cell6_3 = new JPanel();
		cell6_3.setPreferredSize(new Dimension(330, 50));
		cell6_3.setOpaque(false);

		JPanel cell6 = new JPanel();
		cell6.setPreferredSize(new Dimension(330, 150));
		cell6.setOpaque(false);

		cell6.setLayout(new GridBagLayout());

		// Objet servant à positionner les composants

		GridBagConstraints gbc6 = new GridBagConstraints();

		gbc6.gridx = 0;

		gbc6.gridy = 0;

		gbc6.gridheight = 1;

		gbc6.gridwidth = 1;

		cell6.add(cell6_1, gbc6);

		gbc6.gridy = 1;

		cell6.add(cell6_2, gbc6);

		gbc6.gridy = 2;

		cell6.add(cell6_3, gbc6);

		// Y VEHICULE

		jtfY.setPreferredSize(new Dimension(330, 40));

		// jtfInstructions.setFocusable(true);

		jtfY.setFont(policeCalibriLight);

		jtfY.setForeground(Color.WHITE);

		jtfY.setBorder(whiteBorder);

		jtfY.setOpaque(false);

		cell6_2.setLayout(new FlowLayout());

		cell6_2.add(jtfY);

		JPanel cell7_1 = new JPanel();
		cell7_1.setPreferredSize(new Dimension(990, 50));
		cell7_1.setOpaque(false);

		JPanel cell7_2 = new JPanel();
		cell7_2.setPreferredSize(new Dimension(990, 50));
		cell7_2.setOpaque(false);

		JPanel cell7_3 = new JPanel();
		cell7_3.setPreferredSize(new Dimension(990, 50));
		cell7_3.setOpaque(false);

		JPanel cell7 = new JPanel();
		cell7.setPreferredSize(new Dimension(990, 150));
		cell7.setOpaque(false);

		cell7.setLayout(new GridBagLayout());

		// Objet servant à positionner les composants

		GridBagConstraints gbc7 = new GridBagConstraints();

		gbc7.gridx = 0;
		gbc7.gridy = 0;

		gbc7.gridheight = 1;

		gbc7.fill = GridBagConstraints.HORIZONTAL;

		gbc7.gridwidth = GridBagConstraints.REMAINDER;
		cell7.add(cell7_1, gbc7);

		gbc7.gridy = 1;

		gbc7.gridheight = 1;

		gbc7.fill = GridBagConstraints.HORIZONTAL;

		gbc7.gridwidth = GridBagConstraints.REMAINDER;
		cell7.add(cell7_2, gbc7);

		gbc7.gridy = 2;

		gbc7.gridheight = 1;

		gbc7.fill = GridBagConstraints.HORIZONTAL;

		gbc7.gridwidth = GridBagConstraints.REMAINDER;
		cell7.add(cell7_3, gbc7);

		// ORIENTATION

		jtfOrientation.setPreferredSize(new Dimension(990, 40));

		// jtfInstructions.setFocusable(true);

		jtfOrientation.setFont(policeCalibriLight);

		jtfOrientation.setForeground(Color.WHITE);

		jtfOrientation.setBorder(whiteBorder);

		jtfOrientation.setOpaque(false);

		cell7_1.setLayout(new FlowLayout());

		cell7_1.add(jtfOrientation);

		// INSTRUCTIONS

		jtfInstructions.setPreferredSize(new Dimension(990, 40));

		// jtfInstructions.setFocusable(true);

		jtfInstructions.setFont(policeCalibriLight);

		jtfInstructions.setForeground(Color.WHITE);

		jtfInstructions.setBorder(whiteBorder);

		jtfInstructions.setOpaque(false);

		cell7_3.setLayout(new FlowLayout());

		cell7_3.add(jtfInstructions);

		JPanel cell8 = new JPanel();
		cell8.setPreferredSize(new Dimension(330, 150));

		cell8.setOpaque(false);

		JPanel cell9_1 = new JPanel();
		cell9_1.setPreferredSize(new Dimension(330, 50));
		cell9_1.setOpaque(false);

		JPanel cell9_2 = new JPanel();
		cell9_2.setPreferredSize(new Dimension(330, 50));
		cell9_2.setOpaque(false);

		JPanel cell9_3 = new JPanel();
		cell9_3.setPreferredSize(new Dimension(330, 50));
		cell9_3.setOpaque(false);

		JPanel cell9 = new JPanel();
		cell9.setPreferredSize(new Dimension(330, 150));
		cell9.setOpaque(false);

		cell9.setLayout(new GridBagLayout());

		// Objet servant à positionner les composants

		GridBagConstraints gbc9 = new GridBagConstraints();

		gbc9.gridx = 0;
		gbc9.gridy = 0;

		gbc9.gridheight = 1;
		gbc9.gridwidth = 1;

		cell9.add(cell9_1, gbc9);

		gbc9.gridy = 1;
		cell9.add(cell9_2, gbc9);

		gbc9.gridy = 2;
		cell9.add(cell9_3, gbc9);

		cell9_2.setLayout(new FlowLayout());

		// CONFIRMER

		boutonConfirmer.setPreferredSize(new Dimension(220, 50));

		boutonConfirmer.setCursor(cursor);

		boutonConfirmer.setBorderPainted(true);

		boutonConfirmer.addActionListener(this);

		cell9_2.add(boutonConfirmer);

		JPanel cell10 = new JPanel();
		cell10.setPreferredSize(new Dimension(330, 150));

		cell10.setOpaque(false);

		JPanel content = new JPanel();

		content.setPreferredSize(new Dimension(990, 600));

		content.setOpaque(false);

		content.setLayout(new GridBagLayout());

		// Objet servant à positionner les composants

		GridBagConstraints gbc = new GridBagConstraints();

		// Position de la case de départ du composant

		gbc.gridx = 0;
		gbc.gridy = 0;

		// Taille en hauteur et largeur

		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		content.add(cell1, gbc);

		gbc.gridx = 1;
		content.add(cell2, gbc);

		// Fin de ligne

		gbc.gridwidth = GridBagConstraints.REMAINDER;

		gbc.gridx = 2;
		content.add(cell3, gbc);

		// -----------------------

		// ligne suivante 2e ligne

		gbc.gridx = 0;
		gbc.gridy = 1;

		// Taille en hauteur et largeur

		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		content.add(cell4, gbc);

		gbc.gridx = 1;
		content.add(cell5, gbc);

		// Fin de ligne

		gbc.gridwidth = GridBagConstraints.REMAINDER;

		gbc.gridx = 2;
		content.add(cell6, gbc);

		// -----------------------

		// ligne suivante 3e ligne

		gbc.gridx = 0;
		gbc.gridy = 2;

		gbc.gridheight = 1;

		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridwidth = GridBagConstraints.REMAINDER;
		content.add(cell7, gbc);

		// -----------------------

		// ligne suivante 4e ligne

		gbc.gridx = 0;
		gbc.gridy = 3;

		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		content.add(cell8, gbc);

		gbc.gridx = 1;
		content.add(cell9, gbc);

		// Fin de ligne

		gbc.gridwidth = GridBagConstraints.REMAINDER;

		gbc.gridx = 2;
		content.add(cell10, gbc);

		// -----------------------

		// FIN

		return content;
	}

	public void actionPerformed(ActionEvent arg0)

	{
		if (arg0.getSource() == boutonConfirmer)

		{
			validationPositions = AutonomousCar.validationPositionsString(jtfXCoinDroit.getText(),
					jtfYCoinDroit.getText(), jtfX.getText(), jtfY.getText());

			validationOrientation = AutonomousCar.validationOrientationInitiale(jtfOrientation.getText().toUpperCase());

			validationInstructions = AutonomousCar.validationInstructions(jtfInstructions.getText().toUpperCase());

			if (validationPositions == true)

			{

				if (validationOrientation == true) {

					if (validationInstructions == true) {

						// Tout est correct

						FormulaireVehicules.listeVehicules.add(new AutonomousCar(
								Integer.parseInt(jtfXCoinDroit.getText().trim()),
								Integer.parseInt(jtfYCoinDroit.getText().trim()),
								Integer.parseInt(jtfX.getText().trim()), Integer.parseInt(jtfY.getText().trim()),
								jtfOrientation.getText().toUpperCase().trim(),
								jtfInstructions.getText().toUpperCase().trim()));

						if (FormulaireVehicules.compteur == this.nbreDeVehicules) {
							// Tous les formulaires sont remplis correctement

							JOptionPane jopSucces = new JOptionPane();

							String titleSucces = "Succès";

							String messageSucces = "Bravo vous avez saisi avec succès les caractéristiques du véhicule :) !";

							if (this.nbreDeVehicules == 1) {

							} else {

								messageSucces = "Bravo vous avez saisi avec succès les caractéristiques des "
										+ this.nbreDeVehicules + " véhicules :) !";

							}

							jopSucces.showMessageDialog(null, messageSucces, titleSucces,
									JOptionPane.INFORMATION_MESSAGE);

							// Changement de fenêtres

							this.setVisible(false);

							ChargementDeplacementVehicules.listeVehicules = FormulaireVehicules.listeVehicules;

							ChargementDeplacementVehicules.origine = "paramètres";

							new ChargementDeplacementVehicules();

						} else {

							// FormulaireVehicules.compteur <
							// this.nbreDeVehicules

							FormulaireVehicules.compteur++;

							this.setVisible(false);

							new FormulaireVehicules(FormulaireVehicules.compteur, this.nbreDeVehicules);

						}

					} else {

						// erreur au niveau des instructions

						JOptionPane jopInstructions = new JOptionPane();

						String messageInstructions = "S'il vous plaît, il faut vérifier les instructions.";

						String titleInstructions = "Instructions erronées";

						jopInstructions.showMessageDialog(null, messageInstructions, titleInstructions,
								JOptionPane.ERROR_MESSAGE);

					}

				} else {

					// erreur au niveau de l'orientation

					JOptionPane jopOrientation = new JOptionPane();

					String messageOrientation = "S'il vous plaît, il faut vérifier l'orientation.";

					String titleOrientation = "Orientation erronée";

					jopOrientation.showMessageDialog(null, messageOrientation, titleOrientation,
							JOptionPane.ERROR_MESSAGE);

				}

			} else {

				// Au moins une erreur au niveau des positions

				JOptionPane jopPositions = new JOptionPane();

				// jopPositions.setPreferredSize(new Dimension(500, 300));

				// jopPositions.setFont(policeCalibriLight);

				// jopPositions.setBackground(Color.decode("#148da0"));

				// jopPositions.setForeground(Color.WHITE);

				String messagePositions = "S'il vous plaît, il faut vérifier les positions";

				String titlePositions = "Erreur au niveau des positions";

				jopPositions.showMessageDialog(null, messagePositions, titlePositions, JOptionPane.ERROR_MESSAGE);
			}
		} // if arg0
	}// actionPerformed

}
