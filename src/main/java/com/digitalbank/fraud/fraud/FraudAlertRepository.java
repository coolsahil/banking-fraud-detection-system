package com.digitalbank.fraud.fraud;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FraudAlertRepository extends JpaRepository<FraudAlert,Long>{}
