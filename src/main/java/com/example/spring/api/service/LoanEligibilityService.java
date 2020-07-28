package com.example.spring.api.service;

import java.util.List;

import org.example.loanacknowledgementschema.Acknowledgement;
import org.example.loanacknowledgementschema.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class LoanEligibilityService {
	public Acknowledgement checkLoanEligibility(CustomerRequest request) {
		Acknowledgement acknowledgement = new Acknowledgement();
		List<String> mismatchCriteria = acknowledgement.getCriteriaMismatch();
		
		if (!(request.getAge()>=30 && request.getAge()<=60)) {
			mismatchCriteria.add("Age should be more than equal to 30 and less than equal to 60");
		}
		if(!(request.getYearlyIncome()>200000)) {
			mismatchCriteria.add("Minimum yearly income should be more than 200000");
		}
		if(!(request.getCibilScore() > 500)) {
			mismatchCriteria.add("Cibil Score should be more than 500");
		}
		if(mismatchCriteria.size()>0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		}else {
			acknowledgement.setApprovedAmount(request.getYearlyIncome()*2);
			acknowledgement.setIsEligible(true);
			mismatchCriteria.clear();
		}
		return acknowledgement;
	}
}
