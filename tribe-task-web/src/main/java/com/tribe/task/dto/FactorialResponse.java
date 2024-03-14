package com.tribe.task.dto;

import java.math.BigInteger;

public class FactorialResponse {
    private BigInteger result;

    public FactorialResponse(BigInteger result) {
        this.result = result;
    }

    public BigInteger getResult() {
        return result;
    }

    public void setResult(BigInteger result) {
        this.result = result;
    }
}
