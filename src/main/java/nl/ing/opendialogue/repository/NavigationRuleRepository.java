package nl.ing.opendialogue.repository;

import nl.ing.opendialogue.rules.Context;
import nl.ing.opendialogue.rules.NextAction;

public interface NavigationRuleRepository {

	

	NextAction getNextAction(String contextString, String query);

	NextAction getNextAction(Context context, String query);

	
}
