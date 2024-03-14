package com.tribe.task.services.impl;

import com.tribe.task.dto.FactorialResponse;
import com.tribe.task.services.FactorialCalculator;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.stream.IntStream;

@Service
public class FactorialService implements FactorialCalculator {

    @Override
    public FactorialResponse calculateFactorial(int number) throws IllegalArgumentException {
        if (number < 0 || number > 100) {
            throw new IllegalArgumentException("Некорректные входные данные: " + number + " < 0 или " + number + " > 100");
        }
        if (number < 2) {
            return new FactorialResponse(BigInteger.valueOf(1));
        }

        return new FactorialResponse(
                IntStream.rangeClosed(2, number)
                        .mapToObj(BigInteger::valueOf)
                        .reduce(BigInteger::multiply)
                        .get()
        );
    }
}
