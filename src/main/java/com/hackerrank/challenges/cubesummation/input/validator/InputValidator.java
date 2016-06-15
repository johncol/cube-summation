package com.hackerrank.challenges.cubesummation.input.validator;

import com.hackerrank.challenges.cubesummation.input.data.InputData;

public interface InputValidator {
    void validate(InputData data) throws IllegalArgumentException;
}
