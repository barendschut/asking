package nl.ing.opendialogue.rules;

public enum Context {

	PASS_FOUND("pass-found", ActionType.DIALOGUE),
	IBAN("iban", ActionType.DIALOGUE),
    CARD_NUMBER("card-number", ActionType.DIALOGUE),
    CARD_NUMBER_CHECK("card-number-check", ActionType.ACTION ), 
    CALL_PASSOWNER_TO_BLOCK_PASS("call-passowner-to-block-pass", null);

    private final String url;
    private final ActionType actionType;

    private Context(String url, ActionType type) {
        this.url = url;
        this.actionType = type;
    }

    public String getURL() {
        return url;
    }
    
    public ActionType getActionType() {
		return actionType;
	}
    
    public static Context getContextFromString(String url) {
    	for (Context context : values()) {
    		if (context.equals(url)) {
    			return context;
    		}
    	}
    	return null;
    }
	
}
