package com.hackerrank.challenges.cubesummation.input.data.query;

import com.hackerrank.challenges.cubesummation.domain.Coordinate3D;
import com.hackerrank.challenges.cubesummation.domain.Matrix3D;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class UpdateQueryTest {

    @Test
    public void shouldExecuteUpdate() {
        Matrix3D matrix = new Matrix3D(5);
        Coordinate3D coordinate = new Coordinate3D(2, 2, 2);
        int value = 4;

        Query updateQuery = new UpdateQuery(coordinate, value);
        Optional<Void> result = updateQuery.execute(matrix);

        assertThat(result, is(equalTo(Optional.empty())));
        assertThat(matrix.get(coordinate), is(equalTo(value)));
    }

}
