package nl.ing.opendialogue.repository.impl;

import java.util.ArrayList;
import java.util.List;

import nl.ing.opendialogue.domain.DialogueResponse;
import nl.ing.opendialogue.domain.QuestionForCustomer;
import nl.ing.opendialogue.domain.QuestionType;
import nl.ing.opendialogue.repository.NavigationRuleRepository;
import nl.ing.opendialogue.rules.NavigationRule;
import nl.ing.opendialogue.rules.RegexRule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class NavigationRuleRepositoryImpl implements NavigationRuleRepository {
	
	@Value("${host.url}")
    private String HEROKU_URL;
	
	/***
	 * Ik zou graag zoiets willen terug krijgen. Bij deze dan maar !
	 * Een DialogueResponse met daarin:
	 * 	- een contextUrl waarop de client een post of get doet. (kan leeg zijn als er niet naar een andere url hoeft worden gegaan)
	 * 	- een lijst van vragen van het type (dat lijkt op) QuestionForCustomer
	 */
	@Override
	public DialogueResponse getNextAction(String context, String query) {
		List<QuestionForCustomer> questionList = new ArrayList<QuestionForCustomer>();
		
		DialogueResponse response = new DialogueResponse(questionList);
		for (NavigationRule rule: NavigationRule.getNavigationRules()) {
				if(context!=null && context.equals(rule.getContext())) {
					questionList.add(getQuestion(rule));
					response.setContextUrl(getNextContextUrl(rule));
				}
		}
		
		return response;
	}
	
	private QuestionForCustomer getQuestion(NavigationRule rule) {
		String regex = null;
		if (rule.getRegEx()!=null && RegexRule.getRegexRuleFromString(rule.getRegEx())!=null) {
			regex = RegexRule.getRegexRuleFromString(rule.getRegEx()).getRegularExpression();
		}
		
		QuestionForCustomer question = new QuestionForCustomer();
		
		question.setErrorMessageForWrongInput(rule.getErrorMessage());
		question.setParameterName(rule.getParameterName());
		question.setQuestion(rule.getNextQuestion());
		question.setRegexForAnswerGivenByCustomer(regex);
		question.setStep(rule.getStep());
		question.setType(QuestionType.getQuestionTypeFromString(rule.getIvrGrammar())); 		
		
		return question;
	}
	
	private String getNextContextUrl(NavigationRule rule) {
		if (rule.getNextContext() != null) {
			return HEROKU_URL + rule.getNextContext();
		}
		return null;
	}
}