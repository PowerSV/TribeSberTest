package com.tribe.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Класс FactorialRequest представляет собой запрос на вычисление факториала числа.")
public class FactorialRequest {

    @NotNull(message = "Некорректные входные данные: число не должно быть null")
    @PositiveOrZero(message = "Некорректные входные данные: число не должно быть отрицательным")
    @Max(value = 100, message = "Некорректные входные данные: число не должно превышать 100")
    @JsonProperty("factorial_num")
    @Schema(description = "Число, для которого будет вычисляться факториал.")
    private Integer factorialNum;

}
