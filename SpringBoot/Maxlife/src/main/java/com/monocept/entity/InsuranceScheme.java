package com.monocept.entity;

import java.util.List;

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
@Table(name = "insurancescheme")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class InsuranceScheme {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="scheme_sequence")
	@SequenceGenerator(name = "scheme_sequence", sequenceName = "scheme_sequence", initialValue = 220001)
	private int schemeid;
	@Column
	private String schemename;
	@Column
	private String schemeimageurl;
	@Column
	private String description;
	@Column
	private double minamount;
	@Column
	private double maxamount;
	@Column
	private int mininvestmenttime;
	@Column
	private int maxinvestmenttime;
	@Column
	private int minage;
	@Column
	private int maxage;
	@Column
	private int profitratio;
	@Column
	private int registrationcommision;
	@Column
	private int installmentcommision;
	@Column
	private String status;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.EAGER)//CascadeType.PERSIST,
	@JoinColumn(name = "plan_id", referencedColumnName = "planid")
	private InsurancePlan insuranceplan;
	
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.ALL},fetch = FetchType.EAGER ,orphanRemoval = true)// persisit nhi tha
	@JoinColumn(name = "scheme_id")
	@JsonIgnoreProperties("insurancescheme")
	private List<InsurancePolicy> insurancepolicies;
	

}
