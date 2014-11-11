package nl.ing.opendialogue.rules;

import java.util.ArrayList;
import java.util.List;

public class NavigationRule {

	String context;
	String question;

	String nextContext;
	String nextQuestion;

	public NavigationRule(final String context, final String question, final String nextContext, final String nextQuestion) {
		this.context = context;
		this.question = question;
		this.nextQuestion = nextQuestion;
		this.nextContext = nextContext;
	}
	
	public static List<NavigationRule> getNavigationRules() {
		List<NavigationRule> navigationList = new ArrayList<NavigationRule>();
		
		navigationList.add(new NavigationRule("", "pas gevonden", "Wat zijn de laatste drie cijfers van uw gevonden pas?", "/"));
		return navigationList;
	}
	
	
	public String getContext() {
		return context;
	}

	public String getQuestion() {
		return question;
	}

	public String getNextContext() {
		return nextContext;
	}

	public String getNextQuestion() {
		return nextQuestion;
	}

}
