package nl.ing.opendialogue.domain;

import org.springframework.stereotype.Component;

@Component
public class MakePhoneCallState {

	private Boolean makePhoneCall = false;
	
	public Boolean getMakePhoneCall() {
		return makePhoneCall;
	}

	public void setMakePhoneCall(Boolean makePhoneCall) {
		this.makePhoneCall = makePhoneCall;
	}
}
