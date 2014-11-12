package nl.ing.opendialogue.repository.impl;

import nl.ing.opendialogue.repository.NavigationRuleRepository;
import nl.ing.opendialogue.rules.Context;
import nl.ing.opendialogue.rules.NavigationRule;
import nl.ing.opendialogue.rules.NextAction;
import nl.ing.opendialogue.rules.RegexRule;

import org.springframework.stereotype.Repository;

@Repository
public class NavigationRuleRepositoryImpl implements NavigationRuleRepository {
	
	@Override
	public NextAction getNextAction(String contextString, String query) {
		Context context = Context.getContextFromString(contextString);
		if (context == null) {
			return null;
		}
		return getNextAction(context, query);
	}
	

	@Override
	/**
	 * determines the next action based on
	 *    - context  
	 *    - query    
	 *    
	 * @param context 
	 * @param query      (the current answer from the client)
	 * 
	 * working mechanism, run through all known until a match is found
	 * 
	 * @return NextAction containing the nextQuestion and nextContext
	 */
	public NextAction getNextAction(Context currentContext, String query){
		
		for (NavigationRule rule: NavigationRule.getNavigationRules()) {
			
			// TODO refactor: matching should be pushed to navigationRule class
			if (currentContext == rule.getContext()) {
				if (rule.getQuestion().contains("REGEX")) {
					RegexRule regexRule = RegexRule.getRegexRuleFromString(rule.getQuestion());
					if (regexRule == null) {
						// ERROR an entry with unknown regular expression is made, throw exception?
						return null;
					} else {
						if (regexRule.matches(query)) {
							return new NextAction(rule.getNextQuestion(), rule.getNextContext());
						}
					}
					
				} else {
					// TODO match on the keywords if present in the rule !
					return new NextAction(rule.getNextQuestion(), rule.getNextContext());
				}
			}
		}
		return null;   // TODO return something like I did not understand your question
		
	}
	
	
	
	
}