package com.monocept.entity;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "insurancepolicy")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class InsurancePolicy {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="policy_sequence")
	@SequenceGenerator(name = "policy_sequence", sequenceName = "policy_sequence", initialValue = 230001)
	private int policyno;
	@Column
	private Date issuedate;
	@Column
	private Date maturitydate;
	@Column
	private int premeiumtype;
	@Column
	private int noofinstallments;
	@Column
	private double amount;
	@Autowired
	private double interestamount;
	@Column
	private int premeiumamount;
	@Column
	private String status;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.EAGER)//CascadeType.PERSIST,
	@JoinColumn(name = "scheme_id", referencedColumnName = "schemeid")
	private InsuranceScheme insurancescheme;
	
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.ALL},fetch = FetchType.EAGER ,orphanRemoval = true)// persisit nhi tha
	@JoinColumn(name = "policy_no")
	@JsonIgnoreProperties("insurancepolicy")
	private List<PolicyRecord> policyrecords;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.EAGER)//CascadeType.PERSIST,
	@JoinColumn(name = "customer_id", referencedColumnName = "customerid")
	private Customer customer;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.EAGER)//CascadeType.PERSIST,
	@JoinColumn(name = "agent_id", referencedColumnName = "agentid")
	private Agent agent;
	

}
