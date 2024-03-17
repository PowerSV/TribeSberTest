package com.tribe.task.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Класс FactorialResponse представляет собой ответ на запрос о вычислении факториала числа.")
public class FactorialResponse {
    @Schema(description = "Результат вычисления факториала числа.")
    private BigInteger result;
}
