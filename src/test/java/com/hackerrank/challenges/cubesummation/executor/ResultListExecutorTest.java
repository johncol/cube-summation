package com.hackerrank.challenges.cubesummation.executor;

import com.hackerrank.challenges.cubesummation.domain.Coordinate3D;
import com.hackerrank.challenges.cubesummation.input.data.cases.TestCase;
import com.hackerrank.challenges.cubesummation.input.data.query.ReadQuery;
import com.hackerrank.challenges.cubesummation.input.data.query.UpdateQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ResultListExecutorTest {

    private final ResultListExecutor executor = new ResultListExecutor();

    @Test
    public void shouldExecuteOneTestCase() {
        TestCase testCase = new TestCase.Builder()
                .withMatrixSize(3)
                .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(3, 3, 3)))
                .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(2, 2, 2)))
                .withQuery(new ReadQuery(new Coordinate3D(2, 2, 2), new Coordinate3D(3, 3, 3)))
                .withQuery(new ReadQuery(new Coordinate3D(3, 3, 3), new Coordinate3D(3, 3, 3)))
                .withQuery(new UpdateQuery(new Coordinate3D(2, 2, 2), 1))
                .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(3, 3, 3)))
                .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(2, 2, 2)))
                .withQuery(new ReadQuery(new Coordinate3D(2, 2, 2), new Coordinate3D(3, 3, 3)))
                .withQuery(new ReadQuery(new Coordinate3D(3, 3, 3), new Coordinate3D(3, 3, 3)))
                .build();

        List<Integer> result = executor.execute(testCase);
        List<Integer> expectedResult = Arrays.asList(0, 0, 0, 0, 1, 1 , 1, 0);
        assertThat(result, is(equalTo(expectedResult)));
    }

    @Test
    public void shouldExecuteSeveralTestCases() {
        TestCase testCase1 = new TestCase.Builder()
                .withMatrixSize(2)
                .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(2, 2, 2)))
                .withQuery(new UpdateQuery(new Coordinate3D(1, 1, 1), 10))
                .withQuery(new UpdateQuery(new Coordinate3D(2, 2, 2), 50))
                .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(1, 1, 1)))
                .withQuery(new ReadQuery(new Coordinate3D(2, 2, 2), new Coordinate3D(2, 2, 2)))
                .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(2, 2, 2)))
                .build();
        TestCase testCase2 = new TestCase.Builder()
                .withMatrixSize(1)
                .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(1, 1, 1)))
                .withQuery(new UpdateQuery(new Coordinate3D(1, 1, 1), 100))
                .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(1, 1, 1)))
                .withQuery(new UpdateQuery(new Coordinate3D(1, 1, 1), 200))
                .withQuery(new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(1, 1, 1)))
                .build();
        List<TestCase> testCases = Arrays.asList(testCase1, testCase2);

        List<Integer> result = executor.execute(testCases);
        List<Integer> expectedResult = Arrays.asList(0, 10, 50, 60, 0, 100, 200);
        assertThat(result, is(equalTo(expectedResult)));
    }
}
