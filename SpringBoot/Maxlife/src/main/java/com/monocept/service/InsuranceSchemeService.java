package com.monocept.service;

import java.util.List;

import com.monocept.entity.InsurancePolicy;
import com.monocept.entity.InsuranceScheme;

public interface InsuranceSchemeService {
	
	List<InsuranceScheme> getInsuranceScheme();
	
	String updateScheme(InsuranceScheme insuranceScheme,int schemeId);
	
	public String addPolicy(InsurancePolicy insurancePolicy,int schemeId,int customerId,int agentId);

}
