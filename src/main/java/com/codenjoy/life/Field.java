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

    private class CellImpl implements Cell {
        private int x;
        private int y;

        public CellImpl(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean isAlive() {
            return field(0)[x][y];
        }

        @Override
        public void init(boolean alive) {
            field(0)[x][y] = alive;
        }

        @Override
        public void born(boolean alive) {
            field(1)[x][y] = alive;
        }
    }

    public Cell cell(int x, int y) {
        return this.new CellImpl(x, y);
    }
}
