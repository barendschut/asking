package nl.ing.opendialogue.repository;

import nl.ing.opendialogue.domain.DialogueResponse;

public interface NavigationRuleRepository {

	DialogueResponse getNextAction(String query, String originContext);
//	DialogueResponse getNextAction(String query, String originContext, String originHttpMethod);
	
}
