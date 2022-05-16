package com.java.stringcalculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class StringCalculatorStep4 {

	public static int add(String numbers) {
		char separator = getSeparator(numbers.split("\n")[0]);
			return Optional.ofNullable(getNumbers(numbers)).map(v -> v.split("[\n"+separator+"]")).map(Arrays::stream).orElseGet(Stream::empty)
					.mapToInt(v -> StringUtils.isEmpty(v) ? 0 : Integer.parseInt(v)).sum();

	}

	private static char getSeparator(String firstLine) {
		if (NumberUtils.isCreatable(firstLine) || StringUtils.isEmpty(firstLine)) {
			return ',';
		}
		if (firstLine.startsWith("//")) {
			return firstLine.charAt(2);
		}
		return ',';

	}
	private static String getNumbers(String text) {
		if (text.startsWith("//"))
			return text.substring(text.indexOf("\n"));
		return text;

	}
}
