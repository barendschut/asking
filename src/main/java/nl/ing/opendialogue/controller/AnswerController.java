package nl.ing.opendialogue.controller;

import java.util.Arrays;
import java.util.List;

import nl.ing.opendialogue.domain.QuestionForCustomer;
import nl.ing.opendialogue.domain.DialogueResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    @RequestMapping("/answer")
    public DialogueResponse answerQuery(@RequestParam(value="query") String query) {
    	
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
			dialogueResponse.setContextUrl("http://asking.herokuapp.com/validate-card");
			return dialogueResponse;
        }

        if (query.contains("rente")) {
        	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
        	questionForCustomer.setQuestion("De huidige rentestand is -0.25%");
			List<QuestionForCustomer> questions = Arrays.asList(questionForCustomer);    		
            return new DialogueResponse(questions);

        }

    	QuestionForCustomer questionForCustomer = new QuestionForCustomer();
    	questionForCustomer.setQuestion("Ik heb uw vraag niet begrepen. Kunt u uw vraag op een andere manier stellen?");
		List<QuestionForCustomer> questions = Arrays.asList(questionForCustomer);    		
        return new DialogueResponse(questions);
        
    }
}