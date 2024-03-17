package com.tribe.task.controllers;

import com.tribe.task.dto.FactorialRequest;
import com.tribe.task.dto.FactorialResponse;
import com.tribe.task.services.FactorialCalculator;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/factorial")
@Tag(name = "FactorialController", description = "Контроллер для вычисления факториала")
public class FactorialController {

    private final FactorialCalculator factorialCalculator;
    private final MeterRegistry meterRegistry;

    @Autowired
    public FactorialController(FactorialCalculator factorialCalculator, MeterRegistry meterRegistry) {
        this.factorialCalculator = factorialCalculator;
        this.meterRegistry = meterRegistry;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Вычислить факториал",
            description = "Вычисляет факториал заданного числа")
    public ResponseEntity<FactorialResponse> getFactorial(@RequestBody @Valid FactorialRequest request) {

        meterRegistry.counter("factorial_count", List.of()).increment();

        Timer timer = meterRegistry.timer("factorial_timer", List.of());
        FactorialResponse response = timer.record(() -> factorialCalculator.calculateFactorial(request));

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
