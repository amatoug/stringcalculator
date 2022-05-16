package com.java.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class StringCalculatorStep1 {

	public static int add(String numbers) {
		String pattern = "^\\d*,{0,1}\\d*$";
		if (numbers!= null && numbers.matches(pattern)) {
			List<String> list = Arrays.asList(numbers.split(","));
			return Optional.ofNullable(list).map(List::stream).orElseGet(Stream::empty)
					.mapToInt(v -> StringUtils.isEmpty(v) ? 0 : Integer.parseInt(v)).sum();

		}
		return 0;
	}
}
