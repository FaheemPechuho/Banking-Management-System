package com.BankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BankingApplication.entity.Case;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {
}