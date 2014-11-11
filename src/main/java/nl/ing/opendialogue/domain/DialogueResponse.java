package nl.ing.opendialogue.domain;

public class DialogueResponse {

	private final String answer;
	private String resourceUrl;
	private String nextStepUrl;

	public DialogueResponse(final String answer, final String nextStepUrl) {
		this.answer = answer;
		this.nextStepUrl = nextStepUrl;
	}

	public String getAnswer() {
		return answer;
	}

	public String getNextStepUrl() {
		return nextStepUrl;
	}
	
	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setUrl(String url) {
		this.resourceUrl = url;
	}

}
