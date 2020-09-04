package com.demo.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class TransTypeValidator implements ConstraintValidator<TransType, String> {
	private final static String[] authTypes = { "WS151", "WS152", "WS153", "WS154", "WS156"};
	private final static List<String> typeList = Arrays.asList(authTypes);

	@Override
	public void initialize(TransType authType) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (typeList.contains(value)) {
			return true;
		}
		return false;
	}

}