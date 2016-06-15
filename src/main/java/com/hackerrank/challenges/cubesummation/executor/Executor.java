package com.hackerrank.challenges.cubesummation.executor;

import com.hackerrank.challenges.cubesummation.input.data.cases.TestCase;

import java.util.List;

public interface Executor<T> {
    T execute(TestCase testCase);
    T execute(List<TestCase> testCases);
}
