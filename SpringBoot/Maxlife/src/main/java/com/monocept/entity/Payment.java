package com.monocept.entity;

import java.sql.Date;

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
@Table(name = "payment")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Payment {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="payment_sequence")
	@SequenceGenerator(name = "payment_sequence", sequenceName = "payment_sequence", initialValue = 250001)
	private int paymentid;
	@Column
	private String paymenttype;
	@Column
	private double amount;
	@Column
	private Date date;
	@Column
	private double tax;
	@Column
	private double toublepaymnet;

}
