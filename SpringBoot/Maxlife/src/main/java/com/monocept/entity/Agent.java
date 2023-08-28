package com.monocept.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "agent")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Agent {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="agent_sequence")
	@SequenceGenerator(name = "agent_sequence", sequenceName = "agent_sequence", initialValue = 40401)
	private int agentid;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String qualification;
	@Column
	private String status;

}
