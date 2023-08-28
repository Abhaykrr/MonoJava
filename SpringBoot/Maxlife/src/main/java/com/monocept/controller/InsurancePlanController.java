package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.InsurancePlan;
import com.monocept.entity.InsuranceScheme;
import com.monocept.service.InsurancePlanService;

@RestController
@RequestMapping("/maxlife")
@CrossOrigin(origins="*")
public class InsurancePlanController {
	
	@Autowired
	private InsurancePlanService insurancePlanService;
	
	@PostMapping("/addplan")
	public ResponseEntity<?> addPlan(@RequestBody InsurancePlan insurancePlan){
		String status = insurancePlanService.addInsurancePlan(insurancePlan);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	
	@GetMapping("/allplans")
	public List<InsurancePlan> allPlans(){
		return insurancePlanService.getInsurancePlans();
	}
	
	@PostMapping("/addscheme/{planid}")
	public ResponseEntity<?> addScheme(@RequestBody InsuranceScheme insuranceScheme,@PathVariable(name = "planid") int planId){
		String status = insurancePlanService.addScheme(insuranceScheme, planId);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	
	@PostMapping("/updateplan/{planid}")
	public ResponseEntity<?> updatePlan(@RequestBody InsurancePlan insurancePlan,@PathVariable(name = "planid") int planId){
		String status = insurancePlanService.updatePlan(insurancePlan, planId);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}

}
