package com.autonomouscar.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ChoixDuNombreDeTondeusesPanneauAxivIt extends JPanel {

	public void paintComponent(Graphics g) {

		try {

			URL url = ChoixDuNombreDeTondeusesPanneauAxivIt.class.getResource("/axivfenetre2.png");

			Image img = ImageIO.read(url);
			// g.drawImage(img, 0, 0, this);
			// Pour une image de fond
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
