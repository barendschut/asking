package nl.ing.opendialogue.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegexRuleTest {

	@Test
	public void correctAccountNumber() {
		assertTrue("Correct account number", RegexRule.REGEX_ACCOUNT_NUMBER.matches("1234567890"));
	}
	
	@Test
	public void accountNumberTooLong() {
		assertFalse("Account number too long", RegexRule.REGEX_ACCOUNT_NUMBER.matches("12345678901"));
	}
	
	@Test
	public void accountNumberTooShort() {
		assertFalse("Account number too long", RegexRule.REGEX_ACCOUNT_NUMBER.matches("1234"));
	}
	
	@Test
	public void accountNumberTooShortInverse() {
		assertTrue("Account number too short", RegexRule.REGEX_NOT_ACCOUNT_NUMBER.matches("1234"));
	}
	
	@Test
	public void accountNumberDoesNotContainNumbers() {
		assertFalse("Account number too long", RegexRule.REGEX_ACCOUNT_NUMBER.matches("12345AA"));
	}
	
	@Test
	public void retrieveRegularExpressionByName() {
		assertEquals("Regex should be equal if retried by its own name", 
				RegexRule.REGEX_ACCOUNT_NUMBER, RegexRule.getRegexRuleFromString(RegexRule.REGEX_ACCOUNT_NUMBER.name()));
	}
	
	
	
	
	
}
