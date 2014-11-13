package nl.ing.opendialogue.controller;

import java.util.Arrays;
import java.util.List;

import nl.ing.opendialogue.domain.OutBoundCall;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OutBoundCallQueueController {

	@RequestMapping("/outboundcalls")
	public List<OutBoundCall> getOutboundCalls(){
		
		// get this from parse.com
		return Arrays.asList(new OutBoundCall("0031627123961", "3792846", "/block-card"));
	}
	
}
