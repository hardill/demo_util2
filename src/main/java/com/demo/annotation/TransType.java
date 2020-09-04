package com.demo.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotEmpty;
import java.lang.annotation.*;

@NotEmpty(message="参数为空")
@Constraint(validatedBy = {TransTypeValidator.class})
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TransType {
	String message() default "业务不存在"; 
	Class<?>[] groups() default {}; 
	Class<? extends Payload>[] payload() default {};
}