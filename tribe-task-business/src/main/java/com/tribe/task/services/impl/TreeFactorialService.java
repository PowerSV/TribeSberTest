package com.tribe.task.services.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@Primary
public class TreeFactorialService extends AbstractFactorialCalculator {

    @Override
    public BigInteger calculateFactorialInternal(int number) {
        if (number < 2) {
            return BigInteger.valueOf(1);
        }

        return factTree(number);
    }

    private BigInteger prodTree(int l, int r) {
        if (l > r)
            return BigInteger.ONE;
        if (l == r)
            return BigInteger.valueOf(l);
        if (r - l == 1)
            return BigInteger.valueOf(l).multiply(BigInteger.valueOf(r));
        int m = (l + r) / 2;
        return prodTree(l, m).multiply(prodTree(m + 1, r));
    }

    private BigInteger factTree(int n) {
        if (n < 2) {
            return BigInteger.ONE;
        }
        if (n == 2) {
            return BigInteger.valueOf(n);
        }
        return prodTree(2, n);
    }
}
