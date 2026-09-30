package com.digitalbank.fraud.customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor; 
import org.springframework.data.domain.*;
 import org.springframework.http.*; 
 import org.springframework.web.bind.annotation.*;
 import org.springframework.data.web.PageableDefault;
@RestController 
@RequestMapping("/api/customers") 
@RequiredArgsConstructor
public class CustomerController {
private final CustomerRepository repository;
 @PostMapping public ResponseEntity<Customer> create(@Valid @RequestBody CustomerRequest r){
  if(repository.existsByEmail(r.email())) 
  throw new IllegalArgumentException("Email already exists");
  Customer c=new Customer(); 
  c.setFullName(r.fullName()); 
  c.setEmail(r.email());
   return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(c));
 }
 @GetMapping public Page<Customer> list(@PageableDefault(size=20,sort="id") Pageable p){return repository.findAll(p);}
 @GetMapping("/{id}") public Customer get(@PathVariable Long id){return repository.findById(id).orElseThrow(()->new com.digitalbank.fraud.shared.NotFoundException("Customer not found"));}
}
