package com.autonomouscar.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.autonomouscar.exceptions.AutonomousCarException;

public class AutonomousCarServiceTest {

	AutonomousCarService autonomousCarService = new AutonomousCarService();

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

	@Test
	public void shouldNotThrowAnyViolationValidationNombreDeVehiculesString()

	{

		assertThatCode(() -> autonomousCarService.validationNombreDeVehiculesString("1")).doesNotThrowAnyException();

		assertThatCode(() -> autonomousCarService.validationNombreDeVehiculesString(" 1 ")).doesNotThrowAnyException();

	}

	@Test(expected = AutonomousCarException.class)
	public void shouldThrowViolations() throws AutonomousCarException {

		autonomousCarService.validationNombreDeVehiculesString("1 0");

	}

}
