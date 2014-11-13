package nl.ing.opendialogue.controller;

import nl.ing.opendialogue.domain.DialogueResponse;
import nl.ing.opendialogue.repository.NavigationRuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoundDebitCardController {


	@Autowired
	private NavigationRuleRepository navigationRuleRepository;

	@RequestMapping(value = "/validate-card", method = RequestMethod.POST)
	public DialogueResponse validateCard(@RequestBody String cardNumber, @RequestBody String expiryDate) {

		if (isCardFound(cardNumber, expiryDate)) {
			return navigationRuleRepository.getNextAction("/card-found-end",
					null);
		}
		return navigationRuleRepository.getNextAction("/card-found-end",
				null);
	}

	private boolean isCardFound(String cardNumber, String expiryDate) {
		return cardNumber.contains("1234") && expiryDate.contains("072017");
	}
}