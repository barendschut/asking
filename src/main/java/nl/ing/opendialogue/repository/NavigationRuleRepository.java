package nl.ing.opendialogue.repository;

import nl.ing.opendialogue.rules.NextAction;

public interface NavigationRuleRepository {

	

	NextAction getNextAction(String query, String contextString);
	
}
