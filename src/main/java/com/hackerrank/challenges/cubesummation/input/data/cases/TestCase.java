package com.hackerrank.challenges.cubesummation.input.data.cases;

import com.hackerrank.challenges.cubesummation.input.data.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TestCase {

    private final int matrixSize;
    private final List<Query> queries;

    public TestCase(int matrixSize, List<Query> queries) {
        this.matrixSize = matrixSize;
        this.queries = queries;
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    public List<Query> getQueries() {
        return queries;
    }

    public int getNumberOfQueries() {
        return queries.size();
    }

    public static class Builder {

        private int matrixSize;
        private List<Query> queries = new ArrayList<>();

        public Builder() {}

        public Builder withMatrixSize(int matrixSize) {
            this.matrixSize = matrixSize;
            return this;
        }

        public Builder withQuery(Query query) {
            this.queries.add(query);
            return this;
        }

        public TestCase build() {
            return new TestCase(matrixSize, queries);
        }
    }

}
