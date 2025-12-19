package com.example.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void sumTest() {
        Calculator calc = new Calculator();
        assertEquals(8.0, calc.sum(5.0, 3.0));
    }

    @Test
    public void numbersNullSumTest() {
        Calculator calc = new Calculator();
        assertThrows(NullPointerException.class, () -> calc.sum(null, 1.0));
        assertThrows(NullPointerException.class, () -> calc.sum(1.0, null));
    }

    @Test
    void subTest() {
       Calculator calc = new Calculator();
       assertEquals(2.0, calc.sub(5.0, 3.0));
    }

    @Test
    void divideTest() {
       Calculator calc = new Calculator();
       assertEquals(2.0, calc.divide(6.0, 3.0));
    }

    @Test
    public void divisionByZeroTest() {
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class, () -> calc.divide(1.0, 0.0));
    }

    @Test
    void factorialTest() {
        Calculator calc = new Calculator();
        assertEquals(120, calc.factorial(5));
    }

    @Test
    void integerToBinaryTest() {
       Calculator calc = new Calculator();
       assertEquals(Integer.valueOf(101), calc.integerToBinary(5));
    }

    @Test
    void integerToHexadecimalTest() {
       Calculator calc = new Calculator();
       assertEquals("AA", calc.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
       Calculator calc = new Calculator();
       LocalDate d1 = LocalDate.of(2020, 3, 15);
       LocalDate d2 = LocalDate.of(2020, 3, 29);
       assertEquals(14, calc.calculeDayBetweenDate(d1, d2));
    }
}
