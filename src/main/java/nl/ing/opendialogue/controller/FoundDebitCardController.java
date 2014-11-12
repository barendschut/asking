package nl.ing.opendialogue.controller;

import java.util.Arrays;
import java.util.List;

import nl.ing.opendialogue.domain.QuestionForCustomer;
import nl.ing.opendialogue.domain.DialogueResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoundDebitCardController {

    private static final String HEROKU_URL = "http://asking.herokuapp.com";

    @RequestMapping(value = "/validate-card", method = RequestMethod.GET)
    public DialogueResponse validateCardQuestion() {
       
    	QuestionForCustomer questionPasnummer = new QuestionForCustomer();
    	questionPasnummer.setQuestion("Wat zijn de laatste drie cijfers van het pasnummer van de gevonden pas?");
    	questionPasnummer.setParameterName("pasNummer");
    	questionPasnummer.setRegexForAnswerGivenByCustomer("/\\d{3}/");
    	questionPasnummer.setErrorMessageForWrongInput("Dit is geen correct pasnummer");
    	
    	
    	QuestionForCustomer questionVervaldatum = new QuestionForCustomer();
    	questionVervaldatum.setQuestion("Wat is de vervaldatum van de gevonden pas?");
    	questionVervaldatum.setParameterName("vervalDatum");
    	questionVervaldatum.setRegexForAnswerGivenByCustomer("/.+/");
    	questionVervaldatum.setErrorMessageForWrongInput("Dit is geen correcte vervaldatum");    	
    	List<QuestionForCustomer> questions = Arrays.asList(questionVervaldatum, questionPasnummer);    		
		
		DialogueResponse response = new DialogueResponse(questions);
    	response.setContextUrl(HEROKU_URL +"/validate-card");
    	
    	return response;
    }
    
    @RequestMapping(value = "/validate-card", method = RequestMethod.POST)
    public DialogueResponse validateCard(ModelMap model) {

    	String cardNumber = (String) model.get("cardNumber");
    	String expiryDate = (String) model.get("expiryDate");
    	
    	//    	@RequestParam(value="cardNumber") String cardNumber, @RequestParam(value="expiryDate") String expiryDate
        if (isCardFound(cardNumber, expiryDate)) {
        	
        	QuestionForCustomer answerToClient = new QuestionForCustomer();
        	answerToClient.setQuestion("Bedankt voor het aanmelden van deze gevonden credit card! Deze pas wordt geblokkeerd.");
          	List<QuestionForCustomer> answers = Arrays.asList(answerToClient);    		
    		
    		DialogueResponse dialogueResponse = new DialogueResponse(answers);
    		dialogueResponse.setContextUrl(HEROKU_URL +"/call-customer?customerNumber="); // Go controller which handles the outbound call. This controller will get the phonenumber from MDM based on customer number.
			return dialogueResponse;
        }

    	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
    	questionForCustomer.setQuestion("Wij kunnen deze combinatie van pasnummer en vervaldatum niet herkennen.");
		List<QuestionForCustomer> answers = Arrays.asList(questionForCustomer);    		
		
		return new DialogueResponse(answers);
    }

	private boolean isCardFound(String cardNumber, String expiryDate) {
		return cardNumber.contains("1234") && expiryDate.contains("072017");
	}
}