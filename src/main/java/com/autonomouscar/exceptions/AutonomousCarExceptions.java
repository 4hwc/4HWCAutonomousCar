package com.autonomouscar.exceptions;

import java.util.HashMap;
import java.util.Map;

public class AutonomousCarExceptions extends Exception {

	private Map<String, String> erreurs = new HashMap<>();

	public AutonomousCarExceptions(String message)

	{
		super(message);
	}

	public AutonomousCarExceptions() {

	}

	public void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

}
