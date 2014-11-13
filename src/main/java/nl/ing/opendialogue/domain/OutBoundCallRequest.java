package nl.ing.opendialogue.domain;

public class OutBoundCallRequest {

	private String phoneNumber;

	// url for controller which handles the call
	private String contextUrl;

	// Unique id by which we can identify the customer.
	private String customerIdentifier;

	public OutBoundCallRequest() {
	}

//	public OutBoundCallRequest(final String phoneNumber,
//			final String customerIdentifier, final String contextUrl) {
//		this.phoneNumber = phoneNumber;
//		this.customerIdentifier = customerIdentifier;
//		this.contextUrl = contextUrl;
//	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContextUrl() {
		return contextUrl;
	}

	public void setContextUrl(String contextUrl) {
		this.contextUrl = contextUrl;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

}
