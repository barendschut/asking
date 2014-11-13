package nl.ing.opendialogue.rules;

import java.util.ArrayList;
import java.util.List;

import nl.ing.opendialogue.grammar.GrammarRetriever;
import nl.ing.opendialogue.grammar.GrammarRule;
import org.springframework.util.StringUtils;

public class NavigationRule {

	String context;
	String question;

	String nextContext;
	String nextQuestion;

	String regEx;
	String errorMessage;
	String ivrGrammar;
	String parameterName;
	String step;
	String url;

	public NavigationRule(final String context, final String question, final String nextContext, 
			final String nextQuestion, final String regEx, final String errorMessage, final String ivrGrammar, final String parameterName, final String step, final String url) {
		this.context = context;
		this.question = question;   // our keywords
		this.nextQuestion = nextQuestion;
		this.nextContext = nextContext;
		this.regEx = regEx;
		this.errorMessage = errorMessage;
		this.ivrGrammar = ivrGrammar;
		this.parameterName = parameterName;
		this.step = step;
		this.url = url;
	}
	
	
	public static List<NavigationRule> getNavigationRules() {
		return getRulesFromApi();

		//return getRulesFromStub();
	}
	
	private static List<NavigationRule> getRulesFromApi() {
		List<NavigationRule> navigationList = new ArrayList<NavigationRule>();
		for (GrammarRule grammarRule : GrammarRetriever.getGrammarRules()) {
			NavigationRule navigationRule = new NavigationRule(grammarRule.getContext(),
					grammarRule.getQuery(),
					grammarRule.getNextContext(),
					grammarRule.getNextQuery(),
					grammarRule.getRegEx(),
					grammarRule.getErrorMessage(),
					grammarRule.getIvrGrammar(),
					grammarRule.getParameterName(),
					grammarRule.getStep(),
					grammarRule.getUrl()
					);
			navigationList.add(navigationRule);
		}
		return navigationList;
	}
	
	private static List<NavigationRule> getRulesFromStub() {
		List<NavigationRule> navigationList = new ArrayList<NavigationRule>();
		//navigationList.add(new NavigationRule(null, "pas gevonden", Context.IBAN, "Dank u voor het melden.Als u ons enkele gegevens over de pas kunt verstrekken, dan lichten wij de eigenaar in. Wat is het IBAN nummer van de pas?"));
		//navigationList.add(new NavigationRule(Context.IBAN, "REGEX_ACCOUNT_NUMBER", Context.CARD_NUMBER, "Dank u wat is het pasnummer"));
		//navigationList.add(new NavigationRule(Context.IBAN, "REGEX_NOT_ACCOUNT_NUMBER", Context.IBAN, "Dit is geen iban nummer, geef de laatste 10 cijfers"));
		//navigationList.add(new NavigationRule(Context.CARD_NUMBER, "TODO regex number", Context.CARD_NUMBER_CHECK, null));
		//navigationList.add(new NavigationRule(Context.CARD_NUMBER_CHECK, "OK", Context.CALL_PASSOWNER_TO_BLOCK_PASS, "U mag de pas weggooien. Vanaf nu is deze niet meer bruikbaar"));
		//navigationList.add(new NavigationRule(Context.CARD_NUMBER_CHECK, "NOK", null, "Deze pas kennen we niet in ons systeem. Tot ziens"));
		return navigationList;
	}

	
	public String getContext() {
		return context;
	}
	
	public String getQuestion() {
		return question;
	}


	public String getErrorMessage() {
		return errorMessage;
	}

	public String getIvrGrammar() {
		return ivrGrammar;
	}


	public String getNextContext() {
		return nextContext;
	}


	public String getNextQuestion() {
		return nextQuestion;
	}


	public String getRegEx() {
		return regEx;
	}


	public String getParameterName() {
		return parameterName;
	}


	public String getStep() {
		return step;
	}
	
	

	public String getUrl() {
		return url;
	}


	public boolean matches(String query) {
		if (StringUtils.isEmpty(question) || StringUtils.isEmpty(query)) {
			return StringUtils.isEmpty(query) && StringUtils.isEmpty(question);
		}

		String[] keywords = question.split(" ");
		for (int i=0; i<keywords.length; i++) {
			if(query.contains(keywords[i])){
				return true;
			}
		}

		return false;
	}
}
