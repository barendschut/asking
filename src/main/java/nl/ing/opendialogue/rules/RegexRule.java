package nl.ing.opendialogue.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author bart boon contains a set of regular expression rules
 *
 *
 */

public enum RegexRule {

	REGEX_ACCOUNT_NUMBER("REGEX_ACCOUNT_NUMBER", "\\d{5,10}"),
	REGEX_NOT_ACCOUNT_NUMBER("REGEX_NOT_ACCOUNT_NUMBER", "\\d{5,10}", true);
	
	private String ruleName;
	private String regularExpression;
	private boolean returnInverse;
	
	RegexRule(String ruleName, String regularExpression) {
		this.ruleName = ruleName;
		this.regularExpression = regularExpression;
		this.returnInverse = false;
	}

	RegexRule(String ruleName, String regularExpression, boolean inverse) {
		this.ruleName = ruleName;
		this.regularExpression = regularExpression;
		this.returnInverse = inverse;
	}

	
	public String getRegularExpression() {
		return regularExpression;
	}

	private String getRuleName() {
		return ruleName;
	}

	public boolean matches(String stringToMatch) {
		Pattern pattern = Pattern.compile(getRegularExpression());
		Matcher matcher = pattern.matcher(stringToMatch);
		if (returnInverse) {
			return !matcher.matches();
		}
		return matcher.matches();
	}

	public static RegexRule getRegexRuleFromString(String regexName) {
		for (RegexRule regexRule : values()) {
			if (regexRule.getRuleName().equals(regexName)) {
				return regexRule;
			}
		}
		return null;
	}
}
