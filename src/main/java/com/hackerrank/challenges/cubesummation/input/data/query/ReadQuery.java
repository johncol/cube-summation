package com.hackerrank.challenges.cubesummation.input.data.query;

import com.hackerrank.challenges.cubesummation.domain.Coordinate3D;
import com.hackerrank.challenges.cubesummation.domain.Matrix3D;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.text.MessageFormat;
import java.util.Optional;

public class ReadQuery implements Query<Integer> {

    private final Coordinate3D start;
    private final Coordinate3D end;

    public ReadQuery(Coordinate3D start, Coordinate3D end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Optional<Integer> execute(Matrix3D matrix) {
        Coordinate3D coordinate = start.clone();
        int total = 0;
        while (coordinate.isLowerThan(end) || coordinate.equals(end)) {
            total += matrix.get(coordinate);
            coordinate = coordinate.next();
        }
        return Optional.of(total);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ReadQuery)) {
            return false;
        }
        ReadQuery other = (ReadQuery) obj;
        return new EqualsBuilder()
                .append(start, other.start)
                .append(end, other.end)
                .build();
    }

    @Override
    public int hashCode() {
        return start.hashCode() * 7 + end.hashCode() * 13;
    }

    @Override
    public String toString() {
        return MessageFormat.format("QUERY from {0} to {1}", start, end);
    }
}
