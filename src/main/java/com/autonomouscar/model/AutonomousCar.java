package com.autonomouscar.model;

/**
 * <b>AutonomousCar represents an autonomous car<b/>
 * 
 * <p>
 * An autonomous car is defined by the following properties :
 * <ul>
 * <li>xCoinDroit @see {@link AutonomousCar#xCoinDroit}</li>
 * <li>yCoinDroit @see {@link AutonomousCar#yCoinDroit}</li>
 * <li>xInitiale @see {@link AutonomousCar#xInitiale}</li>
 * <li>yInitiale @see {@link AutonomousCar#yInitiale}</li>
 * <li>orientationInitiale @see {@link AutonomousCar#orientationInitiale}</li>
 * <li>instructions @see {@link AutonomousCar#instructions}</li>
 * <li>xActuelle @see {@link AutonomousCar#xActuelle}</li>
 * <li>yActuelle @see {@link AutonomousCar#yActuelle}</li>
 * <li>orientationActuelle @see {@link AutonomousCar#orientationActuelle}</li>
 * <li>xFinale @see {@link AutonomousCar#xFinale}</li>
 * <li>yFinale @see {@link AutonomousCar#yFinale}</li>
 * <li>orientationFinale @see {@link AutonomousCar#orientationFinale}</li>
 * <li>chronoFinale @see {@link AutonomousCar#chronoFinale}</li>
 * </ul>
 * </p>
 * 
 * @author Fanon Jupkwo
 * 
 * 
 */

public class AutonomousCar {

	// Coins droits

	/**
	 * 
	 * @see AutonomousCar#setXCoinDroit(int)
	 * @see AutonomousCar#getXCoinDroit()
	 */

	private int xCoinDroit;

	/**
	 * 
	 * @see AutonomousCar#setYCoinDroit(int)
	 * @see AutonomousCar#getYCoinDroit()
	 */

	private int yCoinDroit;

	// Positions initiales

	/**
	 * 
	 * @see AutonomousCar#setXInitiale(int)
	 * @see AutonomousCar#getXInitiale()
	 */

	private int xInitiale;

	/**
	 * 
	 * @see AutonomousCar#setYInitiale(int)
	 * @see AutonomousCar#getYInitiale()
	 */

	private int yInitiale;

	/**
	 * 
	 * @see AutonomousCar#setOrientationInitiale(String)
	 * @see AutonomousCar#getOrientationInitiale()
	 */

	private String orientationInitiale;

	/**
	 * 
	 * @see AutonomousCar#setInstructions(String)
	 * @see AutonomousCar#getInstructions()
	 */

	private String instructions;

	// Positions actuelles

	/**
	 * 
	 * @see AutonomousCar#setXActuelle(int)
	 * @see AutonomousCar#getXActuelle()
	 */

	private int xActuelle;

	/**
	 * 
	 * @see AutonomousCar#setYActuelle(int)
	 * @see AutonomousCar#getYActuelle()
	 */

	private int yActuelle;

	/**
	 * 
	 * @see AutonomousCar#setOrientationActuelle(String)
	 * @see AutonomousCar#getOrientationActuelle()
	 */

	private String orientationActuelle;

	// Positions finales à atteindre

	/**
	 * 
	 * @see AutonomousCar#setXFinale(int)
	 * @see AutonomousCar#getXFinale()
	 */

	private int xFinale;

	/**
	 * 
	 * @see AutonomousCar#setYFinale(int)
	 * @see AutonomousCar#getYFinale()
	 */

	private int yFinale;

	/**
	 * 
	 * @see AutonomousCar#setOrientationFinale(String)
	 * @see AutonomousCar#getOrientationFinale()
	 */

	private String orientationFinale;

	// Chrono du temps mis pour parcourir la surface par la voiture en millisecondes

	/**
	 * 
	 * @see AutonomousCar#setChronoFinale(long)
	 * @see AutonomousCar#getChronoFinale()
	 */

	private long chronoFinale;

	/**
	 * AutonomousCar constructor
	 * 
	 * @param xCoinDroit
	 * @param yCoinDroit
	 * @param xInitiale
	 * @param yInitiale
	 * @param orientationInitiale
	 * @param instructions
	 * 
	 * 
	 * @see AutonomousCar#xCoinDroit
	 * @see AutonomousCar#yCoinDroit
	 * @see AutonomousCar#xInitiale
	 * @see AutonomousCar#yInitiale
	 * @see AutonomousCar#orientationInitiale
	 * @see AutonomousCar#instructions
	 */

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

	/**
	 *
	 * @param xCoinDroit
	 * 
	 * @see AutonomousCar#xCoinDroit
	 */

	public void setXCoinDroit(int xCoinDroit) {
		this.xCoinDroit = xCoinDroit;
	}

