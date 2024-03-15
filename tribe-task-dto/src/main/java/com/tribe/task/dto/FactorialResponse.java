package com.tribe.task.dto;

import lombok.*;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FactorialResponse {
    private BigInteger result;
}
