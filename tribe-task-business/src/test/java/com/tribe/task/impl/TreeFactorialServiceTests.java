package com.tribe.task.impl;

import com.tribe.task.dto.FactorialRequest;
import com.tribe.task.dto.FactorialResponse;
import com.tribe.task.services.impl.TreeFactorialService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TreeFactorialServiceTests {

    private TreeFactorialService serviceUnderTest;

    @BeforeEach
    public void setUp() {
        serviceUnderTest = new TreeFactorialService();
    }

    @Test
    public void testCalculateFactorial_NegativeNumber() {
        FactorialRequest request = new FactorialRequest();
        request.setFactorialNum(-1);

        assertThrows(IllegalArgumentException.class,
                () -> serviceUnderTest.calculateFactorial(request));
    }

    @Test
    public void testCalculateFactorial_NumberGreaterThan100() {
        FactorialRequest request = new FactorialRequest();
        request.setFactorialNum(10_001);

        assertThrows(IllegalArgumentException.class,
                () -> serviceUnderTest.calculateFactorial(request));
    }

    @Test
    public void testCalculateFactorial_NumberLessThan2() {
        FactorialRequest request = new FactorialRequest();

        request.setFactorialNum(1);
        FactorialResponse response = serviceUnderTest.calculateFactorial(request);
        assertEquals(BigInteger.ONE, response.getResult());

        request.setFactorialNum(0);
        response = serviceUnderTest.calculateFactorial(request);
        assertEquals(BigInteger.ONE, response.getResult());
    }

    @Test
    public void testCalculateFactorial_NumberGreaterThan2() {
        FactorialRequest request = new FactorialRequest();
        request.setFactorialNum(5);

        FactorialResponse response = serviceUnderTest.calculateFactorial(request);
        assertEquals(new BigInteger("120"), response.getResult());

        request.setFactorialNum(10);
        response = serviceUnderTest.calculateFactorial(request);
        assertEquals(new BigInteger("3628800"), response.getResult());

        request.setFactorialNum(100);
        response = serviceUnderTest.calculateFactorial(request);
        assertEquals(new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"),
                response.getResult()
        );
    }

    @Test
    public void testFactorialProperty() {
        for (int num = 1; num < 10_000; num++) {
            FactorialRequest request1 = new FactorialRequest(num);
            FactorialRequest request2 = new FactorialRequest(num - 1);

            FactorialResponse response1 = serviceUnderTest.calculateFactorial(request1);
            FactorialResponse response2 = serviceUnderTest.calculateFactorial(request2);

            BigInteger result = response1.getResult().divide(response2.getResult());
            assertEquals(BigInteger.valueOf(num), result);
        }
    }
}
