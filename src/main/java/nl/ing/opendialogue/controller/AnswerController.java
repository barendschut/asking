package nl.ing.opendialogue.controller;

import nl.ing.opendialogue.domain.Channel;
import nl.ing.opendialogue.domain.DialogueResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    @RequestMapping("/answer")
    public DialogueResponse answerQuery(@RequestParam(value="query") String query, @RequestParam(value="channel") Channel channel) {

        if (query.contains("pas") && query.contains("gevonden")) {
            return new DialogueResponse("Geef pasnummer en vervaldatum");
        }

        if (query.contains("rente")) {
            return new DialogueResponse("De rente is momenteel -0,25 procent");
        }

        return new DialogueResponse("Kunt u de vraag op een andere manier stellen?");
        
    }
}