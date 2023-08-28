package com.monocept.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Customer;
import com.monocept.entity.InsurancePolicy;
import com.monocept.entity.InsuranceScheme;
import com.monocept.entity.PolicyRecord;
import com.monocept.entity.Util;
import com.monocept.repository.AgentRepository;
import com.monocept.repository.CustomerRepository;
import com.monocept.repository.InsuranceSchemeRepository;
import com.monocept.repository.PolicyRecordRepository;

@Service
public class InsuranceSchemeServiceImpl implements InsuranceSchemeService {
	
	@Autowired
	private InsuranceSchemeRepository insuranceSchemeRepository;
	
	@Autowired
	private PolicyRecordRepository policyRecordRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AgentRepository agentRepository;

	@Override
	public List<InsuranceScheme> getInsuranceScheme() {
		return insuranceSchemeRepository.findAll();
	}

	@Override
	public String updateScheme(InsuranceScheme insuranceScheme, int schemeId) {
		Optional<InsuranceScheme> dbScheme = insuranceSchemeRepository.findById(schemeId);
		
		if(dbScheme==null) return "Scheme Not Found";
		
		dbScheme.get().setSchemename(insuranceScheme.getSchemename());
		dbScheme.get().setSchemeimageurl(insuranceScheme.getSchemeimageurl());
		dbScheme.get().setDescription(insuranceScheme.getDescription());
		dbScheme.get().setMinamount(insuranceScheme.getMinamount());
		dbScheme.get().setMaxamount(insuranceScheme.getMaxamount());
		dbScheme.get().setMininvestmenttime(insuranceScheme.getMininvestmenttime());
		dbScheme.get().setMaxinvestmenttime(insuranceScheme.getMaxinvestmenttime());
		dbScheme.get().setMinage(insuranceScheme.getMinage());
		dbScheme.get().setMaxage(insuranceScheme.getMaxage());
		dbScheme.get().setProfitratio(insuranceScheme.getProfitratio());
		dbScheme.get().setRegistrationcommision(insuranceScheme.getRegistrationcommision());
		dbScheme.get().setInstallmentcommision(insuranceScheme.getInstallmentcommision());
		dbScheme.get().setStatus(insuranceScheme.getStatus());

		
		
		insuranceSchemeRepository.save(dbScheme.get());
		System.out.println("Scheme Update Success");
		
		return "Scheme Updated Successfully";
	}

	@Override
	public String addPolicy(InsurancePolicy insurancePolicy, int schemeId, int customerId, int agentId) {
	
		
		insurancePolicy.setIssuedate(Util.getTodaysDate());
		insurancePolicy.setMaturitydate(Util.getDateAfterMonths(insurancePolicy.getNoofinstallments()*insurancePolicy.getPremeiumtype()));
		
		Optional<InsuranceScheme> dbScheme = insuranceSchemeRepository.findById(schemeId);
		Optional<Customer> dbCustomer = customerRepository.findById(customerId);
		
		if(dbScheme != null && dbCustomer!=null) {
			
			
			//Adding Policy Records
			insurancePolicy.setPolicyrecords(new ArrayList<PolicyRecord>());
			for(int i=1;i <=insurancePolicy.getNoofinstallments();i++) {
				PolicyRecord newRecord = new PolicyRecord();
				newRecord.setInstallmentno(i);
				newRecord.setPaymentstatus("Pending");
				newRecord.setInstallmentamount(insurancePolicy.getPremeiumamount());
				
				if(i==1) {
					
					newRecord.setDuedate(Util.getTodaysDate());
					newRecord.setPaiddate(Util.getTodaysDate());
					newRecord.setPaymentstatus("Paid");
				}else {
					newRecord.setDuedate(Util.getDateAfterMonths((i-1)*insurancePolicy.getPremeiumtype()));
				}
				
				policyRecordRepository.save(newRecord);
				insurancePolicy.getPolicyrecords().add(newRecord);
			}
			
			
			
			insurancePolicy.setCustomer(dbCustomer.get());
			dbScheme.get().getInsurancepolicies().add(insurancePolicy);
			insuranceSchemeRepository.save(dbScheme.get());
			System.out.println("Policy Added to Customer");
			return "Policy Successfully Added";
		}else {
			return "Policy Adding Failed";
		}
		
		
	}

}
