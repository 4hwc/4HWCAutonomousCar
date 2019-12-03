package com.autonomouscar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.autonomouscar.exceptions.AutonomousCarException;

/**
 * <b>AutonomousCarServiceTest represents the test class of AutonomousCarService
 * <b/>
 * 
 * model class : AutonomousCar
 * 
 * @author Fanon Jupkwo
 * 
 * 
 */

public class AutonomousCarServiceTest {

	AutonomousCarService autonomousCarService = new AutonomousCarService();

	// TESTS -> getXYCoinDroit4HWC(), getXYInitiale4HWC(int)

	/**
	 * @see AutonomousCarService#getXYCoinDroit4HWC()
	 * @see AutonomousCarService#getXYInitiale4HWC(int)
	 */

	@Test
	public void positionsAleatoiresTest()

	{
		int xCD = autonomousCarService.getXYCoinDroit4HWC();
		int yCD = autonomousCarService.getXYCoinDroit4HWC();
		int xInit = autonomousCarService.getXYInitiale4HWC(xCD);
		int yInit = autonomousCarService.getXYInitiale4HWC(yCD);

		assertTrue(xCD >= 0 && xCD <= 5);
		assertTrue(yCD >= 0 && yCD <= 5);
		assertTrue(xInit >= 0 && xInit <= xCD);
		assertTrue(yInit >= 0 && yInit <= yCD);

	}

	// TESTS -> validationNombreDeVehicules(String nbre)

	/**
	 * @see AutonomousCarService#validationNombreDeVehicules(String)
	 * 
	 */

	@Test
	public void shouldNotThrowAnyViolationValidationNombreDeVehicules()

	{

		assertThatCode(() -> autonomousCarService.validationNombreDeVehicules("1")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationNombreDeVehicules(" 1 ")).doesNotThrowAnyException();

	}

	/**
	 * @see AutonomousCarService#validationNombreDeVehicules(String)
	 * 
	 */

	@Test(expected = AutonomousCarException.class)
	public void shouldThrowViolationsValidationNombreDeVehicules1() throws AutonomousCarException {

		autonomousCarService.validationNombreDeVehicules("1 0");

	}

	/**
	 * @see AutonomousCarService#validationNombreDeVehicules(String)
	 * 
	 */

	@Test
	public void shouldThrowViolationsValidationNombreDeVehicules2() {

		Throwable validationExceptionThrown = catchThrowable(() -> {

			autonomousCarService.validationNombreDeVehicules("1*");

		});

		assertThat(validationExceptionThrown).isInstanceOf(AutonomousCarException.class);

	}

	/**
	 * @see AutonomousCarService#validationNombreDeVehicules(String)
	 * 
	 */

	@Test(expected = AutonomousCarException.class)
	public void shouldThrowViolationsValidationNombreDeVehicules3() throws AutonomousCarException {

		autonomousCarService.validationNombreDeVehicules("0");

	}

	// TEST -> validationPositions(String xCoinDroit, String yCoinDroit,
	// String xInitiale, String yInitiale)

	/**
	 * @see AutonomousCarService#validationPositions(String, String, String, String)
	 * 
	 */

	@Test
	public void shouldNotThrowAnyViolationValidationPositions()

