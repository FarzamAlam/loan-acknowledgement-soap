package com.example.spring.api.endpoint;

import org.example.loanacknowledgementschema.Acknowledgement;
import org.example.loanacknowledgementschema.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.spring.api.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityEndpoint {
	private static final String NAMESPACE = "http://www.example.org/LoanAcknowledgementSchema";
	
	@Autowired
	private LoanEligibilityService loanEligibilityService;
	
	@PayloadRoot(namespace=NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return loanEligibilityService.checkLoanEligibility(request);
	}
}
