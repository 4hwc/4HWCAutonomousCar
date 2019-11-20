package com.autonomouscar.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FormulaireVehiculesPanneau4HWC extends JPanel {

	public void paintComponent(Graphics g) {

		try {
			URL url = FormulaireVehiculesPanneau4HWC.class.getResource("/images/4hwcfenetre2.png");

			Image img = ImageIO.read(url);
			// g.drawImage(img, 0, 0, this);
			// Pour une image de fond
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
