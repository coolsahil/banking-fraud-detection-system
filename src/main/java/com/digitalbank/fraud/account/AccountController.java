package com.digitalbank.fraud.account;
import com.digitalbank.fraud.customer.*; import com.digitalbank.fraud.shared.NotFoundException; import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/accounts") @RequiredArgsConstructor
public class AccountController {
 private final AccountRepository accounts; private final CustomerRepository customers;
 @PostMapping public ResponseEntity<Account> create(@Valid @RequestBody AccountRequest r){Customer c=customers.findById(r.customerId()).orElseThrow(()->new NotFoundException("Customer not found")); Account a=new Account();a.setCustomer(c);a.setAccountNumber(r.accountNumber());a.setBalance(r.openingBalance());return ResponseEntity.status(201).body(accounts.save(a));}
 @GetMapping("/{id}") public Account get(@PathVariable Long id){return accounts.findById(id).orElseThrow(()->new NotFoundException("Account not found"));}
}
