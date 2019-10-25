package com.autonomouscar.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AutonomousCarServiceTest {

	AutonomousCarService autonomousCarService = new AutonomousCarService();

	@Test
	public void positionsTest()

	{
		int xCD = autonomousCarService.getXCoinDroit4HWC();
		int yCD = autonomousCarService.getYCoinDroit4HWC();
		int xInit = autonomousCarService.getXInitiale4HWC(xCD);
		int yInit = autonomousCarService.getYInitiale4HWC(yCD);

		assertTrue(xCD >= 0 && xCD <= 5);
		assertTrue(yCD >= 0 && yCD <= 5);
		assertTrue(xInit >= 0 && xInit <= xCD);
		assertTrue(yInit >= 0 && yInit <= xCD);

	}

}
