package com.digitalbank.fraud.customer;
import jakarta.validation.constraints.*;
public record CustomerRequest(@NotBlank @Size(max=120) String fullName,@NotBlank @Email String email){}