	/**
	 *
	 * @return {@link AutonomousCar#xCoinDroit}
	 */

	public int getXCoinDroit() {
		return xCoinDroit;
	}

	/**
	 *
	 * @param yCoinDroit
	 * 
	 * @see AutonomousCar#yCoinDroit
	 */

	public void setYCoinDroit(int yCoinDroit) {
		this.yCoinDroit = yCoinDroit;
	}

	/**
	 *
	 * @return {@link AutonomousCar#yCoinDroit}
	 */

	public int getYCoinDroit() {
		return yCoinDroit;
	}

	// Setters et getters initiaux

	/**
	 *
	 * @param xInitiale
	 * 
	 * @see AutonomousCar#xInitiale
	 */

	public void setXInitiale(int xInitiale) {
		this.xInitiale = xInitiale;
	}

	/**
	 *
	 * @return {@link AutonomousCar#xInitiale}
	 */

	public int getXInitiale() {
		return xInitiale;
	}

	/**
	 *
	 * @param yInitiale
	 * 
	 * @see AutonomousCar#yInitiale
	 */

	public void setYInitiale(int yInitiale) {
		this.yInitiale = yInitiale;
	}

	/**
	 *
	 * @return {@link AutonomousCar#yInitiale}
	 */

	public int getYInitiale() {
		return yInitiale;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * @param orientationInitiale
	 * 
	 * @see AutonomousCar#orientationInitiale
	 */

	public void setOrientationInitiale(String orientationInitiale) {
		this.orientationInitiale = orientationInitiale;
	}

	/**
	 *
	 * @return {@link AutonomousCar#orientationInitiale}
	 */

	public String getOrientationInitiale() {
		return orientationInitiale;
	}

	/**
	 *
	 * @param instructions
	 * 
	 * @see AutonomousCar#instructions
	 */

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	/**
	 *
	 * @return {@link AutonomousCar#instructions}
	 */

	public String getInstructions() {
		return instructions;
	}

	// Setters et getters actuels

	/**
	 *
	 * @param xActuelle
	 * 
	 * @see AutonomousCar#xActuelle
	 */

	public void setXActuelle(int xActuelle) {
		this.xActuelle = xActuelle;
	}

	/**
	 *
	 * @return {@link AutonomousCar#xActuelle}
	 */

	public int getXActuelle() {
		return xActuelle;
	}

	/**
	 *
	 * @param yActuelle
	 * 
	 * @see AutonomousCar#yActuelle
	 */

	public void setYActuelle(int yActuelle) {
		this.yActuelle = yActuelle;
	}

	/**
	 *
	 * @return {@link AutonomousCar#yActuelle}
	 */

	public int getYActuelle() {
		return yActuelle;
	}

	/**
	 *
	 * @param orientationActuelle
	 * 
	 * @see AutonomousCar#orientationActuelle
	 */

	public void setOrientationActuelle(String orientationActuelle) {
		this.orientationActuelle = orientationActuelle;
	}

	/**
	 *
	 * @return {@link AutonomousCar#orientationActuelle}
	 */

	public String getOrientationActuelle() {
		return orientationActuelle;
	}

	// Setters et getters finaux

	/**
	 *
	 * @param xFinale
	 * 
	 * @see AutonomousCar#xFinale
	 */

	public void setXFinale(int xFinale) {
		this.xFinale = xFinale;
	}

	/**
	 *
	 * @return {@link AutonomousCar#xFinale}
	 */

	public int getXFinale() {
		return xFinale;
	}

	/**
	 *
	 * @param yFinale
	 * 
	 * @see AutonomousCar#yFinale
	 */

	public void setYFinale(int yFinale) {
		this.yFinale = yFinale;
	}

	/**
	 *
	 * @return {@link AutonomousCar#yFinale}
	 */

	public int getYFinale() {
		return yFinale;
	}

	/**
	 *
	 * @param orientationFinale
	 * 
	 * @see AutonomousCar#orientationFinale
	 */

	public void setOrientationFinale(String orientationFinale) {
		this.orientationFinale = orientationFinale;
	}

	/**
	 *
	 * @return {@link AutonomousCar#orientationFinale}
	 */

	public String getOrientationFinale() {
		return orientationFinale;
	}

	// Setter et getter du Chrono du temps mis pour parcourir par la
	// voiture

	/**
	 *
	 * @param chronoFinale
	 * 
	 * @see AutonomousCar#chronoFinale
	 */

	public void setChronoFinale(long chronoFinale) {
		this.chronoFinale = chronoFinale;
	}

	/**
	 *
	 * @return {@link AutonomousCar#chronoFinale}
	 */

	public long getChronoFinale() {
		return chronoFinale;
	}

}
