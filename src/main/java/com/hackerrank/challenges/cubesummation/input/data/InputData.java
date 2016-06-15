package com.hackerrank.challenges.cubesummation.input.data;

import com.hackerrank.challenges.cubesummation.input.data.cases.TestCase;

import java.util.ArrayList;
import java.util.List;

public class InputData {

    private final List<TestCase> testCases;

    public InputData(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public int getNumberOfTestCases() {
        return testCases.size();
    }

    public static class Builder {

        private List<TestCase> testCases = new ArrayList<>();

        public Builder() { }

        public Builder withTestCase(TestCase testCase) {
            testCases.add(testCase);
            return this;
        }

        public InputData build() {
            return new InputData(testCases);
        }
    }

}
