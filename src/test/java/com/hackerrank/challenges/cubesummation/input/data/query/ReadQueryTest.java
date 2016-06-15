package com.hackerrank.challenges.cubesummation.input.data.query;

import com.hackerrank.challenges.cubesummation.domain.Coordinate3D;
import com.hackerrank.challenges.cubesummation.domain.Matrix3D;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ReadQueryTest {

    @Test
    public void shouldExecuteReads() {
        Matrix3D matrix = new Matrix3D(5);
        Coordinate3D coordinate1 = new Coordinate3D(1, 1, 1);
        Coordinate3D coordinate2 = new Coordinate3D(2, 2, 2);
        Coordinate3D coordinate3 = new Coordinate3D(3, 3, 3);
        Coordinate3D coordinate4 = new Coordinate3D(4, 4, 4);
        int value1 = 1;
        int value2 = 2;
        int value3 = 3;

        Arrays.asList(
                new UpdateQuery(coordinate1, value1),
                new UpdateQuery(coordinate2, value2),
                new UpdateQuery(coordinate3, value3)
        ).forEach(q -> q.execute(matrix));

        Query query1 = new ReadQuery(coordinate1, coordinate2);
        Optional<Integer> result1 = query1.execute(matrix);
        assertThat(result1.get(), is(equalTo(value1 + value2)));

        Query query2 = new ReadQuery(coordinate2, coordinate3);
        Optional<Integer> result2 = query2.execute(matrix);
        assertThat(result2.get(), is(equalTo(value2 + value3)));

        Query query3 = new ReadQuery(coordinate1, coordinate3);
        Optional<Integer> result3 = query3.execute(matrix);
        assertThat(result3.get(), is(equalTo(value1 + value2 +value3)));

        Query query4 = new ReadQuery(coordinate1, coordinate4);
        Optional<Integer> result4 = query4.execute(matrix);
        assertThat(result4.get(), is(equalTo(value1 + value2 +value3)));
    }

}
