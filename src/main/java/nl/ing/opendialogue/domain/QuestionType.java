package nl.ing.opendialogue.domain;

public enum QuestionType {
		ALPHANUMERIC("ALPHANUMERIC"), 
		NUMERIC("NUMERIC"), 
		DATE("DATE");

    private final String name;
    
    private QuestionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public static QuestionType getQuestionTypeFromString(String name) {
    	for (QuestionType questionType : values()) {
    		if (questionType.getName().equals(name)) {
    			return questionType;
    		}
    	}
    	return null;
    }
	
}

