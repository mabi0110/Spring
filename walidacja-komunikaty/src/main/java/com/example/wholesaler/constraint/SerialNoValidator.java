package com.example.wholesaler.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SerialNoValidator implements ConstraintValidator<SerialNo, String> {

    private String startWith;
    private int codeLength;
    @Override
    public void initialize(SerialNo constraintAnnotation) {
        startWith = constraintAnnotation.startWith();
        codeLength = constraintAnnotation.codeLength();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return checkPrefix(value) && checkCodeLength(value) && checkCode(value);
    }

    private boolean checkCode(String serialNumber) {
        int prefixLength = startWith.length();
        char[] serialNumberCode = serialNumber.substring(prefixLength).toCharArray();
        for (char c : serialNumberCode) {
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    private boolean checkCodeLength(String serialNumber) {
        int prefixLength = startWith.length();
        int serialNumberLength = serialNumber.length();
        return serialNumberLength - prefixLength == codeLength;
    }

    private boolean checkPrefix(String serialNumber) {
        return serialNumber.startsWith(startWith);
    }
}
