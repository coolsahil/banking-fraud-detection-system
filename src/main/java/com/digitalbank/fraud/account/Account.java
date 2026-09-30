package com.digitalbank.fraud.account;
import com.digitalbank.fraud.customer.Customer; import jakarta.persistence.*; import lombok.*; import java.math.BigDecimal; import java.time.Instant;
@Entity @Table(name="accounts") @Getter @Setter @NoArgsConstructor
public class Account {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=34) private String accountNumber;
 @ManyToOne(optional=false,fetch=FetchType.LAZY) private Customer customer;
 @Column(nullable=false,precision=19,scale=2) private BigDecimal balance=BigDecimal.ZERO;
 @Column(nullable=false) private boolean active=true;
 @Version private long version;
 @Column(nullable=false,updatable=false) private Instant createdAt=Instant.now();
}