	{

		assertThatCode(() -> autonomousCarService.validationPositions("5 ", " 4 ", "3", "    2"))
				.doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationPositions("5 ", "5", "5", " 5")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationPositions("0 ", " 0 ", "0", " 0"))
				.doesNotThrowAnyException();

	}

	/**
	 * @see AutonomousCarService#validationPositions(String, String, String, String)
	 * 
	 */

	@Test(expected = AutonomousCarException.class)
	public void shouldThrowViolationsValidationPositionsString1() throws AutonomousCarException {

		autonomousCarService.validationPositions("6 ", " 0 ", "0", " 0");

	}

	/**
	 * @see AutonomousCarService#validationPositions(String, String, String, String)
	 * 
	 */

	@Test
	public void shouldThrowViolationsValidationPositions2() {

		Throwable validationExceptionThrown1 = catchThrowable(() -> {

			autonomousCarService.validationPositions("4 0", " 0 ", "0", " 0");

		});

		assertThat(validationExceptionThrown1).isInstanceOf(AutonomousCarException.class);

		Throwable validationExceptionThrown2 = catchThrowable(() -> {

			autonomousCarService.validationPositions("NUMBER", " 0 ", "0", " 0");

		});

		assertThat(validationExceptionThrown2).isInstanceOf(AutonomousCarException.class);

	}

	/**
	 * @see AutonomousCarService#validationPositions(String, String, String, String)
	 * 
	 */

	@Test(expected = AutonomousCarException.class)
	public void shouldThrowViolationsValidationPositions3() throws AutonomousCarException {

		autonomousCarService.validationPositions("4 ", " 0 ", "5", " 0");

	}

	// TEST -> validationOrientationInitiale(String orientationInitiale)

	/**
	 * @see AutonomousCarService#validationOrientationInitiale(String)
	 * 
	 */

	@Test
	public void shouldNotThrowAnyViolationValidationOrientationInitiale()

	{

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("N")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("E")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("W")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("S")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("   N")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("E   ")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("   W ")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("  S")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("n")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("e")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("w")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("s")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("n  ")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale("   e")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale(" w ")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationOrientationInitiale(" s ")).doesNotThrowAnyException();

	}

	/**
	 * @see AutonomousCarService#validationOrientationInitiale(String)
	 * 
	 */

	@Test(expected = AutonomousCarException.class)
	public void shouldThrowViolationsValidationOrientationInitiale1() throws AutonomousCarException {

		autonomousCarService.validationOrientationInitiale("q");

	}

	/**
	 * @see AutonomousCarService#validationOrientationInitiale(String)
	 * 
	 */

	@Test
	public void shouldThrowViolationsValidationOrientationInitiale2() {

		Throwable validationExceptionThrown1 = catchThrowable(() -> {

			autonomousCarService.validationOrientationInitiale("NEWS");

		});

		assertThat(validationExceptionThrown1).isInstanceOf(AutonomousCarException.class);

		Throwable validationExceptionThrown2 = catchThrowable(() -> {

			autonomousCarService.validationOrientationInitiale("news");

		});

		assertThat(validationExceptionThrown2).isInstanceOf(AutonomousCarException.class);

		Throwable validationExceptionThrown3 = catchThrowable(() -> {

			autonomousCarService.validationOrientationInitiale("n e w s");

		});

		assertThat(validationExceptionThrown3).isInstanceOf(AutonomousCarException.class);

		Throwable validationExceptionThrown4 = catchThrowable(() -> {

			autonomousCarService.validationOrientationInitiale("N E W S");

		});

		assertThat(validationExceptionThrown4).isInstanceOf(AutonomousCarException.class);

	}

	// TEST -> validationInstructions(String instructions)

	/**
	 * @see AutonomousCarService#validationInstructions(String)
	 * 
	 */

	@Test
	public void shouldNotThrowAnyViolationValidationInstructions()

	{

		assertThatCode(() -> autonomousCarService.validationInstructions("DGA")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationInstructions("dga")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationInstructions("Dga")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationInstructions("dGa")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationInstructions("D ")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationInstructions("G   ")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationInstructions("   A ")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationInstructions("  ADGADGDGDDAGDGDGADADA"))
				.doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationInstructions("ADGADGDddagddaAdgAdaAgADg"))
				.doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationInstructions("  aAddGgdaDGADgda  "))
				.doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationInstructions("ADGADDGADDGADdadgdAdAgADGA  "))
				.doesNotThrowAnyException();

	}

	/**
	 * @see AutonomousCarService#validationInstructions(String)
	 * 
	 */

	@Test(expected = AutonomousCarException.class)
	public void shouldThrowViolationsValidationInstructions1() throws AutonomousCarException {

		autonomousCarService.validationInstructions("DGADGGD adg ");

	}

	/**
	 * @see AutonomousCarService#validationInstructions(String)
	 * 
	 */

	@Test
	public void shouldThrowViolationsValidationInstructions2() {

		Throwable validationExceptionThrown1 = catchThrowable(() -> {

			autonomousCarService.validationInstructions("AGADDG V");

		});

		assertThat(validationExceptionThrown1).isInstanceOf(AutonomousCarException.class);

		Throwable validationExceptionThrown2 = catchThrowable(() -> {

			autonomousCarService.validationInstructions("aagdgd a Da dgdgad");

		});

		assertThat(validationExceptionThrown2).isInstanceOf(AutonomousCarException.class);

		Throwable validationExceptionThrown3 = catchThrowable(() -> {

			autonomousCarService.validationInstructions("D G A");

		});

		assertThat(validationExceptionThrown3).isInstanceOf(AutonomousCarException.class);

		Throwable validationExceptionThrown4 = catchThrowable(() -> {

			autonomousCarService.validationInstructions("d g a");

		});

		assertThat(validationExceptionThrown4).isInstanceOf(AutonomousCarException.class);

	}

}
