package com.hackerrank.challenges.cubesummation.domain;

import java.text.MessageFormat;

public class Coordinate3D {

    private final int x;
    private final int y;
    private final int z;

    public Coordinate3D(int x, int y, int z) {
        if (x < 1 || y < 1 || z < 1) {
            throw new IllegalArgumentException("Coordinates must greater than 0");
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinate3D next() {
        return new Coordinate3D(x + 1, y + 1, z + 1);
    }

    public boolean isLowerThan(Coordinate3D other) {
        return x < other.x && y < other.y && z < other.z;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Coordinate3D)) {
            return false;
        }
        Coordinate3D other = (Coordinate3D) obj;
        return x == other.x && y == other.y && z == other.z;
    }

    @Override
    public int hashCode() {
        return x * 3 + y * 5 + z * 13;
    }

    @Override
    public Coordinate3D clone() {
        return new Coordinate3D(x, y, z);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return MessageFormat.format("({0},{1},{2})", x, y, z);
    }
}
