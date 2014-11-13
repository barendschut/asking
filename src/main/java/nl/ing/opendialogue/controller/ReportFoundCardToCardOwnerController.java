package nl.ing.opendialogue.controller;

import nl.ing.opendialogue.domain.OutBoundCallRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportFoundCardToCardOwnerController {

	@RequestMapping("/report-card-to-owner")
	public void blockFoundCard(@RequestBody OutBoundCallRequest outboundCallRequest) {

		/** 
		 * perform the outbound call and dialogue
		 */
	}
}
