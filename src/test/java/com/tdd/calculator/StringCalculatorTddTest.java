package com.tdd.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class StringCalculatorTddTest {

    private StringCalculatorTdd calculatorTdd = new StringCalculatorTdd();

    @Test
    void plusTest() {
        assertEquals(12, calculatorTdd.plus(10, 2));
    }

    @Test
    void minusTest() {
        assertEquals(8, calculatorTdd.minus(10, 2));
    }

    @Test
    void multiplyTest() {
        assertEquals(20, calculatorTdd.multiply(10, 2));
    }

    @Test
    void divisionTest() {
        assertEquals(5, calculatorTdd.division(10, 2));
    }

    @Test
    void calculateTest(){
        assertEquals(10, calculatorTdd.calculate("2 + 3 * 4 / 2"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "$"})
    void partCalculatePermittedOperatorTest(String wrongValue){
//        assertEquals(3, calculatorTdd.unitCalculate(input, 1, 2));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertEquals(3, calculatorTdd.unitCalculate(wrongValue, 1, 2));
        });
    }

}