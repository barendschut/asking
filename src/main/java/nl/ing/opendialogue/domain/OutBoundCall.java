package nl.ing.opendialogue.domain;

public class OutBoundCall {

	private final String phoneNumber;
	
	// url for controller which handles the call
	private final String contextUrl; 
	
	// Unique id by which we can identify the customer.
	private final String customerIdentifier;
	
	public OutBoundCall (final String phoneNumber, final String customerIdentifier, final String contextUrl) {
		this.phoneNumber = phoneNumber;
		this.customerIdentifier = customerIdentifier;
		this.contextUrl = contextUrl;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getContextUrl() {
		return contextUrl;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}
	
}
