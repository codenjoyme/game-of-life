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
        boolean[][] newField = new boolean[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int count = countNeighbours(x, y);
                if (field[x][y]) {
                    newField[x][y] = (count >= 2 && count <= 3);
                } else {
                    newField[x][y] = (count == 3);
                }
            }
        }

        field = newField;
    }

    private int countNeighbours(int x, int y) {
        int result = 0;
        for (int xx = -1; xx <= 1; xx++) {
            for (int yy = -1; yy <= 1; yy++) {
                if (xx == 0 && yy == 0) {
                    continue;
                }
                if (isAlive(x + xx, y + yy)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isAlive(int x, int y) {
        if (ifOutOf(x) || ifOutOf(y)) {
            return false;
        }
        return field[x][y];
    }

    private boolean ifOutOf(int a) {
        return a < 0 || a >= size;
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
