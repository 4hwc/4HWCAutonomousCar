package com.autonomouscar.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Bienvenue4HWC extends JFrame {

	static URL url = Bienvenue4HWC.class.getResource("/images/4HWCN.png");

	static ImageIcon icon4HWC = new ImageIcon(url);

	private Thread t;

	private JProgressBar bar;

	private Panneau4HWC container = new Panneau4HWC();

	public Bienvenue4HWC() {
		this.setTitle("4HWC AUTONOMOUS CAR");

		this.setSize(1000, 600);

		this.setLocationRelativeTo(null);

		this.setIconImage(Bienvenue4HWC.icon4HWC.getImage());

		this.setResizable(false);

		this.setUndecorated(true);

		container.setLayout(new BorderLayout());

		class Traitement implements Runnable {

			public void run() {

				for (int val = 0; val <= 500; val++) {
					bar.setValue(val);

					try {
						Thread.sleep(25);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} // for
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

	public static void voixBienvenue4HWC() {

		// Speech will be improved later
		// Speech.repete("Salut je suis l'intelligence artificielle 4 H W C du prototype
		// voiture autonome !");
	}

}
