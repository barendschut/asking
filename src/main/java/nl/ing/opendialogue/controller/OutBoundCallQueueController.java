package nl.ing.opendialogue.controller;

import java.util.Arrays;
import java.util.List;

import nl.ing.opendialogue.domain.OutBoundCallRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OutBoundCallQueueController {

	@RequestMapping("/outboundcalls")
	public List<OutBoundCallRequest> getOutboundCalls(){
		// TODO: get this from parse.com
		return Arrays.asList(new OutBoundCallRequest("0031627123961", "3792846", "/report-card-to-owner"));
	}
}
