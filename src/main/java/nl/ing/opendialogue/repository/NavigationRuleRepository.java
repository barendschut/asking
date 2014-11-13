package nl.ing.opendialogue.repository;

import nl.ing.opendialogue.domain.DialogueResponse;

public interface NavigationRuleRepository {

	//List<NextAction> getNextAction(String contextString, String query);

	//List<NextAction> getNextAction(Context context, String query);

	DialogueResponse getNextAction(String context, String query);
	
	
}
