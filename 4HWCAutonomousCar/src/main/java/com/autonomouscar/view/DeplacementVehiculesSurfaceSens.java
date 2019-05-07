package com.autonomouscar.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DeplacementVehiculesSurfaceSens extends JPanel {

	private String sens;

	public DeplacementVehiculesSurfaceSens(String sens) {
		this.sens = sens;
	}

	public void setSens(String sens) {

		this.sens = sens;

	}

	public String getSens() {

		return sens;

	}

	public void paintComponent(Graphics g) {

		try {

			Image img = null;

			URL urlN = DeplacementVehiculesSurfaceSens.class.getResource("/4HWCN.png");
			URL urlE = DeplacementVehiculesSurfaceSens.class.getResource("/4HWCE.png");
			URL urlW = DeplacementVehiculesSurfaceSens.class.getResource("/4HWCW.png");
			URL urlS = DeplacementVehiculesSurfaceSens.class.getResource("/4HWCS.png");

			if (this.sens.equals("N")) {
				img = ImageIO.read(urlN);
			}

			if (this.sens.equals("E")) {
				img = ImageIO.read(urlE);
			}

			if (this.sens.equals("W")) {
				img = ImageIO.read(urlW);
			}

			if (this.sens.equals("S")) {
				img = ImageIO.read(urlS);
			}

			// g.drawImage(img, 0, 0, this);
			// Pour une image de fond
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
