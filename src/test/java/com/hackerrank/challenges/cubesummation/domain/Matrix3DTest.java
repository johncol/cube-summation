package com.hackerrank.challenges.cubesummation.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class Matrix3DTest {

    @Test
    public void shouldCreateMatrix() {
        int size = 3;
        Matrix3D matrix = new Matrix3D(size);
        for (int x = 1; x <= size; x++) {
            for (int y = 1; y <= size; y++) {
                for (int z = 1; z <= size; z++) {
                    Coordinate3D coordinate = new Coordinate3D(x, y, z);
                    assertThat(matrix.get(coordinate), is(equalTo(0)));
                }
            }
        }
    }

    @Test
    public void shouldUpdateAndGetValue() {
        Matrix3D matrix = new Matrix3D(3);
        Coordinate3D coordinate = new Coordinate3D(1, 2, 3);

        assertThat(matrix.get(coordinate), is(equalTo(0)));
        int newValue = 33;
        matrix.update(coordinate, newValue);
        assertThat(matrix.get(coordinate), is(equalTo(newValue)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailMatrixCreation() {
        new Matrix3D(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailMatrixUpdate() {
        Matrix3D matrix = new Matrix3D(3);
        Coordinate3D coordinate = new Coordinate3D(4, 4, 4);
        matrix.update(coordinate, 1);
    }

}
