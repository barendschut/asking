package nl.ing.opendialogue.domain;

import javax.annotation.PostConstruct;

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

	@PostConstruct
	public void sayHello(){
		System.out.println("SAY HELLO!!!");
		System.out.println("SAY HELLO!!!");
		System.out.println(this);
		System.out.println("SAY HELLO!!!");
		System.out.println("SAY HELLO!!!");
		
	}
}
