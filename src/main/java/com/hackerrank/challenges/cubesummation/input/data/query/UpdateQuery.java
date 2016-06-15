package com.hackerrank.challenges.cubesummation.input.data.query;

import com.hackerrank.challenges.cubesummation.domain.Coordinate3D;
import com.hackerrank.challenges.cubesummation.domain.Matrix3D;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.text.MessageFormat;
import java.util.Optional;

public class UpdateQuery implements Query<Void> {

    private final Coordinate3D coordinate;
    private final int value;

    public UpdateQuery(Coordinate3D coordinate, int value) {
        this.coordinate = coordinate;
        this.value = value;
    }

    @Override
    public Optional<Void> execute(Matrix3D matrix) {
        matrix.update(coordinate, value);
        return Optional.empty();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof UpdateQuery)) {
            return false;
        }
        UpdateQuery other = (UpdateQuery) obj;
        return new EqualsBuilder()
                .append(coordinate, other.coordinate)
                .append(value, other.value)
                .build();
    }

    @Override
    public int hashCode() {
        return coordinate.hashCode() * 7 + value * 13;
    }

    @Override
    public String toString() {
        return MessageFormat.format("UPDATE {0} to {1}", coordinate, value);
    }
}
