package com.hackerrank.challenges.cubesummation.input.data.query;

import com.hackerrank.challenges.cubesummation.domain.Matrix3D;

import java.util.Optional;

public interface Query<T> {
    Optional<T> execute(Matrix3D matrix);
}
