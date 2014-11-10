package nl.ing.opendialogue.domain;

public class DialogueRequest {

    private final String query;
    private final Channel channel;

    public DialogueRequest(final String query, final Channel channel) {
        this.query = query;
        this.channel = channel;
    }

    public String getQuery() {

        return query;
    }

    public Channel getChannel() {
        return channel;
    }

}