package com.codenjoy.life;

/**
 * Created by Oleksandr_Baglai on 2017-07-14.
 */
public class Life {
    private boolean[][] field;
    private int size;

    public Life(int size) {
        field = new boolean[size][size];
        this.size = size;
    }

    public void tick() {

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int y = size - 1; y >= 0; y--) {
            for (int x = 0; x < size; x++) {
                result.append((field[x][y]) ? "+" : ".");
            }
        }

        return result.toString();
    }
}
