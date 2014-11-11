package nl.ing.opendialogue.repository.impl;

import nl.ing.opendialogue.repository.NavigationRuleRepository;
import nl.ing.opendialogue.rules.NavigationRule;

import org.springframework.stereotype.Repository;

@Repository
public class NavigationRuleRepositoryImpl implements NavigationRuleRepository {

	@Override
	public NavigationRule getNextStep() {
		return NavigationRule.getNavigationRules().get(0);
	}
}
