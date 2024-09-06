package com.areeba.frauddetectionservice.repository;

import com.areeba.frauddetectionservice.model.FraudCheck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FraudRepository extends JpaRepository<FraudCheck, UUID> {
}
