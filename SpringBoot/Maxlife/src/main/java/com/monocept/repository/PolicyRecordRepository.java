package com.monocept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.entity.PolicyRecord;

public interface PolicyRecordRepository extends JpaRepository<PolicyRecord, Integer> {

}
