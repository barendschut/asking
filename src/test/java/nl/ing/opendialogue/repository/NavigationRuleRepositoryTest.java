package nl.ing.opendialogue.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import nl.ing.opendialogue.repository.impl.NavigationRuleRepositoryImpl;
import nl.ing.opendialogue.rules.NextAction;
import nl.ing.opendialogue.rules.Context;

import org.junit.Test;

public class NavigationRuleRepositoryTest {

	@Test
	public void testUnknownContext() {
		NavigationRuleRepository repo = new NavigationRuleRepositoryImpl(); 
		
		List<NextAction> action = repo.getNextAction("test", "test");
		assertEquals(0, action.size());
	}

	
	@Test
	public void testKnownContextNoNextQuestion() {
		NavigationRuleRepository repo = new NavigationRuleRepositoryImpl(); 
		//NextAction action = repo.getNextAction(Context.CARD_NUMBER.getURL(), "test");
		//assertNull("no action", action.getQuestion());
		//assertEquals("next context is the check", Context.CARD_NUMBER_CHECK, action.getContext());
	}
	
	
	@Test
	public void testActionAfterCorrectBankAccount() {
		NavigationRuleRepository repo = new NavigationRuleRepositoryImpl(); 
		//NextAction action = repo.getNextAction(Context.IBAN, "1234567");
		//assertEquals("Dank u wat is het pasnummer", action.getQuestion());
		//assertEquals("next context is the card number", Context.CARD_NUMBER, action.getContext());
	}
	

	@Test
	public void testActionAfterIncorrectCorrectBankAccount() {
		NavigationRuleRepository repo = new NavigationRuleRepositoryImpl(); 
		//NextAction action = repo.getNextAction(Context.IBAN.getURL(), "1234");
		//assertEquals("Iban is incorrect so ask again", Context.IBAN, action.getContext());
		//assertEquals("Dit is geen iban nummer, geef de laatste 10 cijfers", action.getQuestion());
	}
	
	
	
}
