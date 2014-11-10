package nl.ing.opendialogue.controller;

import nl.ing.opendialogue.domain.DialogueResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoundDebitCardController {

    @RequestMapping(value = "/validate-card", method = RequestMethod.GET)
    public DialogueResponse validateCardQuestion() {
        return new DialogueResponse("Geef pasnummer en vervaldatum");
    }
    
    @RequestMapping(value = "/validate-card/card-number/{cardNumber}/expiryDate/{expiryDate}", method = RequestMethod.GET)
    public DialogueResponse validateCard(@PathVariable(value="cardNumber") String cardNumber, @PathVariable(value="expiryDate") String expiryDate) {

        if (cardNumber.contains("1234") && expiryDate.contains("072017")) {
            return new DialogueResponse("Bedankt! Deze pas wordt geblokkeerd.");
        }

        return new DialogueResponse("Wij kunnen deze combinatie van pasnummer en vervaldatum niet herkennen.");
    }
}