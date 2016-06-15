package com.hackerrank.challenges.cubesummation.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class Coordinate3DTest {

    @Test
    public void shouldCreateCoordinate() {
        int x = 1;
        int y = 2;
        int z = 3;

        Coordinate3D coordinate = new Coordinate3D(x, y, z);

        assertThat(coordinate.getX(), is(equalTo(x)));
        assertThat(coordinate.getY(), is(equalTo(y)));
        assertThat(coordinate.getZ(), is(equalTo(z)));
    }

    @Test
    public void shouldCreateNextCoordinate() {
        Coordinate3D coordinate = new Coordinate3D(1, 2, 3);
        Coordinate3D nextCoordinate = coordinate.next();

        assertThat(nextCoordinate.getX(), is(equalTo(coordinate.getX() + 1)));
        assertThat(nextCoordinate.getY(), is(equalTo(coordinate.getY() + 1)));
        assertThat(nextCoordinate.getZ(), is(equalTo(coordinate.getZ() + 1)));
    }

    @Test
    public void shouldVerifyCoordinateIsLowerThan() {
        Coordinate3D coordinate1 = new Coordinate3D(1, 2, 3);
        Coordinate3D coordinate2 = new Coordinate3D(4, 4, 4);

        assertThat(coordinate1.isLowerThan(coordinate2), is(equalTo(true)));
        assertThat(coordinate2.isLowerThan(coordinate1), is(equalTo(false)));
    }

    @Test
    public void shouldVerifyCoordinatesAreEqual() {
        int x = 1;
        int y = 2;
        int z = 3;

        Coordinate3D coordinate1 = new Coordinate3D(x, y, z);
        Coordinate3D coordinate2 = new Coordinate3D(x, y, z);

        assertThat(coordinate1.equals(coordinate2), is(equalTo(true)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailCoordinateCreation() {
        new Coordinate3D(1, 1, 0);
    }

}
