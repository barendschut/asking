package nl.ing.opendialogue.rules;

/**
 *  Next action to be performed
 */
public class NextAction {

	private String question;
	private Context context;

	public NextAction(String question, Context context) {
		super();
		this.question = question;
		this.context = context;
	}

	public String getQuestion() {
		return question;
	}

	public Context getContext() {
		return context;
	}
}