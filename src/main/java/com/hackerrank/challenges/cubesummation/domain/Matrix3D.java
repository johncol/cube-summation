package com.hackerrank.challenges.cubesummation.domain;

public class Matrix3D {

    private final int[][][] matrix;
    private final int size;

    public Matrix3D(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Matrix size must be at least 1");
        }
        this.matrix = new int[size][size][size];
        this.size = size;
    }

    public void update(Coordinate3D coordinate, int value) {
        validateCoordinate(coordinate);
        matrix[coordinate.getX() - 1][coordinate.getY() - 1][coordinate.getZ() - 1] = value;
    }

    public int get(Coordinate3D coordinate) {
        validateCoordinate(coordinate);
        return matrix[coordinate.getX() - 1][coordinate.getY() - 1][coordinate.getZ() - 1];
    }

    private void validateCoordinate(Coordinate3D coordinate) {
        if (coordinate.getX() > size || coordinate.getY() > size || coordinate.getZ() > size) {
            throw new IllegalArgumentException("Coordinates cannot be out of matrix boundaries: " + size);
        }
    }

}
