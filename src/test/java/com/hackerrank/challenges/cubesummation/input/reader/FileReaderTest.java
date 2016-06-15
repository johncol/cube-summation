package com.hackerrank.challenges.cubesummation.input.reader;

import com.hackerrank.challenges.cubesummation.domain.Coordinate3D;
import com.hackerrank.challenges.cubesummation.input.data.InputData;
import com.hackerrank.challenges.cubesummation.input.data.cases.TestCase;
import com.hackerrank.challenges.cubesummation.input.data.query.Query;
import com.hackerrank.challenges.cubesummation.input.data.query.ReadQuery;
import com.hackerrank.challenges.cubesummation.input.data.query.UpdateQuery;
import com.hackerrank.challenges.cubesummation.input.parser.InputParser;
import com.hackerrank.challenges.cubesummation.input.parser.StandardParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class FileReaderTest {

    private FileReader fileReader;

    private InputParser parser = new StandardParser();

    @Test
    public void shouldReadData() throws InputReaderException {
        fileReader = new FileReader(parser, "src/test/resources/tests/input-file-test-1-success.txt");

        InputData data = fileReader.read();
        assertThat(data, is(not(nullValue())));

        List<TestCase> testCases = data.getTestCases();
        assertThat(testCases, hasSize(1));

        TestCase testCase = testCases.get(0);
        assertThat(testCase.getMatrixSize(), is(equalTo(4)));

        List<Query> queries = testCase.getQueries();
        assertThat(queries, hasSize(5));

        assertThat(queries, hasItems(
                new UpdateQuery(new Coordinate3D(2, 2, 2), 4),
                new UpdateQuery(new Coordinate3D(1, 1, 1), 23),
                new ReadQuery(new Coordinate3D(1, 1, 1), new Coordinate3D(3, 3, 3)),
                new ReadQuery(new Coordinate3D(2, 2, 2), new Coordinate3D(4, 4, 4))
        ));
    }

    @Test(expected = InputReaderException.class)
    public void shouldFailBecauseWrongInputFormat() throws InputReaderException {
        fileReader = new FileReader(parser, "src/test/resources/tests/input-file-test-2-error-format.txt");
        fileReader.read();
    }

    @Test(expected = InputReaderException.class)
    public void shouldFailBecauseFileNotFound() throws InputReaderException {
        fileReader = new FileReader(parser, "src/test/resources/tests/does-not-exist.txt");
        fileReader.read();
    }

}
