package nl.ing.opendialogue.repository;

import static org.junit.Assert.assertEquals;
import nl.ing.opendialogue.domain.DialogueResponse;
import nl.ing.opendialogue.repository.impl.NavigationRuleRepositoryImpl;

import org.junit.Test;

public class NavigationRuleRepositoryTest {

	@Test
	public void testUnknownContext() {
		NavigationRuleRepository repo = new NavigationRuleRepositoryImpl(); 
		
		DialogueResponse response = repo.getNextAction("/answer", "pas");
		assertEquals(3, response.getQuestions().size());
	}

	
	/*
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
	*/
}
