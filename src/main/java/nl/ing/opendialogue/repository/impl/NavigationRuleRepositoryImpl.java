package nl.ing.opendialogue.repository.impl;

import java.util.ArrayList;
import java.util.List;

import nl.ing.opendialogue.domain.DialogueResponse;
import nl.ing.opendialogue.repository.NavigationRuleRepository;
import nl.ing.opendialogue.rules.Context;
import nl.ing.opendialogue.rules.NavigationRule;
import nl.ing.opendialogue.rules.NextAction;
import nl.ing.opendialogue.rules.RegexRule;

import org.springframework.stereotype.Repository;

@Repository
public class NavigationRuleRepositoryImpl implements NavigationRuleRepository {
	
	@Override
	public List<NextAction> getNextAction(String contextString, String query) {
		Context context = Context.getContextFromString(contextString);
		return getNextAction(context, query);
	}
	

	@Override
	public List<NextAction> getNextAction(Context currentContext, String query){
		List<NextAction> nextActions = new ArrayList<NextAction>();
		for (NavigationRule rule: NavigationRule.getNavigationRules()) {
			if (currentContext == rule.getContext()) {
				nextActions.add(getNextAction(rule));	
			}
		}
		return nextActions;
	}
	
	
	private NextAction getNextAction(NavigationRule rule) {
		String nextActionContext = null;
		if (rule.getNextContext() != null) {
			nextActionContext = rule.getNextContext().getURL(); 
		}
		String regex = null;
		if (rule.getRegEx()!=null) {
			regex = RegexRule.getRegexRuleFromString(rule.getRegEx()).getRegularExpression();
		}
		
		NextAction action = new NextAction(nextActionContext, 
				rule.getNextQuestion(), regex, rule.getErrorMessage(), rule.getIvrGrammar());
		return action;
	}


	
	/***
	 * Ik zou graag zoiets willen terug krijgen. 
	 * Een DialogueResponse met daarin:
	 * 	- een contextUrl waarop de client een post of get doet. (kan leeg zijn als er niet naar een andere url hoeft worden gegaan)
	 * 	- een lijst van vragen van het type (dat lijkt op) QuestionForCustomer
	 */
	@Override
	public DialogueResponse getNextAction(String query) {

		
		
		return null;
	}
	
	
}