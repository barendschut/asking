package nl.ing.opendialogue.controller;

import java.util.Arrays;
import java.util.List;

import nl.ing.opendialogue.domain.DialogueResponse;
import nl.ing.opendialogue.domain.QuestionForCustomer;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    private static final String HEROKU_URL = "http://asking.herokuapp.com";

	@RequestMapping("/answer")
    public DialogueResponse answerQuery(final String query) {
    	
		if (StringUtils.isEmpty(query)) {

        	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
        	questionForCustomer.setQuestion("Welkom bij de ING. Waarmee kan ik u helpen?");
			List<QuestionForCustomer> questions = Arrays.asList(questionForCustomer);    		
    		
    		return new DialogueResponse(questions);
    	}

        if (query.contains("pas") && query.contains("gevonden")) {
        	
        	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
        	List<QuestionForCustomer> questions = Arrays.asList(questionForCustomer);
			
            DialogueResponse dialogueResponse = new DialogueResponse(questions);
			dialogueResponse.setContextUrl(HEROKU_URL + "/validate-card");
			return dialogueResponse;
        }

        if (query.contains("rente")) {
        	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
        	questionForCustomer.setQuestion("De huidige rentestand is -0.25%");
			List<QuestionForCustomer> questions = Arrays.asList(questionForCustomer);    		
            return new DialogueResponse(questions);

        }

    	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
    	questionForCustomer.setQuestion("Met deze vraag kunnen wij u niet helpen. Iets er iets anders waarmee wij u van dienst kunnen zijn?");
		List<QuestionForCustomer> questions = Arrays.asList(questionForCustomer);    		
        return new DialogueResponse(questions);
        
    }
}