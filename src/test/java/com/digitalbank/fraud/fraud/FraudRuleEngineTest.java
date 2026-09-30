package com.digitalbank.fraud.fraud;
import com.digitalbank.fraud.transaction.TransactionRepository; import org.junit.jupiter.api.Test; import java.math.BigDecimal; import static org.junit.jupiter.api.Assertions.*; import static org.mockito.Mockito.*;
class FraudRuleEngineTest { @Test void flagsHighAmount(){TransactionRepository r=mock(TransactionRepository.class);FraudDecision d=new FraudRuleEngine(r).evaluate(1L,new BigDecimal("150000"),"IN");assertTrue(d.flagged());assertEquals(60,d.riskScore());}}
