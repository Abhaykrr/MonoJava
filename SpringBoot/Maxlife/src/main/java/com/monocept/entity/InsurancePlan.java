package com.monocept.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "insuranceplan")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class InsurancePlan {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="plan_sequence")
	@SequenceGenerator(name = "plan_sequence", sequenceName = "plan_sequence", initialValue = 210001)
	private int planid;
	@Column
	private String planname;
	@Column
	private String status;
	
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.ALL},fetch = FetchType.EAGER ,orphanRemoval = true)// persisit nhi tha
	@JoinColumn(name = "plan_id")
	@JsonIgnoreProperties("insuranceplan")
	private List<InsuranceScheme> insuranceschemes;
}
