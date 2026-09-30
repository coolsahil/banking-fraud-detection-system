package com.digitalbank.fraud.fraud;
import com.digitalbank.fraud.transaction.BankTransaction; import jakarta.persistence.*; import lombok.*; import java.time.Instant;
@Entity @Table(name="fraud_alerts") @Getter @Setter @NoArgsConstructor
public class FraudAlert {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @OneToOne(optional=false) private BankTransaction transaction;
 @Column(nullable=false) private String reason;
 @Column(nullable=false) private int riskScore;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private Status status=Status.OPEN;
 @Column(nullable=false,updatable=false) private Instant createdAt=Instant.now();
 public enum Status {OPEN,UNDER_REVIEW,CLOSED}
}
