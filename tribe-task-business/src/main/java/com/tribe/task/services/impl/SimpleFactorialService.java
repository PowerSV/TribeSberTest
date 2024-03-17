package com.tribe.task.services.impl;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.stream.IntStream;

@Service
public class SimpleFactorialService extends AbstractFactorialCalculator {

    @Override
    protected BigInteger calculateFactorialInternal(int number) {
        if (number < 2) {
            return BigInteger.valueOf(1);
        }

        return IntStream.rangeClosed(2, number)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .get();
    }
}
