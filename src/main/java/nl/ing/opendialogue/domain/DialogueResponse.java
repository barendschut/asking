package nl.ing.opendialogue.domain;

import java.util.List;

/**
 * Represents a list of answers to the client Based on this list, the client-app
 * can build a url for this post.
 */
public class DialogueResponse {

	// List of questions for the client
	private final List<QuestionForCustomer> questions;

	/** Url to post userinput to or to redirect to. */
	private String contextUrl;

	public DialogueResponse(final List<QuestionForCustomer> questions) {
		this.questions = questions;
	}

	public List<QuestionForCustomer> getQuestions() {
		return questions;
	}

	public String getContextUrl() {
		return contextUrl;
	}

	public void setContextUrl(String contextUrl) {
		this.contextUrl = contextUrl;
	}
}
