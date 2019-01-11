package com.autonomouscar.controller;

public class Chronometre {

	static long chrono = 0;

	static long temps;

	// Lancement du chrono
	public static void goChrono() {
		// chrono = java.lang.System.currentTimeMillis();

		chrono = java.lang.System.nanoTime();

	}

	// Arrêt du chrono
	public static void stopChrono() {
		long chrono2 = java.lang.System.nanoTime();

		// System.out.println("chrono2 : " + chrono2);
		temps = chrono2 - chrono;

		// System.out.println("Temps ecoule = " + temps + " ms");
	}

	// Temps mis pour parcourir la pelouse en ms

	public static long getChrono() {
		return temps;
	}

}
