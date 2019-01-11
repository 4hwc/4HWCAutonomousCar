package com.autonomouscar.controller;

import t2s.son.LecteurTexte;

public class SpeechAxiv {

	/*
	 * 
	 * Il suffit d'ajouter dans la déclaration de la méthode le mot clé
	 * synchronized, grâce auquel la méthode est inaccessible à un thread si
	 * elle est déjà utilisée par un autre thread. Ainsi, les threads cherchant
	 * à utiliser des méthodes déjà prises en charge par un autre thread sont
	 * placés dans une « liste d'attente ».
	 * 
	 */

	public static void repete(String texte) {
		LecteurTexte lecteur = new LecteurTexte();
		lecteur.setTexte(texte);
		lecteur.play();
	}

}
