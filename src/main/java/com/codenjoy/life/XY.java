package com.codenjoy.life;

/**
 * Created by Oleksandr_Baglai on 2017-07-14.
 */
public class XY {
    private int size;

    public XY(int size) {
        this.size = size;
    }

    public int getX(int length) {
        return length % size;
    }

    public int getY(int length) {
        return (size - 1) - length / size;
    }

    public int getLength(int x, int y) {
        return ((size - 1) - y)*size + x;
    }
}
