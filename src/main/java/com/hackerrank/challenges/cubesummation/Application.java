package com.hackerrank.challenges.cubesummation;

import com.hackerrank.challenges.cubesummation.executor.ResultListExecutor;
import com.hackerrank.challenges.cubesummation.input.data.InputData;
import com.hackerrank.challenges.cubesummation.input.parser.InputParser;
import com.hackerrank.challenges.cubesummation.input.parser.StandardParser;
import com.hackerrank.challenges.cubesummation.input.reader.FileReader;
import com.hackerrank.challenges.cubesummation.input.reader.InputReader;
import com.hackerrank.challenges.cubesummation.input.reader.InputReaderException;
import com.hackerrank.challenges.cubesummation.input.validator.StandardValidator;
import com.hackerrank.challenges.cubesummation.input.validator.InputValidator;

import java.util.List;

public class Application {

    private static final String TEST_FILE = "src/main/resources/inputs/sample-1.txt";

    public static void main(String[] args) throws InputReaderException {
        InputParser parser = new StandardParser();
        InputReader reader = new FileReader(parser, TEST_FILE);
        InputValidator validator = new StandardValidator();
        ResultListExecutor executor = new ResultListExecutor();
        InputData data = reader.read();
        validator.validate(data);
        List<Integer> results = executor.execute(data.getTestCases());
        results.forEach(System.out::println);
    }

}

