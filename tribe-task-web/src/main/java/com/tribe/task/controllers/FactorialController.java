package com.tribe.task.controllers;

import com.tribe.task.dto.FactorialRequest;
import com.tribe.task.dto.FactorialResponse;
import com.tribe.task.services.FactorialCalculator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    private final FactorialCalculator factorialCalculator;

    @Autowired
    public FactorialController(FactorialCalculator factorialCalculator) {
        this.factorialCalculator = factorialCalculator;
    }

    @GetMapping("/factorial")
    public ResponseEntity<FactorialResponse> getFactorial(@RequestBody @Valid FactorialRequest request) {

        return ResponseEntity.ok().body(factorialCalculator.calculateFactorial(request));
    }
}
