package com.autonomouscar.utils;

import t2s.son.LecteurTexte;

public class Speech {

	public static void repete(String texte) {
		LecteurTexte lecteur = new LecteurTexte();
		lecteur.setTexte(texte);
		lecteur.play();
	}

}
