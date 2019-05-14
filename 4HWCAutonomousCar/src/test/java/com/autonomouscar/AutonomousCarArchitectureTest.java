package com.autonomouscar;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.junit.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

public class AutonomousCarArchitectureTest {

	@Test
	public void some_architecture_rule() {
		JavaClasses importedClasses = new ClassFileImporter().importPackages("com.autonomouscar.model");

		ArchRule rule = classes().should().bePublic();

		rule.check(importedClasses);
	}

}
