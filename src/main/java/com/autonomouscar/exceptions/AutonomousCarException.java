package com.autonomouscar.exceptions;

import java.util.HashMap;
import java.util.Map;

public class AutonomousCarException extends Exception {

	private Map<String, String> erreurs = new HashMap<>();

	public AutonomousCarException(String message)

	{
		super(message);
	}

}
