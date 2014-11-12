package nl.ing.opendialogue.repository;

import java.util.List;

import nl.ing.opendialogue.domain.DialogueResponse;
import nl.ing.opendialogue.rules.Context;
import nl.ing.opendialogue.rules.NextAction;

public interface NavigationRuleRepository {

	List<NextAction> getNextAction(String contextString, String query);

	List<NextAction> getNextAction(Context context, String query);

	DialogueResponse getNextAction(String query);
	
	
}
