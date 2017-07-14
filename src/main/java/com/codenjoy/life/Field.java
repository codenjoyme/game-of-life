package com.codenjoy.life;

/**
 * Created by Oleksandr_Baglai on 2017-07-14.
 */
public class Field {
    private boolean[][][] field;
    private int current = 0;

    public Field(int size) {
        field = new boolean[2][size][size];
    }

    public boolean[][] field(int main) {
        return field[(current + main) % 2];
    }

    public void replace() {
        current++;
    }

    public void init(int x, int y, boolean cell) {
        field(0)[x][y] = cell;
    }

    public void born(int x, int y, boolean cell) {
        field(1)[x][y] = cell;
    }

    public boolean isAlive(int x, int y) {
        return field(0)[x][y];
    }
}
