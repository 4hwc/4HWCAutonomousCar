package com.autonomouscar.model;

public class AutonomousCar {

	// Coins droits

	private int xCoinDroit;

	private int yCoinDroit;

	// Positions initiales

	private int xInitiale;

	private int yInitiale;

	private String orientationInitiale;

	private String instructions;

	// Positions actuelles

	private int xActuelle;

	private int yActuelle;

	private String orientationActuelle;

	// Positions finales à atteindre

	private int xFinale;

	private int yFinale;

	private String orientationFinale;

	// Chrono du temps mis pour parcourir la surface par la voiture en millisecondes

	private long chronoFinale;

	public AutonomousCar(int xCoinDroit, int yCoinDroit, int xInitiale, int yInitiale, String orientationInitiale,
			String instructions) {

		this.xCoinDroit = xCoinDroit;

		this.yCoinDroit = yCoinDroit;

		this.xInitiale = xInitiale;

		this.yInitiale = yInitiale;

		this.orientationInitiale = orientationInitiale;

		this.instructions = instructions;

		// Au départ la position et l'orientation actuelles sont identiques aux
		// données initiales

		this.xActuelle = this.xInitiale;

		this.yActuelle = this.yInitiale;

		this.orientationActuelle = this.orientationInitiale;

	}

	// Setter et getter Coin droit

	public void setXCoinDroit(int xCoinDroit) {
		this.xCoinDroit = xCoinDroit;
	}

	public int getXCoinDroit() {
		return xCoinDroit;
	}

	public void setYCoinDroit(int yCoinDroit) {
		this.yCoinDroit = yCoinDroit;
	}

	public int getYCoinDroit() {
		return yCoinDroit;
	}

	// Setters et getters initiaux

	public void setXInitiale(int xInitiale) {
		this.xInitiale = xInitiale;
	}

	public int getXInitiale() {
		return xInitiale;
	}

	public void setYInitiale(int yInitiale) {
		this.yInitiale = yInitiale;
	}

	public int getYInitiale() {
		return yInitiale;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setOrientationInitiale(String orientationInitiale) {
		this.orientationInitiale = orientationInitiale;
	}

	public String getOrientationInitiale() {
		return orientationInitiale;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getInstructions() {
		return instructions;
	}

	// Setters et getters actuels

	public void setXActuelle(int xActuelle) {
		this.xActuelle = xActuelle;
	}

	public int getXActuelle() {
		return xActuelle;
	}

	public void setYActuelle(int yActuelle) {
		this.yActuelle = yActuelle;
	}

	public int getYActuelle() {
		return yActuelle;
	}

	public void setOrientationActuelle(String orientationActuelle) {
		this.orientationActuelle = orientationActuelle;
	}

	public String getOrientationActuelle() {
		return orientationActuelle;
	}

	// Setters et getters finaux

	public void setXFinale(int xFinale) {
		this.xFinale = xFinale;
	}

	public int getXFinale() {
		return xFinale;
	}

	public void setYFinale(int yFinale) {
		this.yFinale = yFinale;
	}

	public int getYFinale() {
		return yFinale;
	}

	public void setOrientationFinale(String orientationFinale) {
		this.orientationFinale = orientationFinale;
	}

	public String getOrientationFinale() {
		return orientationFinale;
	}

	// Setter et getter du Chrono du temps mis pour parcourir par la
	// voiture

	public void setChronoFinale(long chronoFinale) {
		this.chronoFinale = chronoFinale;
	}

	public long getChronoFinale() {
		return chronoFinale;
	}

}
