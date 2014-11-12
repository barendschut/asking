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

    @RequestMapping(value = "/validate-card", method = RequestMethod.GET)
    public DialogueResponse validateCardQuestion() {
       
    	QuestionForCustomer questionPasnummer = new QuestionForCustomer();
    	questionPasnummer.setQuestion("Wat is het pasnummer van de gevonden pas?");
    	questionPasnummer.setParameterName("pasNummer");
    	questionPasnummer.setRegexForAnswerGivenByCustomer("98*&");
    	questionPasnummer.setErrorMessageForWrongInput("Dit is geen correct pasnummer");
    	
    	
    	QuestionForCustomer questionVervaldatum = new QuestionForCustomer();
    	questionVervaldatum.setQuestion("Wat is de vervaldatum van de gevonden pas?");
    	questionVervaldatum.setParameterName("vervalDatum");
    	questionVervaldatum.setRegexForAnswerGivenByCustomer("D7**d&");
    	questionVervaldatum.setErrorMessageForWrongInput("Dit is geen correcte vervaldatum");    	
    	List<QuestionForCustomer> questions = Arrays.asList(questionVervaldatum, questionPasnummer);    		
		
		DialogueResponse response = new DialogueResponse(questions);
    	response.setContextUrl("/validate-card");
    	
    	return response;
    }
    
    @RequestMapping(value = "/validate-card", method = RequestMethod.POST)
    public DialogueResponse validateCard(ModelMap model) {

    	String cardNumber = (String) model.get("cardNumber");
    	String expiryDate = (String) model.get("expiryDate");
    	
    	//    	@RequestParam(value="cardNumber") String cardNumber, @RequestParam(value="expiryDate") String expiryDate
        if (cardNumber.contains("1234") && expiryDate.contains("072017")) {
        	
        	// Gevonden flow
        	// creditcard is gevonden in de backend.
        	// haal de volgende stap op in de dialogue manager
        	// dialogue manager geeft terug "u heeft de volgende gegevens ingevoerd"
        	
        	
        	QuestionForCustomer answerToClient = new QuestionForCustomer();
        	answerToClient.setQuestion("Bedankt voor het aanmelden van deze gevonden credit card! Deze pas wordt geblokkeerd.");
        	
        	List<QuestionForCustomer> answers = Arrays.asList(answerToClient);    		
    		
    		DialogueResponse dialogueResponse = new DialogueResponse(answers);
    		dialogueResponse.setContextUrl("/answer?query=");
			return dialogueResponse;
        }

    	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
    	questionForCustomer.setQuestion("Wij kunnen deze combinatie van pasnummer en vervaldatum niet herkennen.");
		List<QuestionForCustomer> answers = Arrays.asList(questionForCustomer);    		
		
		return new DialogueResponse(answers);
    }
}