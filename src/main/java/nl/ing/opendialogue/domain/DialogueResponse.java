package nl.ing.opendialogue.domain;

public class DialogueResponse {

    private final String answer;
    private String url;
    
    public DialogueResponse(final String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return answer;
    }
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
}
