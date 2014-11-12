package nl.ing.opendialogue.controller;

import nl.ing.opendialogue.domain.DialogueResponse;
import nl.ing.opendialogue.repository.NavigationRuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
	
	@Value("${host.url}")
    private String HEROKU_URL;

    @Autowired 
    private NavigationRuleRepository navigationRuleRepository;
    
	@RequestMapping("/answer")
    public DialogueResponse answerQuery(final String query) {
		return navigationRuleRepository.getNextAction(query);
    }
}