package com.java.stringcalculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class StringCalculatorStep2 {

	public static int add(String numbers)  {
		return Optional.ofNullable(numbers).map(v -> v.split(",")).map(Arrays::stream).orElseGet(Stream::empty)
				.mapToInt(v -> StringUtils.isEmpty(v) ? 0 : Integer.parseInt(v)).sum();
	}


}
