package com.digitalbank.fraud.shared;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.net.URI; import java.util.*;
@RestControllerAdvice public class ApiExceptionHandler {
 @ExceptionHandler(NotFoundException.class) ResponseEntity<ProblemDetail> notFound(NotFoundException e){ProblemDetail p=ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());p.setType(URI.create("https://digitalbank.example/problems/not-found"));return ResponseEntity.status(404).body(p);}
 @ExceptionHandler({IllegalArgumentException.class}) ResponseEntity<ProblemDetail> bad(RuntimeException e){return ResponseEntity.badRequest().body(ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,e.getMessage()));}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<ProblemDetail> validation(MethodArgumentNotValidException e){ProblemDetail p=ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,"Validation failed");p.setProperty("errors",e.getBindingResult().getFieldErrors().stream().map(x->Map.of("field",x.getField(),"message",Objects.requireNonNullElse(x.getDefaultMessage(),"invalid"))).toList());return ResponseEntity.badRequest().body(p);}
}
