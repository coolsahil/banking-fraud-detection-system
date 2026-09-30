package com.digitalbank.fraud.transaction;
 import org.springframework.data.web.PageableDefault;
import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.data.domain.*; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/transactions") @RequiredArgsConstructor public class TransactionController {
 private final TransactionService service; private final TransactionRepository repository;
 @PostMapping public ResponseEntity<BankTransaction> create(@Valid @RequestBody TransactionRequest r){return ResponseEntity.status(201).body(service.create(r));}
 @GetMapping public Page<BankTransaction> list(@PageableDefault(size=20,sort="createdAt",direction=Sort.Direction.DESC) Pageable p){return repository.findAll(p);}
}
