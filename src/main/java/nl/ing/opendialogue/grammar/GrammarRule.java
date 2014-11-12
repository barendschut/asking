package nl.ing.opendialogue.grammar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GrammarRule {

	private String context;
	private String query;

	private String nextContext;
	private String nextQuery;
	
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getNextContext() {
		return nextContext;
	}

	public void setNextContext(String nextContext) {
		this.nextContext = nextContext;
	}

	public String getNextQuery() {
		return nextQuery;
	}

	public void setNextQuery(String nextQuery) {
		this.nextQuery = nextQuery;
	}
	
}






