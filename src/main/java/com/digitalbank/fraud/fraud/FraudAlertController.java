package com.digitalbank.fraud.fraud;
 import org.springframework.data.web.PageableDefault;
import lombok.RequiredArgsConstructor; import org.springframework.data.domain.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/fraud-alerts") @RequiredArgsConstructor public class FraudAlertController {private final FraudAlertRepository repository; @GetMapping public Page<FraudAlert> list(@PageableDefault(size=20) Pageable p){return repository.findAll(p);}}
