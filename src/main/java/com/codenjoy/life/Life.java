package com.codenjoy.life;

/**
 * Created by Oleksandr_Baglai on 2017-07-14.
 */
public class Life {
    private boolean[][] field;
    private int size;

    public Life(String stringField) {
        this.size = (int)Math.sqrt(stringField.length());
        field = new boolean[size][size];
        for (int l = 0; l < stringField.length(); l++) {
            int x = l % size;
            int y = size - 1 - l / size;

            field[x][y] = (stringField.charAt(l) == '+');
        }
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
