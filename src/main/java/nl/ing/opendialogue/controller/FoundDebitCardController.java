package nl.ing.opendialogue.controller;

import java.util.Arrays;
import java.util.List;

import nl.ing.opendialogue.domain.QuestionForCustomer;
import nl.ing.opendialogue.domain.DialogueResponse;
import nl.ing.opendialogue.repository.NavigationRuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoundDebitCardController {

  
    @Autowired 
    private NavigationRuleRepository navigationRuleRepository;
    
    @RequestMapping(value = "/validate-card", method = RequestMethod.POST)
    public DialogueResponse validateCard(ModelMap model) {

    	String cardNumber = (String) model.get("cardNumber");
    	String expiryDate = (String) model.get("expiryDate");
    	
    	//    	@RequestParam(value="cardNumber") String cardNumber, @RequestParam(value="expiryDate") String expiryDate
        if (isCardFound(cardNumber, expiryDate)) {
    		return navigationRuleRepository.getNextAction("/validate-card", "card found");
        }
		return navigationRuleRepository.getNextAction("/validate-card", "card not found");
    }

	private boolean isCardFound(String cardNumber, String expiryDate) {
		return cardNumber.contains("1234") && expiryDate.contains("072017");
	}
}