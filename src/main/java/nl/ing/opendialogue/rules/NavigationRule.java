package nl.ing.opendialogue.rules;

import java.util.ArrayList;
import java.util.List;

import nl.ing.opendialogue.grammar.GrammarRetriever;
import nl.ing.opendialogue.grammar.GrammarRule;

public class NavigationRule {

	Context context;
	String question;

	Context nextContext;
	String nextQuestion;

	String regEx;
	String errorMessage;
	String ivrGrammar;

	public NavigationRule(final Context context, final String question, final Context nextContext, final String nextQuestion) {
		this.context = context;
		this.question = question;
		this.nextQuestion = nextQuestion;
		this.nextContext = nextContext;
	}
	
	
	public static List<NavigationRule> getNavigationRules() {
		//return getRulesFromApi();

		return getRulesFromStub();
	}
	
	private static List<NavigationRule> getRulesFromApi() {
		List<NavigationRule> navigationList = new ArrayList<NavigationRule>();
		for (GrammarRule grammarRule : GrammarRetriever.getGrammarRules()) {
			NavigationRule navigationRule = new NavigationRule(Context.getContextFromString(grammarRule.getContext()),
					grammarRule.getQuery(),
					Context.getContextFromString(grammarRule.getNextContext()),
					grammarRule.getNextQuery());
			navigationList.add(navigationRule);
		}
		return navigationList;
	}
	
	private static List<NavigationRule> getRulesFromStub() {
		List<NavigationRule> navigationList = new ArrayList<NavigationRule>();
		navigationList.add(new NavigationRule(null, "pas gevonden", Context.IBAN, "Dank u voor het melden.Als u ons enkele gegevens over de pas kunt verstrekken, dan lichten wij de eigenaar in. Wat is het IBAN nummer van de pas?"));
		navigationList.add(new NavigationRule(Context.IBAN, "REGEX_ACCOUNT_NUMBER", Context.CARD_NUMBER, "Dank u wat is het pasnummer"));
		navigationList.add(new NavigationRule(Context.IBAN, "REGEX_NOT_ACCOUNT_NUMBER", Context.IBAN, "Dit is geen iban nummer, geef de laatste 10 cijfers"));
		navigationList.add(new NavigationRule(Context.CARD_NUMBER, "TODO regex number", Context.CARD_NUMBER_CHECK, null));
		navigationList.add(new NavigationRule(Context.CARD_NUMBER_CHECK, "OK", Context.CALL_PASSOWNER_TO_BLOCK_PASS, "U mag de pas weggooien. Vanaf nu is deze niet meer bruikbaar"));
		navigationList.add(new NavigationRule(Context.CARD_NUMBER_CHECK, "NOK", null, "Deze pas kennen we niet in ons systeem. Tot ziens"));
		return navigationList;
	}

	
	public Context getContext() {
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


	public Context getNextContext() {
		return nextContext;
	}


	public String getNextQuestion() {
		return nextQuestion;
	}


	public String getRegEx() {
		return regEx;
	}




}
