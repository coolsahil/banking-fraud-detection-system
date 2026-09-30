package com.digitalbank.fraud.transaction;
import jakarta.validation.constraints.*; import java.math.BigDecimal;
public record TransactionRequest(@NotNull Long accountId,@NotNull @DecimalMin("0.01") BigDecimal amount,@NotNull BankTransaction.Channel channel,@NotBlank String deviceId,@NotBlank @Size(min=2,max=2) String countryCode){}
