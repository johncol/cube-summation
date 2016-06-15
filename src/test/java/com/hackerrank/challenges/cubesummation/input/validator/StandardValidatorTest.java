package com.hackerrank.challenges.cubesummation.input.validator;

import com.hackerrank.challenges.cubesummation.domain.Coordinate3D;
import com.hackerrank.challenges.cubesummation.input.data.InputData;
import com.hackerrank.challenges.cubesummation.input.data.cases.TestCase;
import com.hackerrank.challenges.cubesummation.input.data.query.ReadQuery;
import com.hackerrank.challenges.cubesummation.input.data.query.UpdateQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(JUnit4.class)
public class StandardValidatorTest {

    private final InputValidator validator = new StandardValidator();

    @Test
    public void shouldPassValidation() {
        InputData data = new InputData.Builder()
                .withTestCase(new TestCase.Builder()
                        .withMatrixSize(1)
                        .withQuery(new UpdateQuery(new Coordinate3D(1, 1, 1), (long) -10e9))
                        .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(1, 1, 1)))
                        .build())
                .withTestCase(new TestCase.Builder()
                        .withMatrixSize(100)
                        .withQuery(new UpdateQuery(new Coordinate3D(100, 100, 100), (long) 10e9))
                        .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(100, 100, 100)))
                        .build())
                .build();
        validator.validate(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailValidationBecauseNumberOfTestCases() {
        InputData.Builder data = new InputData.Builder();
        IntStream.rangeClosed(1, 51).forEach(i -> data.withTestCase(new TestCase.Builder().build()));
        validator.validate(data.build());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailValidationBecauseMatrixSize() {
        InputData data = new InputData.Builder()
                .withTestCase(new TestCase.Builder()
                        .withMatrixSize(101)
                        .build())
                .build();
        validator.validate(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailValidationBecauseNumberOfQueries() {
        TestCase.Builder testCase = new TestCase.Builder()
                .withMatrixSize(1);
        IntStream.rangeClosed(1, 1001).forEach(i -> testCase.withQuery(new UpdateQuery(new Coordinate3D(1, 1, 1), 1)));
        InputData data = new InputData.Builder()
                .withTestCase(testCase.build())
                .build();
        validator.validate(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailValidationBecauseCoordinateInReadQuery() {
        InputData data = new InputData.Builder()
                .withTestCase(new TestCase.Builder()
                        .withMatrixSize(10)
                        .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(11, 11, 11)))
                        .build())
                .build();
        validator.validate(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailValidationBecauseCoordinatesInReadQuery() {
        InputData data = new InputData.Builder()
                .withTestCase(new TestCase.Builder()
                        .withMatrixSize(10)
                        .withQuery(new ReadQuery(new Coordinate3D(2, 2, 2), new Coordinate3D(1, 1, 1)))
                        .build())
                .build();
        validator.validate(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailValidationBecauseCoordinateInUpdateQuery() {
        InputData data = new InputData.Builder()
                .withTestCase(new TestCase.Builder()
                        .withMatrixSize(10)
                        .withQuery(new UpdateQuery(new Coordinate3D(100, 100, 100), 1))
                        .build())
                .build();
        validator.validate(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailValidationBecauseValueInUpdateQuery() {
        InputData data = new InputData.Builder()
                .withTestCase(new TestCase.Builder()
                        .withMatrixSize(10)
                        .withQuery(new UpdateQuery(new Coordinate3D(1, 1, 1), (long) 10e9 + 1))
                        .build())
                .build();
        validator.validate(data);
    }
}
