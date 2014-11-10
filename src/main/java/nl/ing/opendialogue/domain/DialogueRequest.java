package nl.ing.opendialogue.domain;

public class DialogueRequest {

    private final String query;

    public DialogueRequest(final String query) {
        this.query = query;
    }

    public String getQuery() {

        return query;
    }

}