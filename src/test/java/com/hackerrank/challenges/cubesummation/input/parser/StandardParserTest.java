package com.hackerrank.challenges.cubesummation.input.parser;

import com.hackerrank.challenges.cubesummation.domain.Coordinate3D;
import com.hackerrank.challenges.cubesummation.input.data.InputData;
import com.hackerrank.challenges.cubesummation.input.data.cases.TestCase;
import com.hackerrank.challenges.cubesummation.input.data.query.Query;
import com.hackerrank.challenges.cubesummation.input.data.query.ReadQuery;
import com.hackerrank.challenges.cubesummation.input.data.query.UpdateQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class StandardParserTest {

    private final StandardParser parser = new StandardParser();

    @Test
    public void shouldParseUpdateQueryTypes() throws InputParseException {
        List<String> lines = Arrays.asList(
                "1",
                "4 3",
                "UPDATE 2 2 2 4",
                "UPDATE 1 1 1 2",
                "UPDATE 3 3 3 1"
        );

        InputData data = parser.parse(lines);
        assertThat(data, is(not(nullValue())));

        List<TestCase> testCases = data.getTestCases();
        assertThat(testCases, hasSize(1));

        TestCase testCase = testCases.get(0);
        assertThat(testCase.getMatrixSize(), is(equalTo(4)));

        List<Query> queries = testCase.getQueries();
        assertThat(queries, hasSize(3));

        assertThat(queries, hasItems(
                new UpdateQuery(new Coordinate3D(2, 2, 2), 4),
                new UpdateQuery(new Coordinate3D(1, 1, 1), 2),
                new UpdateQuery(new Coordinate3D(3, 3, 3), 1))
        );
    }

    @Test
    public void shouldParseReadQueryTypes() throws InputParseException {
        List<String> lines = Arrays.asList(
                "2",
                "2 1",
                "QUERY 2 2 2 3 3 3",
                "10 2",
                "QUERY 1 1 1 10 10 10",
                "QUERY 3 3 3 6 6 6"
        );

        InputData data = parser.parse(lines);
        assertThat(data, is(not(nullValue())));

        List<TestCase> testCases = data.getTestCases();
        assertThat(testCases, hasSize(2));

        TestCase testCase1 = testCases.get(0);
        assertThat(testCase1.getMatrixSize(), is(equalTo(2)));

        List<Query> queries1 = testCase1.getQueries();
        assertThat(queries1, hasSize(1));

        assertThat(queries1, hasItems(
                new ReadQuery(new Coordinate3D(2, 2, 2), new Coordinate3D(3, 3, 3))));

        TestCase testCase2 = testCases.get(1);
        assertThat(testCase2.getMatrixSize(), is(equalTo(10)));

        List<Query> queries2 = testCase2.getQueries();
        assertThat(queries2, hasSize(2));

        assertThat(queries2, hasItems(
                new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(10, 10, 10)),
                new ReadQuery(new Coordinate3D(3, 3, 3), new Coordinate3D(6, 6, 6)))
        );
    }

    @Test(expected = InputParseException.class)
    public void shouldFailBecauseUnparseableNumber() throws InputParseException {
        List<String> lines = Arrays.asList(
                "one",
                "4 2",
                "UPDATE 2 2 2 4",
                "UPDATE 1 1 1 2"
        );
        parser.parse(lines);
    }

    @Test(expected = InputParseException.class)
    public void shouldFailBecauseNotEnoughData() throws InputParseException {
        List<String> lines = Arrays.asList(
                "1",
                "4",
                "UPDATE 2 2 2 4",
                "UPDATE 1 1 1 2"
        );
        parser.parse(lines);
    }

    @Test(expected = InputParseException.class)
    public void shouldFailBecauseNotEnoughQueries() throws InputParseException {
        List<String> lines = Arrays.asList(
                "1",
                "4 3",
                "UPDATE 2 2 2 4",
                "UPDATE 1 1 1 2"
        );
        parser.parse(lines);
    }

    @Test(expected = InputParseException.class)
    public void shouldFailBecauseUnknownQueryCommand() throws InputParseException {
        List<String> lines = Arrays.asList(
                "1",
                "4 1",
                "DELETE 2 2 2 4"
        );
        parser.parse(lines);
    }

}
