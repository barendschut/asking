package nl.ing.opendialogue.repository;

import nl.ing.opendialogue.rules.NavigationRule;

public interface NavigationRuleRepository {

	
	NavigationRule getNextStep();
	
}
