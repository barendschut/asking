package nl.ing.opendialogue.repository.impl;

import nl.ing.opendialogue.repository.NavigationRuleRepository;
import nl.ing.opendialogue.rules.Context;
import nl.ing.opendialogue.rules.NavigationRule;
import nl.ing.opendialogue.rules.NextAction;

import org.springframework.stereotype.Repository;

@Repository
public class NavigationRuleRepositoryImpl implements NavigationRuleRepository {
	
	@Override
	public NextAction getNextAction(String query, String contextString) {
		Context context = Context.getContextFromString(contextString);
		if (context == null) {
			return null;
		}
		return getNextAction(query, context);
	}
	
	public static NextAction getNextAction(String query, Context context){
		NavigationRule rule = NavigationRule.getNavigationRules().get(0);
		return new NextAction(rule.getNextQuestion(), rule.getNextContext());
		
	}

}