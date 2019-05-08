package com.autonomouscar.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.autonomouscar.service.AutonomousCarService;

public class Menu4HWC extends JFrame implements ActionListener {

	private MenuPanneau4HWC container = new MenuPanneau4HWC();

	// Ajout des 3 boutons du menu

	private JButton boutonParDefaut = new JButton("Par défaut");

	private JButton boutonParametres = new JButton("Paramètres");

	private JButton boutonIA4HWC = new JButton("Intelligence artificielle 4HWC");

	public Menu4HWC() {
		this.setTitle("4HWC AUTONOMOUS CAR : MENU");

		this.setSize(1000, 600);

		this.setLocationRelativeTo(null);

		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.setIconImage(Bienvenue4HWC.icon4HWC.getImage());

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

		Font police = new Font("Agency FB", Font.BOLD, 30);

		Font policeCalibri = new Font("Calibri", Font.BOLD, 25);

		Border whiteBorder = new LineBorder(Color.WHITE, 6);

		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

		boutonParDefaut.setCursor(cursor);

		boutonParDefaut.setFont(policeCalibri);

		boutonParDefaut.setBorder(whiteBorder);

		boutonParDefaut.setForeground(Color.WHITE);

		boutonParDefaut.setContentAreaFilled(false);
		boutonParDefaut.setBorderPainted(true);

		boutonParDefaut.addActionListener(this);

		boutonParametres.setCursor(cursor);

		boutonParametres.setFont(policeCalibri);

		boutonParametres.setBorder(whiteBorder);

		boutonParametres.setForeground(Color.WHITE);

		boutonParametres.setContentAreaFilled(false);
		boutonParametres.setBorderPainted(true);

		boutonParametres.addActionListener(this);

		boutonIA4HWC.setCursor(cursor);

		boutonIA4HWC.setFont(policeCalibri);

		boutonIA4HWC.setBorder(whiteBorder);

		boutonIA4HWC.setForeground(Color.WHITE);

		boutonIA4HWC.setContentAreaFilled(false);
		boutonIA4HWC.setBorderPainted(true);

		boutonIA4HWC.addActionListener(this);

		// Découpage de content en 9 cellules , 3 lignes et 3 colonnes :
		// GridBagLayout

		// Conteneur principal (au dessus de l'image de fond)

		// Création des 9 cellules

		JPanel cell1 = new JPanel();
		cell1.setPreferredSize(new Dimension(330, 200));

		cell1.setOpaque(false); // Transparent

		JPanel cell2_1 = new JPanel();
		cell2_1.setPreferredSize(new Dimension(330, 66));
		cell2_1.setOpaque(false);

		JPanel cell2_2 = new JPanel();
		cell2_2.setPreferredSize(new Dimension(330, 66));
		cell2_2.setOpaque(false);

		cell2_2.setLayout(new BorderLayout());

		cell2_2.add(boutonParDefaut, BorderLayout.CENTER);

		JPanel cell2_3 = new JPanel();
		cell2_3.setPreferredSize(new Dimension(330, 66));
		cell2_3.setOpaque(false);

		JPanel cell2 = new JPanel();
		cell2.setPreferredSize(new Dimension(330, 200));
		cell2.setOpaque(false);

		cell2.setLayout(new GridBagLayout());

		// Objet servant à positionner les composants

		GridBagConstraints gbc2 = new GridBagConstraints();

		gbc2.gridx = 0;
		gbc2.gridy = 0;

		// Taille en hauteur et largeur

		gbc2.gridheight = 1;
		gbc2.gridwidth = 1;
		cell2.add(cell2_1, gbc2);

		gbc2.gridy = 1;
		cell2.add(cell2_2, gbc2);

		gbc2.gridy = 2;
		cell2.add(cell2_3, gbc2);

		JPanel cell3 = new JPanel();
		cell3.setPreferredSize(new Dimension(330, 200));
		cell3.setOpaque(false);

		JPanel cell4 = new JPanel();
		cell4.setPreferredSize(new Dimension(330, 200));
		cell4.setOpaque(false);

		JPanel cell5_1 = new JPanel();
		cell5_1.setPreferredSize(new Dimension(330, 66));
		cell5_1.setOpaque(false);

		JPanel cell5_2 = new JPanel();
		cell5_2.setPreferredSize(new Dimension(330, 66));
		cell5_2.setOpaque(false);

		cell5_2.setLayout(new BorderLayout());

		cell5_2.add(boutonParametres, BorderLayout.CENTER);

		JPanel cell5_3 = new JPanel();
		cell5_3.setPreferredSize(new Dimension(330, 66));
		cell5_3.setOpaque(false);

		JPanel cell5 = new JPanel();
		cell5.setPreferredSize(new Dimension(330, 200));
		cell5.setOpaque(false);

		cell5.setLayout(new GridBagLayout());

		// Objet servant à positionner les composants

		GridBagConstraints gbc5 = new GridBagConstraints();

		gbc5.gridx = 0;
		gbc5.gridy = 0;

		// Taille en hauteur et largeur

		gbc5.gridheight = 1;
		gbc5.gridwidth = 1;
		cell5.add(cell5_1, gbc5);

		gbc5.gridy = 1;
		cell5.add(cell5_2, gbc5);

		gbc5.gridy = 2;
		cell5.add(cell5_3, gbc5);

		JPanel cell6 = new JPanel();
		cell6.setPreferredSize(new Dimension(330, 200));
		cell6.setOpaque(false);

		JPanel cell7 = new JPanel();
		cell7.setPreferredSize(new Dimension(330, 200));
		cell7.setOpaque(false);

		JPanel cell8_1 = new JPanel();
		cell8_1.setPreferredSize(new Dimension(330, 66));
		cell8_1.setOpaque(false);

		JPanel cell8_2 = new JPanel();
		cell8_2.setPreferredSize(new Dimension(330, 66));
		cell8_2.setOpaque(false);

		cell8_2.setLayout(new BorderLayout());

		cell8_2.add(boutonIA4HWC, BorderLayout.CENTER);

		JPanel cell8_3 = new JPanel();
		cell8_3.setPreferredSize(new Dimension(330, 66));
		cell8_3.setOpaque(false);

		JPanel cell8 = new JPanel();
		cell8.setPreferredSize(new Dimension(330, 200));
		cell8.setOpaque(false);

		cell8.setLayout(new GridBagLayout());

		// Objet servant à positionner les composants

		GridBagConstraints gbc8 = new GridBagConstraints();

		gbc8.gridx = 0;
		gbc8.gridy = 0;

		// Taille en hauteur et largeur

		gbc8.gridheight = 1;
		gbc8.gridwidth = 1;
		cell8.add(cell8_1, gbc8);

		gbc8.gridy = 1;
		cell8.add(cell8_2, gbc8);

		gbc8.gridy = 2;
		cell8.add(cell8_3, gbc8);

		JPanel cell9 = new JPanel();
		cell9.setPreferredSize(new Dimension(330, 200));
		cell9.setOpaque(false);

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
		gbc.gridwidth = 1;

		content.add(cell7, gbc);

		gbc.gridx = 1;
		content.add(cell8, gbc);

		// Fin de ligne

		gbc.gridwidth = GridBagConstraints.REMAINDER;

		gbc.gridx = 2;
		content.add(cell9, gbc);

		container.add(content);

		this.setContentPane(container);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == boutonParDefaut) {

			// Changement de fenêtre

			this.setVisible(false);

			ChargementDeplacementVehicules.listeVehicules = AutonomousCarService.recupFichierBase();

			ChargementDeplacementVehicules.origine = "défaut";

			new ChargementDeplacementVehicules();

		}

		if (arg0.getSource() == boutonParametres) {

			this.setVisible(false);

			new ChoixDuNombreDeVehicules();

		}

		if (arg0.getSource() == boutonIA4HWC) {

			// Changement de fenêtre

			this.setVisible(false);

			ChargementDeplacementVehicules.listeVehicules = AutonomousCarService.getVehicules4HWC();

			ChargementDeplacementVehicules.origine = "IA";

			new ChargementDeplacementVehicules();

		}
	}

}
