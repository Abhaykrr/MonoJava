package com.monocept.service;

import java.util.List;

import com.monocept.entity.InsurancePlan;
import com.monocept.entity.InsuranceScheme;

public interface InsurancePlanService {
	
	List<InsurancePlan> getInsurancePlans();
	
	String addInsurancePlan(InsurancePlan insurancePlan);
	String addScheme(InsuranceScheme InsuranceScheme,int planId);
	String updatePlan(InsurancePlan insurancePlan,int planId);

}
