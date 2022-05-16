package com.java.stringcalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorStep1Test {
	@Test
	void testAddEmptyOrNullInput() {
		String input = "";
		int sum = StringCalculatorStep1.add(input);
		assertEquals(0, sum);

		input = null;
		sum = StringCalculatorStep1.add(input);
		assertEquals(0, sum);

	}

	@Test
	void testAddSingleNumberInput() {
		String input = "1";
		int sum = StringCalculatorStep1.add(input);
		assertEquals(1, sum);

	}

	@Test
	void testAddtwoNumbersInput() {
		String input = "1,2";
		int sum = StringCalculatorStep1.add(input);
		assertEquals(3, sum);

	}
}
