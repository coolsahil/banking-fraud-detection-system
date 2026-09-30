package com.digitalbank.fraud.fraud;
import com.digitalbank.fraud.transaction.*; import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import java.math.BigDecimal; import java.time.*;
@Service @RequiredArgsConstructor public class FraudRuleEngine {
 private final TransactionRepository transactions;
 public FraudDecision evaluate(Long accountId,BigDecimal amount,String country){int score=0;StringBuilder r=new StringBuilder();
  if(amount.compareTo(new BigDecimal("100000"))>0){score+=60;r.append("high amount; ");}
  long recent=transactions.countBySourceAccountIdAndCreatedAtAfter(accountId,Instant.now().minus(Duration.ofMinutes(2)));
  if(recent>=5){score+=50;r.append("velocity threshold; ");}
  if(!"IN".equalsIgnoreCase(country)){score+=30;r.append("foreign location; ");}
  return new FraudDecision(Math.min(score,100),score>=60,r.isEmpty()?"no rule matched":r.toString().trim());}
}
