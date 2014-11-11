package nl.ing.opendialogue.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import nl.ing.opendialogue.repository.impl.NavigationRuleRepositoryImpl;
import nl.ing.opendialogue.rules.NextAction;
import nl.ing.opendialogue.rules.Context;

import org.junit.Test;

public class NavigationRuleRepositoryTest {

	@Test
	public void testUnknownContext() {
		NavigationRuleRepository repo = new NavigationRuleRepositoryImpl(); 
		
		NextAction action = repo.getNextAction("test", "test");
		assertNull("action cannot be determined", action);
	}

	
	@Test
	public void testKnownContext() {
		NavigationRuleRepository repo = new NavigationRuleRepositoryImpl(); 
		
		NextAction action = repo.getNextAction(Context.CARD_NUMBER.getURL(), "test");
		assertEquals("blaat", action.getQuestion());
	}

	
	
	
}
