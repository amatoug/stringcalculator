package com.java.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringCalculatorStep4Test {
	@Test
	void testAddEmptyOrNullInput() {
		String input = "";
		int sum = StringCalculatorStep4.add(input);
		assertEquals(0, sum);

		input = null;
		sum = StringCalculatorStep3.add(input);
		assertEquals(0, sum);

	}

	@Test
	void testAddSingleNumberInput() {
		String input = "1";
		int sum = StringCalculatorStep4.add(input);
		assertEquals(1, sum);

	}

	@Test
	void testAddtwoNumbersInput() {
		String input = "1,2";
		int sum = StringCalculatorStep4.add(input);
		assertEquals(3, sum);

	}
	
	@Test
	void testAddThreeNumbersWithDifferentSeparatorsInput() {
		String input = "1\n2,3";
		int sum = StringCalculatorStep4.add(input);
		assertEquals(6, sum);

	}
	
    @Test
     void testDefaultSeparator() {
		String input = "//;\n1;2;3;4;5";
		int sum = StringCalculatorStep4.add(input);
		assertEquals(15, sum);
    }
}
