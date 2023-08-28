package com.monocept.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "policyrecords")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PolicyRecord {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="record_sequence")
	@SequenceGenerator(name = "record_sequence", sequenceName = "record_sequence", initialValue = 240001)
	private int referenceid;
	@Column
	private int installmentno;
	@Column
	private double installmentamount;
	@Column
	private Date duedate;
	@Column
	private Date paiddate;
	@Column
	private String paymentstatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.EAGER)//CascadeType.PERSIST,
	@JoinColumn(name = "policy_no", referencedColumnName = "policyno")
	private InsurancePolicy insurancepolicy;
	
	
	

}
