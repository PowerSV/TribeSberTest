package com.tribe.task.services.impl;

import com.tribe.task.dto.FactorialRequest;
import com.tribe.task.dto.FactorialResponse;
import com.tribe.task.services.FactorialCalculator;

import java.math.BigInteger;

public abstract class AbstractFactorialCalculator implements FactorialCalculator {

    @Override
    public FactorialResponse calculateFactorial(FactorialRequest request) {
        int number = request.getFactorialNum();

        if (number < 0 || number > 10_000) {
            throw new IllegalArgumentException();
        }

        return new FactorialResponse(calculateFactorialInternal(number));
    }

    protected abstract BigInteger calculateFactorialInternal(int number);
}
