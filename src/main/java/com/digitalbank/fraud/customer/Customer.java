package com.digitalbank.fraud.customer;
import jakarta.persistence.*; import lombok.*; import java.time.Instant;
@Entity @Table(name="customers") @Getter @Setter @NoArgsConstructor
public class Customer {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String fullName;
 @Column(nullable=false,unique=true) private String email;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private KycStatus kycStatus=KycStatus.PENDING;
 @Column(nullable=false,updatable=false) private Instant createdAt=Instant.now();
 public enum KycStatus {PENDING,VERIFIED,REJECTED}
}
