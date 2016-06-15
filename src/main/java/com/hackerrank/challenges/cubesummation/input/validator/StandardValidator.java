package com.hackerrank.challenges.cubesummation.input.validator;

import com.hackerrank.challenges.cubesummation.domain.Coordinate3D;
import com.hackerrank.challenges.cubesummation.input.data.InputData;
import com.hackerrank.challenges.cubesummation.input.data.cases.TestCase;
import com.hackerrank.challenges.cubesummation.input.data.query.ReadQuery;
import com.hackerrank.challenges.cubesummation.input.data.query.UpdateQuery;

public class StandardValidator implements InputValidator {

    @Override
    public void validate(InputData data) throws IllegalArgumentException {
        validateNumberOfTestCases(data);
        data.getTestCases().forEach(testCase -> {
            validateMatrixSize(testCase);
            validateNumberOfQueries(testCase);
            validateUpdateQueries(testCase);
            validateReadQueries(testCase);
        });
    }

    private static void validateNumberOfTestCases(InputData data) {
        if (data.getNumberOfTestCases() < 1 || data.getNumberOfTestCases() > 50) {
            throw new IllegalArgumentException("Constrain: 1 <= T <= 50");
        }
    }

    private static void validateMatrixSize(TestCase testCase) {
        if (testCase.getMatrixSize() < 1 || testCase.getMatrixSize() > 100) {
            throw new IllegalArgumentException("Constrain: 1 <= N <= 100");
        }
    }

    private static void validateNumberOfQueries(TestCase testCase) {
        if (testCase.getNumberOfQueries() < 1 || testCase.getNumberOfQueries() > 1000) {
            throw new IllegalArgumentException("Constrain: 1 <= M <= 1000");
        }
    }

    private static void validateUpdateQueries(TestCase testCase) {
        testCase.getQueries().stream()
                .filter(q -> q instanceof UpdateQuery)
                .map(q -> (UpdateQuery) q)
                .forEach(query -> {
                    Coordinate3D coordinate = query.getCoordinate();
                    validateCoordinate(testCase, coordinate.getX());
                    validateCoordinate(testCase, coordinate.getY());
                    validateCoordinate(testCase, coordinate.getZ());
                    validateUpdateValue(query);
                });
    }

    private static void validateReadQueries(TestCase testCase) {
        int matrixSize = testCase.getMatrixSize();
        testCase.getQueries().stream()
                .filter(q -> q instanceof ReadQuery)
                .map(q -> (ReadQuery) q)
                .forEach(query -> {
                    Coordinate3D start = query.getStart();
                    Coordinate3D end = query.getEnd();
                    validateCoordinates(start.getX(), end.getX(), matrixSize);
                    validateCoordinates(start.getY(), end.getY(), matrixSize);
                    validateCoordinates(start.getZ(), end.getZ(), matrixSize);
                });
    }

    private static void validateCoordinate(TestCase testCase, int coordinate) {
        if (coordinate < 1 || coordinate > testCase.getMatrixSize()) {
            throw new IllegalArgumentException("Constrain: 1 <= x,y,z <= N");
        }
    }

    private static void validateUpdateValue(UpdateQuery query) {
        if (query.getValue() < -10e9 || query.getValue() > 10e9) {
            throw new IllegalArgumentException("Constrain: -10e9 <= W <= 10e9");
        }
    }

    private static void validateCoordinates(int coordinate1, int coordinate2, int matrixSize) {
        if (!(1 <= coordinate1 && coordinate1 <= coordinate2 && coordinate2 <= matrixSize)) {
            throw new IllegalArgumentException("Constrain: 1 <= x1,y1,z1 <= x2,y2,z2 <= N");
        }
    }

}
