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

import com.monocept.entity.InsurancePolicy;
import com.monocept.entity.InsuranceScheme;
import com.monocept.repository.InsuranceSchemeRepository;
import com.monocept.service.InsuranceSchemeService;

@RestController
@RequestMapping("/maxlife")
@CrossOrigin(origins="*")
public class InsuranceSchemeController {
	
	@Autowired
	private InsuranceSchemeService insuranceSchemeService;
	
	@GetMapping("/allschemes")
	public List<InsuranceScheme> allScheme(){
		return insuranceSchemeService.getInsuranceScheme();
		}
	
	@PostMapping("/updatescheme/{schemeid}")
	public ResponseEntity<?> updateScheme(@RequestBody InsuranceScheme insuranceScheme,@PathVariable(name = "schemeid") int schemeId){
		String status = insuranceSchemeService.updateScheme(insuranceScheme, schemeId);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	
	@PostMapping("/addpolicy/{schemeid}/{customerid}")
	public ResponseEntity<?> addPolicy(@RequestBody InsurancePolicy insurancePolicy,@PathVariable(name = "schemeid") int schemeId,@PathVariable(name = "customerid") int customerId){
		String status = insuranceSchemeService.addPolicy(insurancePolicy, schemeId, customerId, customerId);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
}
 