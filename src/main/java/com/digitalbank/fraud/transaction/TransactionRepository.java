package com.digitalbank.fraud.transaction;
import org.springframework.data.jpa.repository.JpaRepository; import java.time.Instant;
public interface TransactionRepository extends JpaRepository<BankTransaction,Long>{long countBySourceAccountIdAndCreatedAtAfter(Long id,Instant after);}
