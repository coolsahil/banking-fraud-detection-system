package com.digitalbank.fraud.account;
import jakarta.validation.constraints.*; import java.math.BigDecimal;
public record AccountRequest(@NotNull Long customerId,@NotBlank @Size(max=34) String accountNumber,@NotNull @DecimalMin("0.00") BigDecimal openingBalance){}
