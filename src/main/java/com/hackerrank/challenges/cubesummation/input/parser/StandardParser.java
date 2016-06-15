package com.hackerrank.challenges.cubesummation.input.parser;

import com.hackerrank.challenges.cubesummation.domain.Coordinate3D;
import com.hackerrank.challenges.cubesummation.input.data.InputData;
import com.hackerrank.challenges.cubesummation.input.data.cases.TestCase;
import com.hackerrank.challenges.cubesummation.input.data.query.Query;
import com.hackerrank.challenges.cubesummation.input.data.query.QueryTypes;
import com.hackerrank.challenges.cubesummation.input.data.query.ReadQuery;
import com.hackerrank.challenges.cubesummation.input.data.query.UpdateQuery;
import org.apache.commons.lang3.StringUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class StandardParser implements InputParser<List<String>> {

    private static final String SEPARATOR = StringUtils.SPACE;

    private final NumberFormat formatter = NumberFormat.getInstance();

    @Override
    public InputData parse(List<String> lines) throws InputParseException {
        InputData.Builder inputData = new InputData.Builder();
        try {
            int numberOfTestCases = intValueOf(lines.get(0));
            int lineIndex = 1;
            for (int i = 0; i < numberOfTestCases; i++) {
                String[] sizeAndQueries = lines.get(lineIndex).split(SEPARATOR);
                TestCase.Builder testCase = new TestCase.Builder()
                        .withMatrixSize(intValueOf(sizeAndQueries[0]));
                int numberOfQueries = intValueOf(sizeAndQueries[1]);
                int testCaseEndLine = lineIndex + numberOfQueries;
                for (lineIndex++; lineIndex <= testCaseEndLine; lineIndex++) {
                    String queryLine = lines.get(lineIndex);
                    Query query = parseQuery(queryLine);
                    testCase.withQuery(query);
                }
                inputData.withTestCase(testCase.build());
            }
        } catch (ParseException | RuntimeException e) {
            e.printStackTrace();
            throw new InputParseException("Invalid format", e);
        }
        return inputData.build();
    }

    private Query parseQuery(String line) throws ParseException {
        QueryTypes queryType = QueryTypes.valueOf(line.split(SEPARATOR)[0]);
        if (queryType.equals(QueryTypes.UPDATE)) {
            return parseUpdateQuery(line);
        } else if (queryType.equals(QueryTypes.QUERY)) {
            return parseReadQuery(line);
        }
        throw new IllegalArgumentException("Query type not supported: " + queryType);
    }

    private Query parseUpdateQuery(String line) throws ParseException {
        String[] queryPart = line.split(SEPARATOR);
        Coordinate3D coordinate = new Coordinate3D(intValueOf(queryPart[1]), intValueOf(queryPart[2]), intValueOf(queryPart[3]));
        int value = intValueOf(queryPart[4]);
        return new UpdateQuery(coordinate, value);
    }

    private Query parseReadQuery(String line) throws ParseException {
        String[] queryPart = line.split(SEPARATOR);
        Coordinate3D start = new Coordinate3D(intValueOf(queryPart[1]), intValueOf(queryPart[2]), intValueOf(queryPart[3]));
        Coordinate3D end = new Coordinate3D(intValueOf(queryPart[4]), intValueOf(queryPart[5]), intValueOf(queryPart[6]));
        return new ReadQuery(start, end);
    }

    private int intValueOf(String input) throws ParseException {
        return formatter.parse(input).intValue();
    }

}
