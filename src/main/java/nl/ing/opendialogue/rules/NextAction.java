package nl.ing.opendialogue.rules;

/**
 *  Next action to be performed
 */
public class NextAction {

	private String question;
	private String context;
	private String regex;
	private String errorMessage;
	private String ivrGrammar;
	private String step;
	
	public NextAction(String context, String question, String regex,
			String errorMessage, String ivrGrammar) {
		this.question = question;
		this.context = context;
		this.regex = regex;
		this.errorMessage = errorMessage;
		this.ivrGrammar = ivrGrammar;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getRegex() {
		return regex;
	}
	public void setRegex(String regex) {
		this.regex = regex;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getIvrGrammar() {
		return ivrGrammar;
	}
	public void setIvrGrammar(String ivrGrammar) {
		this.ivrGrammar = ivrGrammar;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	} 

	


}