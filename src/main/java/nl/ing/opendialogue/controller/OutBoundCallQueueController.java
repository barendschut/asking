package nl.ing.opendialogue.controller;

import java.util.Arrays;
import java.util.List;

import nl.ing.opendialogue.domain.MakePhoneCallState;
import nl.ing.opendialogue.domain.OutBoundCallRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OutBoundCallQueueController {
	
	@Autowired
	private MakePhoneCallState makeCall;
	
	@RequestMapping("/outboundcalls")
	public List<OutBoundCallRequest> getOutboundCalls(){
		OutBoundCallRequest outBoundCallRequest = new OutBoundCallRequest();
		outBoundCallRequest.setContextUrl("/report-card-to-owner");
		outBoundCallRequest.setCustomerIdentifier("3792846");
		outBoundCallRequest.setPhoneNumber("0031627123961");
		
		if (makeCall.getMakePhoneCall()) {
			makeCall.setMakePhoneCall(false);
			return Arrays.asList(outBoundCallRequest);
		}
		return Arrays.asList();
	}
	
}
