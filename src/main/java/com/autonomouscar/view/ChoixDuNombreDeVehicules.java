package com.autonomouscar.view;

import java.awt.BorderLayout;
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
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.autonomouscar.exceptions.AutonomousCarException;
import com.autonomouscar.service.AutonomousCarService;

public class ChoixDuNombreDeVehicules extends JFrame {

	private ChoixDuNombreDeVehiculesPanneau4HWC container = new ChoixDuNombreDeVehiculesPanneau4HWC();

	private URL url = ChoixDuNombreDeVehicules.class.getResource("/images/boutonConfirmerNbreVehicules.png");

	private ImageIcon imageBoutonConfirmer = new ImageIcon(url);

	private JButton boutonConfirmer = new JButton(imageBoutonConfirmer);

	private JTextField jtfNbre = new JTextField("Nombre de véhicules");

	private Font police = new Font("Agency FB", Font.BOLD, 30);

	// private Font policeArial = new Font("Arial", Font.BOLD, 30);

	private Font policeCalibriLight = new Font("Calibri Light", Font.BOLD, 30);

	// private Font policeCalibri = new Font("Calibri", Font.BOLD, 30);

	private Border whiteBorder = new LineBorder(Color.WHITE, 3);

	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	private Map<String, String> erreurs = new HashMap<>();

	private final String TITLEERROR = "Nombre de véhicules incorrect";

	public ChoixDuNombreDeVehicules() {
		this.setTitle("4HWC AUTONOMOUS CAR : Choix du nombre de véhicules");

		this.setSize(1000, 600);

		this.setLocationRelativeTo(null);

		this.setIconImage(Bienvenue4HWC.icon4HWC.getImage());

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

		jtfNbre.setPreferredSize(new Dimension(330, 200));

		jtfNbre.setFocusable(true);

		jtfNbre.setFont(policeCalibriLight);

		jtfNbre.setForeground(Color.WHITE);

		jtfNbre.setBorder(whiteBorder);

		jtfNbre.setOpaque(false);

		boutonConfirmer.setPreferredSize(new Dimension(220, 50));

		// boutonConfirmer.setBorder(whiteBorder);

		// boutonConfirmer.setIcon(imageBoutonConfirmer);

		boutonConfirmer.setFont(police);

		boutonConfirmer.setCursor(cursor);

		// boutonConfirmer.setForeground(Color.WHITE);

		// boutonConfirmer.setContentAreaFilled(false);
		boutonConfirmer.setBorderPainted(true);

		TextFieldHandler handler = new TextFieldHandler();

		boutonConfirmer.addActionListener(handler);

		// Découpage de content en 9 cellules , 3 lignes et 3 colonnes :
		// GridBagLayout

		// Conteneur principal (au dessus de l'image de fond)

		// Création des 9 cellules

		JPanel cell1 = new JPanel();
		cell1.setPreferredSize(new Dimension(330, 200));

		cell1.setOpaque(false);

		JPanel cell2 = new JPanel();
		cell2.setPreferredSize(new Dimension(330, 200));

		cell2.setOpaque(false);

		JPanel cell3 = new JPanel();
		cell3.setPreferredSize(new Dimension(330, 200));

		cell3.setOpaque(false);

		JPanel cell4 = new JPanel();
		cell4.setPreferredSize(new Dimension(330, 200));

		cell4.setOpaque(false);

		JPanel cell5_1 = new JPanel();
		cell5_1.setPreferredSize(new Dimension(330, 66));
		cell5_1.setOpaque(false);
		// cell5_1.setBackground(Color.BLACK);

		// JPanel text field

		JPanel cell5_2 = new JPanel();
		cell5_2.setPreferredSize(new Dimension(330, 66));
		cell5_2.setOpaque(false);
		// cell5_2.setBackground(Color.CYAN);

		cell5_2.setLayout(new BorderLayout());

		cell5_2.add(jtfNbre, BorderLayout.CENTER);

		JPanel cell5_3 = new JPanel();
		cell5_3.setPreferredSize(new Dimension(330, 66));
		cell5_3.setOpaque(false);
		// cell5_3.setBackground(Color.YELLOW);

		JPanel cell5 = new JPanel();
		cell5.setPreferredSize(new Dimension(330, 200));

		cell5.setOpaque(false);

		// cell5.setBackground(Color.ORANGE);

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

		// Confirmer

		JPanel cell8_1 = new JPanel();
		cell8_1.setPreferredSize(boutonConfirmer.getPreferredSize());
		// cell8_1.setPreferredSize(new Dimension(330, 66));
		cell8_1.setOpaque(false);
		// cell8_1.setBackground(Color.GREEN);

		// cell8_1.setBorder(whiteBorder);

		cell8_1.setLayout(new FlowLayout());
		cell8_1.add(boutonConfirmer);

		JPanel cell8_2 = new JPanel();
		cell8_2.setPreferredSize(new Dimension(330, 66));
		cell8_2.setOpaque(false);
		// cell8_2.setBackground(Color.LIGHT_GRAY);

		// cell5_2.setLayout(new BorderLayout());

		// cell5_2.add(boutonParametres, BorderLayout.CENTER);

		JPanel cell8_3 = new JPanel();
		cell8_3.setPreferredSize(new Dimension(330, 66));
		cell8_3.setOpaque(false);
		// cell8_3.setBackground(Color.WHITE);

		JPanel cell8 = new JPanel();
		cell8.setPreferredSize(new Dimension(330, 200));

		cell8.setOpaque(false);

		// cell8.setBackground(Color.PINK);

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

	private class TextFieldHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == boutonConfirmer) {
				try

				{

					new AutonomousCarService().validationNombreDeVehiculesString(jtfNbre.getText().trim());

					ChoixDuNombreDeVehicules.this.dispose();

					// Affichage 1er formulaire

					new FormulaireVehicules(1, Integer.parseInt(jtfNbre.getText().trim()));

				} catch (AutonomousCarException e) {

					// AutonomousCarLog.logger.error(e.getMessage());

					// Pb -> StringUtils blocks Swing GUI App

					erreurs.put(TITLEERROR, e.getMessage());

					JOptionPane.showMessageDialog(null, e.getMessage(), TITLEERROR, JOptionPane.ERROR_MESSAGE);

				}

			}

		}

	}

}
