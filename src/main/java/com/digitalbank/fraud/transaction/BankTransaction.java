package com.digitalbank.fraud.transaction;
import com.digitalbank.fraud.account.Account; import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.time.Instant;
@Entity @Table(name="bank_transactions") @Getter @Setter @NoArgsConstructor
public class BankTransaction {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false,fetch=FetchType.LAZY) private Account sourceAccount;
 @Column(nullable=false,precision=19,scale=2) private BigDecimal amount;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private Channel channel;
 @Column(nullable=false) private String deviceId;
 @Column(nullable=false) private String countryCode;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private Status status=Status.APPROVED;
 @Column(nullable=false) private int riskScore;
 @Column(nullable=false,updatable=false) private Instant createdAt=Instant.now();
 public enum Channel {UPI,IMPS,NEFT,RTGS,CARD} public enum Status {APPROVED,FLAGGED,DECLINED}
}
