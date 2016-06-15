package com.hackerrank.challenges.cubesummation.executor;

import com.hackerrank.challenges.cubesummation.domain.Matrix3D;
import com.hackerrank.challenges.cubesummation.input.data.cases.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultListExecutor implements Executor<List<Integer>> {

    @Override
    public List<Integer> execute(TestCase testCase) {
        Matrix3D matrix = new Matrix3D(testCase.getMatrixSize());
        List<Integer> results = new ArrayList<>();
        testCase.getQueries().forEach(query ->
                query.execute(matrix).ifPresent(r -> results.add((Integer) r)));
        return results;
    }

    @Override
    public List<Integer> execute(List<TestCase> testCases) {
        return testCases.stream()
                .flatMap(testCase -> execute(testCase).stream())
                .collect(Collectors.toList());
    }
}
