package com.autonomouscar.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import com.autonomouscar.model.AutonomousCar;

public class ChargementDeplacementVehicules extends JFrame {

	private Thread t;

	private Thread tSpeak;

	private Thread pause;

	private JProgressBar bar;

	private ChargementDeplacementVehiculesPanneau4HWC container = new ChargementDeplacementVehiculesPanneau4HWC();

	static String origine = "";

	static ArrayList<AutonomousCar> listeVehicules = new ArrayList<AutonomousCar>();

	private String speak;

	public ChargementDeplacementVehicules()

	{

		this.setTitle("4HWC AUTONOMOUS CAR : Chargement...");

		this.setSize(1000, 600);

		this.setIconImage(Bienvenue4HWC.icon4HWC.getImage());

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

		container.setLayout(new BorderLayout());

		class TraitementRedirection implements Runnable {

			public void run() {

				redirection();

			}

		}

		pause = new Thread(new TraitementRedirection());

		class TraitementSpeak implements Runnable {

			public void run() {

				if (ChargementDeplacementVehicules.origine.equals("défaut")) {

					if (ChargementDeplacementVehicules.listeVehicules.size() == 1) {

						speak = "un véhicule déployé par défaut";

					} else {

						speak = ChargementDeplacementVehicules.listeVehicules.size() + " véhicules déployés par défaut";

					}

				}
				if (ChargementDeplacementVehicules.origine.equals("paramètres")) {

					if (ChargementDeplacementVehicules.listeVehicules.size() == 1) {

						speak = "un véhicule déployé par vous";

					} else {

						speak = ChargementDeplacementVehicules.listeVehicules.size() + " véhicules déployées par vous";

					}

				}

				if (ChargementDeplacementVehicules.origine.equals("IA")) {

					if (ChargementDeplacementVehicules.listeVehicules.size() == 1) {

						speak = "un véhicule déployé par moi";

					} else {

						speak = ChargementDeplacementVehicules.listeVehicules.size() + " véhicules déployées par moi";

					}

				}

				// Speech will be improved later

				// Speech.repete(speak);

			}// run

		}

		tSpeak = new Thread(new TraitementSpeak());

		class Traitement implements Runnable {

			public void run() {

				// tSpeak.setPriority(Thread.MAX_PRIORITY);

				tSpeak.start();

				for (int val = 0; val <= 500; val++) {

					bar.setValue(val);

					try {
						Thread.sleep(25);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} // for

				pause.start();

			}// run

		}// traitement

		t = new Thread(new Traitement());

		bar = new JProgressBar();

		bar.setMaximum(500);

		bar.setMinimum(0);

		bar.setStringPainted(false);

		bar.setForeground(Color.decode("#148da0"));

		container.add(bar, BorderLayout.SOUTH);

		t.start();

		this.setContentPane(container);

		this.setVisible(true);

	}

	private void redirection() {

		this.dispose();

		new DeplacementVehicules();

	}

}
