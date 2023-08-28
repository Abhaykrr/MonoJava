package com.monocept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.entity.InsuranceScheme;

public interface InsuranceSchemeRepository extends JpaRepository<InsuranceScheme, Integer> {
	
	
}
