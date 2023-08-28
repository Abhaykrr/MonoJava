package com.monocept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.InsurancePlan;
import com.monocept.entity.InsuranceScheme;
import com.monocept.repository.InsurancePlanRepository;

@Service
public class InsurancePlanServiceImpl implements InsurancePlanService{
	
	@Autowired
	private InsurancePlanRepository insurancePlanRepository;

	@Override
	public List<InsurancePlan> getInsurancePlans() {
		
		return insurancePlanRepository.findAll();
	}

	@Override
	public String addInsurancePlan(InsurancePlan insurancePlan) {
		insurancePlanRepository.save(insurancePlan);
		return "Plan Added Successfully";
	}

	@Override
	public String addScheme(InsuranceScheme InsuranceScheme,int planId) {
		
		Optional<InsurancePlan> dbPlan = insurancePlanRepository.findById(planId);
		
		if(dbPlan == null) return "Plan Not Found";
		
		dbPlan.get().getInsuranceschemes().add(InsuranceScheme);
		
		insurancePlanRepository.save(dbPlan.get());
		
		return "Scheme Added Successfully";
	}

	@Override
	public String updatePlan(InsurancePlan insurancePlan, int planId) {
		Optional<InsurancePlan> dbPlan = insurancePlanRepository.findById(planId);
		
		if(dbPlan == null) return "Plan Not Found";
				
				dbPlan.get().setPlanname(insurancePlan.getPlanname());
				dbPlan.get().setStatus(insurancePlan.getStatus());
				
				insurancePlanRepository.save(dbPlan.get());
				System.out.println("Plan Update Success");
		return "Plan Update Successfull";
	}

}
