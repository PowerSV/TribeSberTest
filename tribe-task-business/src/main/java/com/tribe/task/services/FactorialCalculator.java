package com.tribe.task.services;

import com.tribe.task.dto.FactorialRequest;
import com.tribe.task.dto.FactorialResponse;

/**
 * Интерфейс, определяющий метод для вычисления факториала числа.
 */
public interface FactorialCalculator {

    /**
     * Метод для вычисления факториала числа.
     *
     * @param request объект запроса, содержащий число, для которого вычисляется факториал
     * @return объект ответа, содержащий результат вычисления факториала
     */
    FactorialResponse calculateFactorial(FactorialRequest request);
}
