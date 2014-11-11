package nl.ing.opendialogue.rules;

import java.util.ArrayList;
import java.util.List;

public class NavigationRule {

	Context context;
	String question;

	Context nextContext;
	String nextQuestion;

	// refactor to enum
	
	
	public NavigationRule(final Context context, final String question, final Context nextContext, final String nextQuestion) {
		this.context = context;
		this.question = question;
		this.nextQuestion = nextQuestion;
		this.nextContext = nextContext;
	}
	
	
	public static List<NavigationRule> getNavigationRules() {
		List<NavigationRule> navigationList = new ArrayList<NavigationRule>();
		
		navigationList.add(new NavigationRule(null, "pas gevonden", Context.IBAN, "Dank u voor het melden.Als u ons enkele gegevens over de pas kunt verstrekken, dan lichten wij de eigenaar in. Wat is het IBAN nummer van de pas?"));
		navigationList.add(new NavigationRule(Context.IBAN, "TODO regex number", Context.CARD_NUMBER, "Dank u wat is het pasnummer"));
		navigationList.add(new NavigationRule(Context.CARD_NUMBER, "TODO regex number", Context.CARD_NUMBER_CHECK, null));
		navigationList.add(new NavigationRule(Context.CARD_NUMBER_CHECK, "OK", Context.CALL_PASSOWNER_TO_BLOCK_PASS, "U mag de pas weggooien. Vanaf nu is deze niet meer bruikbaar"));
		navigationList.add(new NavigationRule(Context.CARD_NUMBER_CHECK, "NOK", null, "Deze pas kennen we niet. Tot ziens"));
				
		
		
		return navigationList;
		
	}
	
	
	public Context getContext() {
		return context;
	}

	public String getQuestion() {
		return question;
	}

	public Context getNextContext() {
		return nextContext;
	}

	public String getNextQuestion() {
		return nextQuestion;
	}

}
