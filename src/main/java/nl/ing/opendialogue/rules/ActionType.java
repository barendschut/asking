package nl.ing.opendialogue.rules;

public enum ActionType {
	DIALOGUE("a dialogue action"),
	ACTION("a backend action");
    
	private final String description;

    private ActionType(String description) {
        this.description  = description;
    }

    public String getDescription() {
    	return description;
    }
    
}
