package com.java.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class StringCalculatorStep5 {

	public static int add(String numbers) {
		String sep = getSeparator(numbers.split("\n")[0]);
		List<String> negatives = getNegativeNumbers(numbers);
		if (!negatives.isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed " + String.join(",", negatives));
		}
		return Optional.ofNullable(getNumbers(numbers)).map(v -> v.split(sep)).map(Arrays::stream)
				.orElseGet(Stream::empty).mapToInt(v -> StringUtils.isEmpty(v) ? 0 : Integer.parseInt(v)).sum();

	}

	private static String getSeparator(String firstLine) {
		if (NumberUtils.isCreatable(firstLine) || StringUtils.isEmpty(firstLine)) {
			return "[^-?\\d]+";
		}
		if (firstLine.startsWith("//")) {
			return Character.toString(firstLine.charAt(2));
		}
		return "[^-?\\d]+";

	}

	private static String getNumbers(String text) {
		if (text.startsWith("//"))
			return text.substring(text.indexOf("\n"));
		return text;

	}

	private static List<String> getNegativeNumbers(String text) {
		String numbers = null;

		if (text.startsWith("//"))
			numbers = text.substring(text.indexOf("\n"));
		numbers = text;
		List<String> negatives = Arrays.stream(numbers.split("[^-?\\d]+"))
				.filter(i -> Integer.parseInt(i) < 0).collect(Collectors.toList());
		return negatives;

	}
}
