package nl.ing.opendialogue.domain;

import java.util.List;

public class DialogueRequest {

	// List of questions for the client
	private final List<AnswerForApi> answers;

	public DialogueRequest(final List<AnswerForApi> answers) {
		this.answers = answers;
	}

	public List<AnswerForApi> getAnswers() {
		return answers;
	}

}