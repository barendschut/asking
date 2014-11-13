package nl.ing.opendialogue.controller;

import nl.ing.opendialogue.domain.DialogueResponse;
import nl.ing.opendialogue.domain.MakePhoneCallState;
import nl.ing.opendialogue.repository.NavigationRuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoundCardController {

	@Autowired
	private NavigationRuleRepository navigationRuleRepository;
	
	@Autowired
	private MakePhoneCallState makePhoneCallState;
	
	@RequestMapping(value = "/validate-card", method = RequestMethod.GET)
	public DialogueResponse validateCard() {
		return navigationRuleRepository.getNextAction("/validate-card", "");
	}
	
	@RequestMapping(value = "/validate-card", method = RequestMethod.POST)
	public DialogueResponse validateCard(@RequestBody String cardNumber, @RequestBody String expiryDate) {

		if (isCardFound(cardNumber, expiryDate)) {
		
			makePhoneCallState.setMakePhoneCall(true);
			return navigationRuleRepository.getNextAction("/card-found-end",
					null);
			
		}
		return navigationRuleRepository.getNextAction("/card-found-end",
				null);
	}

	private boolean isCardFound(String cardNumber, String expiryDate) {
		return cardNumber.contains("1234123412341234") && expiryDate.contains("072017");
	}
}