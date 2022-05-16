package com.java.stringcalculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class StringCalculatorStep3 {

	public static int add(String numbers) {
		String pattern = "^\\d*([\n,]\\d*)*$";
		if (numbers!= null && numbers.matches(pattern)) {
			return Optional.ofNullable(numbers).map(v -> v.split("[\n,]")).map(Arrays::stream).orElseGet(Stream::empty)
					.mapToInt(v -> StringUtils.isEmpty(v) ? 0 : Integer.parseInt(v)).sum();

		}
		return 0;

	}
	
	public static void main(String[] args) {
		System.out.println(add(";\n1;2;3;4"));
	}

}
