package nl.ing.opendialogue.controller;

import nl.ing.opendialogue.domain.OutBoundCallRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportFoundCardToCardOwnerController {

	@RequestMapping(value = "/report-card-to-owner", method = RequestMethod.POST)
	public String blockFoundCard(@RequestBody OutBoundCallRequest outboundCallRequest) {

		/** 
		 * perform the outbound call and dialogue
		 */

		return "Bedankt. U krijgt snel een nieuwe pas toegestuurd";
	}

	// JUST FOR TESTING
	@RequestMapping(value = "/report-card-to-owner", method = RequestMethod.GET)
	public String blockFoundCard() {

		/** 
		 * perform the outbound call and dialogue
		 */
		return "Bedankt. U krijgt snel een nieuwe pas toegestuurd. Maar je moet wel de POST gebruiken en deze method vergeten";
	}

}


