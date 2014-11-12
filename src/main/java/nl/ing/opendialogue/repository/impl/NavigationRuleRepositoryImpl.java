package nl.ing.opendialogue.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.ing.opendialogue.domain.DialogueResponse;
import nl.ing.opendialogue.domain.QuestionForCustomer;
import nl.ing.opendialogue.repository.NavigationRuleRepository;
import nl.ing.opendialogue.rules.Context;
import nl.ing.opendialogue.rules.NavigationRule;
import nl.ing.opendialogue.rules.NextAction;
import nl.ing.opendialogue.rules.RegexRule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class NavigationRuleRepositoryImpl implements NavigationRuleRepository {
	
	@Value("${host.url}")
    private String HEROKU_URL;
	
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
		
		if (StringUtils.isEmpty(query)) {
        	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
        	questionForCustomer.setQuestion("Welkom bij de ING. Waarmee kan ik u helpen?");
			List<QuestionForCustomer> questions = Arrays.asList(questionForCustomer);    		
    		return new DialogueResponse(questions);
    	}

        if (query.contains("pas") && query.contains("gevonden")) {
        	
        	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
        	List<QuestionForCustomer> questions = Arrays.asList(questionForCustomer);
			
            DialogueResponse dialogueResponse = new DialogueResponse(questions);
			dialogueResponse.setContextUrl(HEROKU_URL + "/validate-card");
			return dialogueResponse;
        }

        if (query.contains("rente")) {
        	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
        	questionForCustomer.setQuestion("De huidige rentestand is -0.25%");
			List<QuestionForCustomer> questions = Arrays.asList(questionForCustomer);    		
            return new DialogueResponse(questions);
        }

    	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
    	questionForCustomer.setQuestion("Met deze vraag kunnen wij u niet helpen. Iets er iets anders waarmee wij u van dienst kunnen zijn?");
		List<QuestionForCustomer> questions = Arrays.asList(questionForCustomer);    		
        return new DialogueResponse(questions);
	}
	
	
}