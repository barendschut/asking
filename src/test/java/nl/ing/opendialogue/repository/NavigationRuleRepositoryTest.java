package nl.ing.opendialogue.repository;

import static org.junit.Assert.assertNull;
import nl.ing.opendialogue.repository.impl.NavigationRuleRepositoryImpl;
import nl.ing.opendialogue.rules.NextAction;

import org.junit.Test;

public class NavigationRuleRepositoryTest {

	@Test
	public void test() {
		NavigationRuleRepository repo = new NavigationRuleRepositoryImpl(); 
		
		NextAction action = repo.getNextAction("test", "test");

		
		assertNull("action cannot be determined", action);
	}

}
