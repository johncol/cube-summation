package com.hackerrank.challenges.cubesummation.input.parser;

import com.hackerrank.challenges.cubesummation.input.data.InputData;

public interface InputParser<T> {
    InputData parse(T rawData) throws InputParseException;
}
