package com.tribe.task.services;

import com.tribe.task.dto.FactorialResponse;

/**
 * Интерфейс, определяющий метод для вычисления факториала числа.
 */
public interface FactorialCalculator {

    /**
     * Метод для вычисления факториала числа.
     *
     * @param number число, для которого вычисляется факториал
     * @return факториал числа в виде объекта типа BigInteger
     * @throws IllegalArgumentException если передано отрицательное число
     */
    FactorialResponse calculateFactorial(int number) throws IllegalArgumentException;
}
