package nl.ing.opendialogue.grammar;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GrammarResponse {

	@JsonProperty("results")
	private List<GrammarRule> rules;

	public List<GrammarRule> getRules() {
		return rules;
	}

	public void setRules(List<GrammarRule> rules) {
		this.rules = rules;
	} 

	
	
}
